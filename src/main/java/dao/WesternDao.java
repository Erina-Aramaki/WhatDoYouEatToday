package dao;

import domain.Western;

public interface WesternDao {
		
	//selectした値を取得
	Western selectAddRandom(String strId) throws Exception;
			
}
