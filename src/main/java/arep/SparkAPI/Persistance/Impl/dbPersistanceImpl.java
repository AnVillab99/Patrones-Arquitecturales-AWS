package arep.SparkAPI.Persistance.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import arep.SparkAPI.Persistance.dbPersistance;

public class dbPersistanceImpl implements dbPersistance{

    private final static String url = "jdbc:mysql://awslab2arep.cpxtk3c7tqrq.us-east-1.rds.amazonaws.com:3306/dbAWSLab2Arep";
	private final static String user = "admin";
	private final static String password = "123456789q";


    HashMap<String,String> db = new HashMap<String,String>();

    public dbPersistanceImpl(){

    }

    private Connection connection(){
        Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the mysql server successfully.");
		} catch (SQLException e) {
			System.out.println("error " + e.getMessage());
		}

		return conn;

    }

    @Override
    public Boolean userExists(String email) {
		boolean correcto=false;
		ResultSet rs = null;
		String SQL = "select exists(select * from Users WHERE email=(?))";
		try {Connection conn = connection();
			PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getString(1)=="1"){
					correcto=true;
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return correcto;
    }

    @Override
    public Boolean registerUser(String name, String email) {
        if(!userExists(email)){
			long id = 0;
			String SQL = "INSERT INTO Users(name,email) " + "VALUES(?,?)";
			try (Connection conn = connection();
				PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

				pstmt.setString(1, name);
				pstmt.setString(2, email);

				int affectedRows = pstmt.executeUpdate();
				// check the affected rows
				if (affectedRows > 0) {
					// get the ID back
					try (ResultSet rs = pstmt.getGeneratedKeys()) {
						if (rs.next()) {
							id = rs.getLong(1);
						}
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				return false;
			}
			return true;
		}
		return false;
    }

    @Override
    public String[] getAllUsers() {
        ResultSet rs = null;
		String SQL = "select * from Users";
        String[] res = null;
        
		try {
			Connection conn = connection();
			PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			rs = pstmt.executeQuery();
			ArrayList<String> us = new ArrayList<String>();
			while(rs.next()){
                us.add(rs.getString("name")+"&"+rs.getString("email"));

			}
			res=new String[us.size()];
			for(int i=0;i<us.size();i++){
				res[i]=us.get(i);

			}
			
			
		} catch (SQLException ex) {
			System.out.println("Error en la consulta dentro de db: ");
			System.out.println(ex.getMessage());
		}

		
		return res;
    }

}