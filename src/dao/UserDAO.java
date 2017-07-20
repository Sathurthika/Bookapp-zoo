package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;

import model.User;
import util.ConnectionUtil;

public class UserDAO {
	private JdbcTemplate jdbctemplate=ConnectionUtil.getJdbcTemplate();

	
	public void register(User user) throws Exception {
        String sql = "insert into users ( name, email, password) values ( ?, ? ,? )";
		Object[] params={ user.getName(),user.getEmail(),user.getPassword()};

		int rows = jdbctemplate.update(sql,params);        
		System.out.println(rows);

        System.out.println("UserDAO-> register: " + user);
    
	}
	 public User login(String email, String password) throws Exception {
	        String sql = "select id,name,email,password from users where email = ? and password = ? ";
            Object[] params={email,password};
            User list =jdbctemplate.queryForObject(sql, params,(rs,rowNum) ->{

    			int id=rs.getInt("id");
    			String name=rs.getString("name");
    			String email1=rs.getString("email");
    			String password1=rs.getString("password");
    			
    			User u=new User();
    			u.setId(id);
    			u.setName(name);
    			u.setEmail(email1);
    			u.setPassword(password1);
return u;
    		});
	        System.out.println(list);
	 
	        return list;
	 
	    }
	}
