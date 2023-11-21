package dao;

import java.util.List;

import domain.Japanese;

public interface JapaneseDao {

	//japanese_food全件データを取得
	List<Japanese> findAll() throws Exception;
		
	//selectしたfoodを取得
	Japanese select(String strId) throws Exception;
		
	//選択したfoodの詳細を表示させる
	List<Japanese> detailFood() throws Exception;
}
