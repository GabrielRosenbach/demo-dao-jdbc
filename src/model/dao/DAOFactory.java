package model.dao;

import db.DB;
import model.dao.impl.SellerDAOImpl;

public class DAOFactory {

	public static SellerDAO createSellerDAO() {
		
		return new SellerDAOImpl(DB.getConnection());
	}
}
