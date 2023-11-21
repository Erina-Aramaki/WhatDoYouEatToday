package dao;

import java.util.List;

import domain.Chinese;

public interface ChineseDao {

	//japanese_food全件データを取得
	List<Chinese> findAll() throws Exception;
	
	//主食を選択
	Chinese select(String strId) throws Exception;
			
	//selectしたfoodを取得　→　詳細を表示させる？？
	List<Chinese> detail() throws Exception;
}
