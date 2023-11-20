package dao;

import java.util.List;

import domain.Food;

public interface FoodDao {

List<Food> findAll() throws Exception;
	
	Food findById(Integer id) throws Exception;
	
	void insert(Food admin) throws Exception;
	
//	void update(Admin admin) throws Exception; 時間があれば実装
	
//	void delete(Admin admin) throws Exception; 時間があれば実装

}
