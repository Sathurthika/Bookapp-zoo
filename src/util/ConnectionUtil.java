package util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {

    public static DataSource getDataSource() {
 
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/app_db");
        ds.setUsername("root");
        ds.setPassword("root");     
        return ds;
 
    }
     
    public static JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        DataSource dataSource = getDataSource();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
	
	/* public static Connection getConnection() throws Exception {
		 
	        Connection con = null;
	 
	        try {Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
	        
	             
	        } catch (Exception e) {
	            throw new Exception(e);
	        }
	         
	        return con;
	 
	    }*/

}
