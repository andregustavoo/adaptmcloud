package br.ufrn.frascati.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.frascati.model.Product;

public class DAOProductLocal implements IDAOProduct {
	
	private final static String DB="jdbc:mysql://localhost:3306/dbcommerce";
	private final static String USER="root";
	private final static String PWD="c3f3t";
	@Override
	public List<Product> getProducts() {
		List<Product> products=new ArrayList<Product>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(DB, USER, PWD);
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql="select productname,value from dbcommerce.product";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				products.add(new Product(rs.getString("productname"),rs.getDouble("value")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
