package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		System.out.println("Test 1 ====== SELLER BY ID========");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTest 2 ====== SELLER FIND BY DEPARTMENT========");
		Department department = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(department);


		list.forEach(x -> System.out.println(x));
	}

}
