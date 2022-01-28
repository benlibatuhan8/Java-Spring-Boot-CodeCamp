package codecamp.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codecamp.northwind.business.abstracts.UserService;
import codecamp.northwind.core.dataAccess.UserDao;
import codecamp.northwind.core.entites.User;
import codecamp.northwind.core.utilities.results.DataResult;
import codecamp.northwind.core.utilities.results.Result;
import codecamp.northwind.core.utilities.results.SuccessDataResult;
import codecamp.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{
    
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByProductEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu");
	}

}
