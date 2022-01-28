package codecamp.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import codecamp.northwind.core.utilities.results.DataResult;
import codecamp.northwind.core.utilities.results.Result;
import codecamp.northwind.entities.concretes.Product;
import codecamp.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	DataResult<List<Product>> getAllSorted();
    Result Add(Product product);
    
    
    DataResult<Product> getByProductName(String productName);  

	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	
	DataResult<List<Product>> getByProductNameContains(String productName);

	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	
	DataResult<List<Product>> getByProductNameEndsWith(String productName);
	
	
	DataResult<List<Product>> getByNameAndCategoryId(String productName,int categoryId);
	
	DataResult <List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
