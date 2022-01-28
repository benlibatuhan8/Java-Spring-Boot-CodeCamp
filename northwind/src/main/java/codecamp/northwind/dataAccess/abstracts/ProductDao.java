package codecamp.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import codecamp.northwind.entities.concretes.Product;
import codecamp.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer>{
		Product getByProductName(String productName);  
		//select * from products where product_name=(String productName)
	    // tek bir ürün dönüyor çünkü metodun çıktısı sadece product
		
		Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
		//select * from products where product_name=String productName and category_id= int categoryId
		
		List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
		// List döndürmüş çünkü where koşuluna uyan tüm ürünleri istiyor
		
		List<Product> getByCategoryIn(List<Integer> categories);
		//select * from Products where category_id in (1,2,3,4,5(int categoryId))
		
		List<Product> getByProductNameContains(String productName);
		// Bu abstract metod String productName' i içinde içeren tüm productları döndürür
		
		List<Product> getByProductNameStartsWith(String productName);
		
		List<Product> getByProductNameEndsWith(String productName);
		
		
		@Query("from Product where productName=:productName and category.categoryId=:categoryId") 
		// bu query yazılırken veri tabanı tablosunun alan isimlenidrmesiyle değil java classının isimlendirmesiyle yapılır
		List<Product> getByNameAndCategory_CategoryId(String productName,int categoryId);
		
		
		@Query("Select new codecamp.northwind.entities.dtos.ProductWithCategoryDto(p.productName,p.id,c.categoryName)"
				+ " From Category c Inner Join c.products p")
		List<ProductWithCategoryDto> getProductWithCategoryDetails();
		//Select p.productId,p.productName,c.categoryName from Category c ,Product p 
		//where c.categoryId=p.categoryId
}
// Buraya normal sql query si de atabiliriz.
