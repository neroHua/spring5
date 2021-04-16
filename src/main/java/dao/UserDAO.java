package dao;

import org.apache.ibatis.annotations.Param;

import bean.User;

public interface UserDAO {
	
	Long insertUser(@Param("user") User user);
	
	Long deleteUserById(Long id);
	
	Long updateUserById(@Param("user") User user);
	
	User selectUserById(Long id);

}
