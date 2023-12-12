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
//	List<Food> foods = new ArrayList<>();
	Food food = new Food();
	
	public FoodDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Food> findAll() throws Exception {
		List<Food> foods = new ArrayList<>();
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
	public List<Food> material(int num, String name) throws Exception {
		List<Food> foods = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT * FROM material WHERE num = ? AND name = ?";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, num);
			stmt.setString(2, name);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			System.out.println("FoodDaoImpl_material：rs=" + rs);
			//変換
			System.out.println("-------------------------------------------------------------------");
			while(rs.next()) {
				Food food = Food.builder()
						.num(rs.getInt("num"))
						.name(rs.getString("name"))
						.material(rs.getString("material_name"))
						.build();
				System.out.println("FoodDaoImpl_material：food=" + food);
				foods.add(food);
//				return food;
			}
			System.out.println("-------------------------------------------------------------------");
			
		} catch (Exception e) {
			System.out.println("FoodDaoImpl_material：失敗");
			e.getStackTrace();
		}
		return foods;
		
	}
	
	
	@Override
	public List<Food> howToMake(int num, String name, List<Food> material) throws Exception {
		List<Food> foods = new ArrayList<>();
		System.out.println(num + "," + name);
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT * FROM how_to_make WHERE id = ? AND name = ?";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, num);
			stmt.setString(2, name);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			System.out.println("FoodDaoImpl_howToMake：rs=" + rs);
			//変換
			System.out.println("-------------------------------------------------------------------");
			int i = 0;
			while(rs.next()) {
				
				Food food = Food.builder()
						.num(rs.getInt("id"))
						.name(rs.getString("name"))
						.material(material.get(i).getMaterial())
						.howToMake(rs.getString("explanation")) //後ほど実装
						.build();
				System.out.println("FoodDaoImpl_howToMake：food=" + food.getHowToMake());
				foods.add(food);
				System.out.println("FoodDaoImpl_howToMake：foodsssss=" + foods.get(i).getHowToMake());
				i += 1;
			}
			System.out.println("-------------------------------------------------------------------");
			
		} catch (Exception e) {
			System.out.println("FoodDaoImpl_howToMake：失敗");
			e.getStackTrace();
		}
		return foods;
		
	}

	@Override
	public Food findById(Integer id) throws Exception {

		return null;
	}

	@Override
	public void insert(Food food) throws Exception {
		
	}
	
	@Override
	public void addToFavorite(String login_id, String name, int foodNum, String foodName, String material) throws Exception {
		try(Connection con = ds.getConnection()){
			
			//SQL文
			String sql = "INSERT INTO favorite(login_id, login_name, food_num, food_name) "
					+ " VALUE(?, ?, ?, ?)";
			
			//SQL文準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login_id);
			stmt.setString(2, name);
			stmt.setInt(3, foodNum);
			stmt.setString(4, foodName);
			
			System.out.println("foodDaoImpl_addToFavoriteメソッド：" + login_id +"," + name +"," + foodNum +"," + foodName);
			//SQL実行
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeFavorite(String login_id, String name, int foodNum, String foodName, String material) throws Exception {
		
	}
	
	@Override
	public void checkDuplicate() throws Exception {
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "DELETE FROM favorite WHERE id "
					+ " NOT IN (SELECT min_id from (SELECT MIN(id) min_id FROM favorite GROUP BY food_num, food_name) tmp)";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQL実行
			stmt.executeUpdate();
			//変換
//			System.out.println("-------------------------------------------------------------------");
//			while(rs.next()) {
//				Food food = mapToCheckFavorite(rs);
//				System.out.println("FoodDaoImpl_checkDuplicate：food=" + food);
//				foods.add(food);
//			}
//			System.out.println("-------------------------------------------------------------------");
			
		} catch (Exception e) {
			System.out.println("FoodDaoImpl_checkDuplicate：失敗");
			e.getStackTrace();
		}
	}
	

	@Override
	public List<Food> checkFavorite(String loginId) throws Exception {
		List<Food> foods = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			
			//！！！後ほどmaterialも実装する
			
			//SQL文
//			String sql = "SELECT "
//					+ " food_num AS num, food_name AS name "
//					+ " FROM( "
//					+ " SELECT japanese_food.name, japanese_food.staple_id FROM japanese_food "
//					+ " UNION "
//					+ " SELECT chinese_food.name, chinese_food.staple_id FROM chinese_food "
//					+ " UNION "
//					+ " SELECT western_food.name, western_food.staple_id FROM western_food)AS all_food "
//					+ " JOIN favorite ON all_food.name = favorite.food_name";
			
			String sql = "SELECT * FROM favorite WHERE login_id = ?";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			System.out.println("FoodDaoImpl_checkFavorite：rs=" + rs);
			//変換
			System.out.println("-------------------------------------------------------------------");
			while(rs.next()) {
				Food food = mapToCheckFavorite(rs);
				System.out.println("FoodDaoImpl_checkFavorite：food=" + food);
				foods.add(food);
			}
			System.out.println("-------------------------------------------------------------------");
			
		} catch (Exception e) {
			System.out.println("FoodDaoImpl_checkFavorite：失敗");
			e.getStackTrace();
		}
		return foods;
		
	}
	
	
	public Food mapToFood(ResultSet rs) throws SQLException {
		Food food = Food.builder()
				.num(rs.getInt("num"))
				.name(rs.getString("name"))
				.stapleId(rs.getInt("staple_id"))
				.build();
		return food;
	}
	
	public Food mapToCheckFavorite(ResultSet rs) throws SQLException {
		Food food = Food.builder()
				.num(rs.getInt("food_num"))
				.name(rs.getString("food_name"))
//				.material(rs.getString("material"))
				.build();
		return food;
	}

	

	

	

}
