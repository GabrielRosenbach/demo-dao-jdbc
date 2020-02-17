package model.dao;

import model.dao.impl.SellerDAOImpl;

public class DAOFactory {

	public static SellerDAO createSellerDAO() {
		
		return new SellerDAOImpl();
	}
}
