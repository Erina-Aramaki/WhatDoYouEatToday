package dao;

import java.util.List;

import domain.Food;

public interface FoodDao {

	List<Food> findAll() throws Exception;
	
	List<Food> material(int id, String name) throws Exception;
	
	List<Food> howToMake(int num, String name, List<Food> material) throws Exception;
	
	Food findById(Integer id) throws Exception;
	
	void insert(Food food) throws Exception;
	
//	void update(Admin admin) throws Exception; 時間があれば実装
	
//	void delete(Admin admin) throws Exception; 時間があれば実装
	
	void addToFavorite(String login_id, String name, int foodNum, String foodName, String material) throws Exception;
	
	void removeFavorite(String login_id, String name, int foodNum, String foodName, String material) throws Exception;
	
	void checkDuplicate() throws Exception;
	
	List<Food> checkFavorite() throws Exception;
	

}
