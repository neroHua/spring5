package service.impl;

import bean.Card;
import dao.CardDAO;
import service.CardService;

public class CardServiceImpl implements CardService {

	private CardDAO cardDAO;

	public CardDAO getCardDAO() {
		return cardDAO;
	}

	public void setCardDAO(CardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}

	@Override
	public Long insertCard(Card card) {
		return cardDAO.insertCard(card);
	}

	@Override
	public Long deleteCardById(Long id) {
		return cardDAO.deleteCardById(id);
	}
	
	@Override
	public Long updateCardById(Card card) {
		return cardDAO.updateCardById(card);
	}
	
	@Override
	public Card selectCardById(Long id) {
		return cardDAO.selectCardById(id);
	}

}
