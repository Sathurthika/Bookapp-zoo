package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.ConnectionUtil;

public class UserDAO {
	
	
	public void register(User user) throws Exception {
        String sql = "insert into users ( name, email, password) values ( ?, ? ,? )";
        Connection con= ConnectionUtil.getConnection();
        PreparedStatement pst=con.prepareStatement(sql);
        		pst.setString(1, user.getName());
	        	pst.setString(2, user.getEmail());
        		pst.setString(3, user.getPassword());
          int rows=pst.executeUpdate(); 
          System.out.println(rows);

        System.out.println("UserDAO-> register: " + user);
    
	}
	 public User login(String email, String password) throws Exception {
	        String sql = "select id,name,email,password from users where email = ? and password = ? ";
	        Connection con=ConnectionUtil.getConnection();
	        PreparedStatement pst=con.prepareStatement(sql);
	        pst.setString(1, email);
        	pst.setString(2, password);       
    		User user = null;
    		ResultSet rs=pst.executeQuery();
    		if(rs.next()){
    			int id=rs.getInt("id");
    			String name=rs.getString("name");
    			String email1=rs.getString("email");
    			String password1=rs.getString("password");
    			
    			user=new User();
    			user.setId(id);
    			user.setName(name);
    			user.setEmail(email1);
    			user.setPassword(password1);

    		}
	        System.out.println(user);
	 
	        return user;
	 
	    }
	}
