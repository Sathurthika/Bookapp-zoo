package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Book;
import util.ConnectionUtil;

public class BookDAO {
	private JdbcTemplate jdbctemplate=ConnectionUtil.getJdbcTemplate();
	public void register(Book user) throws Exception {
		String sql = "insert into books(name,price,published_date,author_id) values (?, ?, ? ,? )";

		Object[] params={ user.getName(),user.getPrice(),Date.valueOf(user.getPublishedDate()),user.getAuthorId()};
		int rows = jdbctemplate.update(sql,params);
		System.out.println(rows);
	}

	public List<Book> listbook() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,price,author_id,published_date from books";
		PreparedStatement pst = con.prepareStatement(sql);
		List<Book> bookList = new ArrayList<Book>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int author_id = rs.getInt("author_id");
			Date published_date = rs.getDate("published_date");
			Book b = new Book();
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
			b.setAuthorId(author_id);
			b.setPublishedDate(published_date.toLocalDate());

			bookList.add(b);
		}
		System.out.println(bookList);
		for (Book b : bookList) {
			System.out.println(b);

		}
		return bookList;
	}
}