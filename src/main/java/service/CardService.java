package service;

import bean.Card;

public interface CardService {
	
	Long insertCard(Card card);
	
	Long deleteCardById(Long id);
	
	Long updateCardById(Card card);
	
	Card selectCardById(Long id);

}
