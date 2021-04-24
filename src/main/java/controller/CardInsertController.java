package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import bean.Card;
import service.CardService;

public class CardInsertController implements Controller {

	private CardService cardService;

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Card card = new Card();
		card.setName(request.getParameter("name"));
		card.setUserId(Long.parseLong(request.getParameter("userId")));
		cardService.insertCard(card);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("../card");
		mv.addObject(card);
		return mv;
	}

}
