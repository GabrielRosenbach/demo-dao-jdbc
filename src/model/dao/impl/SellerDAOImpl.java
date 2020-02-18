package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDAOImpl implements SellerDAO {

	private Connection conn;

	public SellerDAOImpl(Connection conn) {

		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Seller codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer codigo) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT seller.*, department.Name as DepName " + 
					"FROM seller INNER JOIN department " + 
					"ON seller.DepartmentId = department.Id " + 
					"WHERE seller.Id = ?");
			
			st.setInt(1, codigo);
			rs = st.executeQuery();
			
			if (rs.next()) {
				
				Department department = instantiateDepartment(rs);
				
				Seller seller = instantiateSeller(rs, department);
				
				return seller;
			}
			
			return null;
			
		} catch (SQLException e) {
			
			throw new DBException(e.getMessage());
		
		} finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {

		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setSalary(rs.getDouble("BaseSalary"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setDepartment(department);
		
		return seller;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {

		Department department = new Department();
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));
		
		return department;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}