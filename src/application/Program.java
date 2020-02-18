package application;

import java.util.Date;
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
		
		System.out.println("\nTest 3 ====== SELLER FIND ALL========");
		list = sellerDAO.findAll();

		list.forEach(x -> System.out.println(x));
		
		System.out.println("\nTest 4 ====== SELLER INSERT========");
		seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDAO.insert(seller);
		
		System.out.println("Inserted! New id = " + seller.getId());
	
		System.out.println("\nTest 5 ====== SELLER UPDATE========");
		seller = sellerDAO.findById(1);
		seller.setName("Matha Waine");
		sellerDAO.update(seller);
		
		System.out.println("Updated completed!");
	}

}
