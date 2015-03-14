package br.ufrn.services.server.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RackspaceDatabaseService {
	public double connectDatabaseRackspace(String host,String user,String pwd){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(host, user, pwd);
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql="select sum(value) from monitor.product";
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			return rs.getDouble(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Double.NaN;
		
		
	}
}
