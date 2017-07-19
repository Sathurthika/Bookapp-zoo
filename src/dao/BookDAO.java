package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import util.ConnectionUtil;

public class BookDAO {
	public void register(Book user) throws Exception {
		String sql = "insert into books(name,price,published_date,author_id) values (?, ?, ? ,? )";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setInt(2, user.getPrice());
		pst.setDate(3, Date.valueOf(user.getPublishedDate()));
		pst.setInt(4, user.getAuthorId());
		int rows = pst.executeUpdate();
		System.out.println(rows);

		System.out.println("BookDAO-> register: " + user);
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