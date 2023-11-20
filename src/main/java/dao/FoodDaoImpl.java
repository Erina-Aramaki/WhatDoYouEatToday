package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Food;

public class FoodDaoImpl implements FoodDao{
	
	DataSource ds;
	List<Food> foods = new ArrayList<>();
	
	public FoodDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Food> findAll() throws Exception {

		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT japanese_food.name FROM japanese_food "
					+ " UNION "
					+ " SELECT chinese_food.name FROM chinese_food "
					+ " UNION "
					+ " SELECT italian_food.name FROM italian_food;";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			//変換
			while(rs.next()) {
				Food food = mapToFood(rs);
				foods.add(food);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return foods;
	}

	@Override
	public Food findById(Integer id) throws Exception {

		return null;
	}

	@Override
	public void insert(Food admin) throws Exception {
		
	}
	
	public Food mapToFood(ResultSet rs) throws SQLException {
		Food food = Food.builder()
				.name(rs.getString("name"))
				.build();
		return food;
	}

}
