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
			String sql = "SELECT "
					+ " ROW_NUMBER() OVER(ORDER BY staple_id ASC) Num, "
					+ " name,staple_id "
					+ " FROM( "
					+ " SELECT japanese_food.name, japanese_food.staple_id FROM japanese_food "
					+ " UNION "
					+ " SELECT chinese_food.name, chinese_food.staple_id FROM chinese_food "
					+ " UNION "
					+ " SELECT western_food.name, western_food.staple_id FROM western_food)AS staple_food";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			System.out.println("FoodDaoImpl：rs=" + rs);
			//変換
			System.out.println("-------------------------------------------------------------------");
			while(rs.next()) {
				Food food = mapToFood(rs);
				System.out.println("FoodDaoImpl：food=" + food);
				foods.add(food);
			}
			System.out.println("-------------------------------------------------------------------");
			
		} catch (Exception e) {
			System.out.println("FoodDaoImpl：失敗");
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
				.num(rs.getInt("num"))
				.name(rs.getString("name"))
				.stapleId(rs.getInt("staple_id"))
				.build();
		return food;
	}

}
