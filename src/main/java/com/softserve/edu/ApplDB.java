package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplDB {
	public static void main(String[] args) throws SQLException {
		String username = "lv542";
		String password = "Pa$$lv542";
		String url = "jdbc:mysql://192.168.153.128:3306/lv542";
		//
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("Connection Successful! \n");
		} else {
			System.out.println("Connection ERROR \n");
			System.exit(1);
		}
		Statement st = con.createStatement();
		//
		// Insert/Create data
		//st.execute("INSERT INTO Employee (firstName) VALUES ('Andriy');");
		//st.execute("INSERT INTO Employee (firstName) VALUES ('Stepan');");
		//
		// Update data
		//st.execute("UPDATE Employee SET firstName='SuperVasja' WHERE id=4;");
		//st.execute("UPDATE Employee SET firstName='SuperVasja' WHERE firstName LIKE 'Pe%';");
		//
		// Delete data
		//st.execute("DELETE FROM Employee WHERE firstName='SuperVasja';");
		//
		// Read data
		ResultSet rs = st.executeQuery("select * from Employee;");
		int columnCount = rs.getMetaData().getColumnCount();
		// Resultset.getMetaData () get the information
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(rs.getMetaData().getColumnName(i) + "\t");
		}
		System.out.println();
		// output file
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		//
		// Close all
		//System.out.println("before close");
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
		System.out.println("DONE");
	}
}
