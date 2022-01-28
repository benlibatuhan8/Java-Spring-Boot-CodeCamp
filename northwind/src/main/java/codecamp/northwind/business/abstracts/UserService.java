package codecamp.northwind.business.abstracts;

import codecamp.northwind.core.entites.User;
import codecamp.northwind.core.utilities.results.DataResult;
import codecamp.northwind.core.utilities.results.Result;



public interface UserService {
	Result add(User user);
	DataResult<User> findByProductEmail(String email);
}
