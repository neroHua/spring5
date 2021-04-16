package dao;

import org.apache.ibatis.annotations.Param;

import bean.Card;

public interface CardDAO {
	
	Long insertCard(@Param("card") Card card);
	
	Long deleteCardById(Long id);
	
	Long updateCardById(@Param("card") Card card);
	
	Card selectCardById(Long id);

}
