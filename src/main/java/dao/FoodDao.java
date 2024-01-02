package dao;

import java.util.List;

import domain.Food;

public interface FoodDao {

//	すべてのfoodを一覧表示
	List<Food> findAll() throws Exception;
	
//	材料一覧を取得
	List<Food> material(int id, String name) throws Exception;
	
//	作り方一覧を取得
	List<Food> howToMake(int num, String name, List<Food> material) throws Exception;
	
	Food findById(Integer id) throws Exception;
	
	void insert(Food food) throws Exception;
	
//	void update(Admin admin) throws Exception; 時間があれば実装
	
//	void delete(Admin admin) throws Exception; 時間があれば実装
	
//	お気に入りに登録
	void addToFavorite(String loginId, String name, int foodNum, String foodName) throws Exception;
	
//	お気に入りから削除
	void removeFavorite(String loginId, int foodNum) throws Exception;
	
//	お気に入りに追加されていたら重複を削除
//	Food checkDuplicate() throws Exception;
	
//	お気に入り一覧表示
	List<Food> checkFavorite(String loginId) throws Exception;
	

}
