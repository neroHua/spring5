package service;

import bean.User;

public interface UserService {
	
	Long insertUser(User user);
	
	Long deleteUserById(Long id);
	
	Long updateUserById(User user);
	
	User selectUserById(Long id);

}
