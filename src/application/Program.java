package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		
		Statement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int row1 = st.executeUpdate("update seller set BaseSalary = 2090 where DepartmentId = 1");
			
			int row2 = st.executeUpdate("update seller set BaseSalary = 3090 where DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("Rows 1: " + row1);
			
			System.out.println("Rows 2: " + row2);
			
			
			
		} catch (SQLException e) {
			
			try {
				
				conn.rollback();
				throw new DBException("Transactional rolled back! Caused by: " + e.getMessage());
				
			} catch (SQLException e1) {

				throw new DBException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
			
		} finally {
			 
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
