import java.sql.*;
import java.util.ArrayList;

public class DBConnect {
	private Connection con;
	private String query;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public DBConnect() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/battleship?useSSL=false";
			String username = "root";
			String password = "DLSU1234!";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean isUsernameAvailable(String username) {		
		query = "SELECT username FROM userinfo WHERE username = '" + username + "'";
		try {
			rs = st.executeQuery(query);
			if (rs.next())
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void addUser(String username, String password) {
		query = "INSERT INTO userinfo (username, password)" +
				"VALUES (?, ?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String username, String password) {
		query = "SELECT userID FROM userinfo WHERE username = '" + username +
				"' AND password = '" + password + "'";
		try {
			rs = st.executeQuery(query);
			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<String> getUserInfo(int userID) {
		ArrayList<String> info = new ArrayList<String>();
		query = "SELECT username, password, profilepic FROM userinfo WHERE userID = " + userID;
		try {
			rs = st.executeQuery(query);
			if (rs.next()) {
				info.add(rs.getString(1));
				info.add(rs.getString(2));
				info.add(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return info;
	}
	
	public void updateProfilePic(String username, String picpath) {
		query = "UPDATE userinfo " +
				"SET profilepic = ? " +
				"WHERE username = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, picpath);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
