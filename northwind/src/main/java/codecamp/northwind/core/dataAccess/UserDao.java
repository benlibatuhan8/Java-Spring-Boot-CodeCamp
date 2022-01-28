package codecamp.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import codecamp.northwind.core.entites.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
