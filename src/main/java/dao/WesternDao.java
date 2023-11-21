package dao;

import domain.Western;

public interface WesternDao {

	//italian_food全件データを取得 後ほど実装
//	List<Western> findAll() throws Exception;
		
	//selectした値を取得
	Western select(String strId) throws Exception;
				
	//選択したfoodの詳細を表示させる？？　後ほど実装
//	List<Western> detailFood() throws Exception;
}
