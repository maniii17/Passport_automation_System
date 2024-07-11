package interfaces;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Main.ConnectionDb;


public class Applicant {
	private int IdentityNumber;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String Gender;
	private String Placeofbirth;
	private int Dateofbirth;
	private String Address;
	private int ContactNumber;
	private String Email;
	
	public Applicant(int IdentityNumber, String FirstName, String MiddleName, String LastName, String Gender, String Placeofbirth, int Dateofbirth,String Address,int ContactNumber,String Email) {
		this.IdentityNumber = IdentityNumber;
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.Gender = Gender;
		this.Placeofbirth = Placeofbirth;
		this.Dateofbirth = Dateofbirth;
		this.Address = Address;
		this.ContactNumber = ContactNumber;
		this.Email = Email;
	}

	public int getIdentityNumber() {
		return IdentityNumber;
	}

	public void setIdentityNumber(int identityNumber) {
		IdentityNumber = identityNumber;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPlaceofbirth() {
		return Placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		Placeofbirth = placeofbirth;
	}

	public int getDateofbirth() {
		return Dateofbirth;
	}

	public void setDateofbirth(int dateofbirth) {
		Dateofbirth = dateofbirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(int contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	public void  insertApplicant(int IdentityNumber, String FirstName, String MiddleName, String LastName, String Gender, String Placeofbirth, int Dateofbirth,String Address,int ContactNumber,String Email) {	

	
		try {
			String sql = "INSERT INTO Applicant ( IdentityNumber,  FirstName,  MiddleName,  LastName,  Gender,  Placeofbirth,  Dateofbirth, Address, ContactNumber, Email)VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			
			ConnectionDb ob = new ConnectionDb();
			Connection conn = ob.connectDB();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, IdentityNumber); 
			statement.setString(2, FirstName);
			statement.setString(3, MiddleName);
			statement.setString(4, LastName);
			statement.setString(5, Gender);
			statement.setString(6, Placeofbirth); 
			statement.setInt(7, Dateofbirth); 
			statement.setString(8, Address);
			statement.setInt(9, ContactNumber);
			statement.setString(10, Email);
			
			int rowsInserted  = statement.executeUpdate();
			
			if (rowsInserted > 0) {
				System.out.println("Data inserted successfully!");

				}
				else {
				System.out.println("Data insertion Failed!");				}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}

	public void insertApplicant(String identityNumber2, String firstName2, String middleName2, String lastName2,
			String gender2, String placeofbirth2, String dateofbirth2, String address2, String contactNumber2,
			String email2) {
		// TODO Auto-generated method stub
		
	}

	
	
	}
	
	
	

	
	


	