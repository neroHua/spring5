package service.impl;

import bean.Card;
import bean.User;
import dao.CardDAO;
import dao.UserDAO;
import service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	private CardDAO cardDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public CardDAO getCardDAO() {
		return cardDAO;
	}

	public void setCardDAO(CardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}
	
	@Override
	public Long insertUser(User user) {
		Long id = userDAO.insertUser(user);
		
		Card card = new Card();
		card.setName("cardx");
		card.setUserId(id);
		Long insertCard = cardDAO.insertCard(card);
		
		long a = insertCard / 0;
		return a;
	}

	@Override
	public Long deleteUserById(Long id) {
		return userDAO.deleteUserById(id);
	}
	
	@Override
	public Long updateUserById(User user) {
		return userDAO.updateUserById(user);
	}
	
	@Override
	public User selectUserById(Long id) {
		return userDAO.selectUserById(id);
	}
}
