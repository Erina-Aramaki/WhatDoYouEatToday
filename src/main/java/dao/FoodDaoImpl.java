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
	Food food = new Food();
	
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
	public List<Food> material(int num, String name) throws Exception {
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
		System.out.println(num + "," + name);
		List<Food> howToMake = new ArrayList<>();
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
				howToMake.add(food);
				System.out.println("FoodDaoImpl_howToMake：foodsssss=" + howToMake.get(i).getHowToMake());
				i += 1;
			}
			System.out.println("-------------------------------------------------------------------");
			
		} catch (Exception e) {
			System.out.println("FoodDaoImpl_howToMake：失敗");
			e.getStackTrace();
		}
		return howToMake;
		
	}

	@Override
	public Food findById(Integer id) throws Exception {

		return null;
	}

	@Override
	public void insert(Food food) throws Exception {
		
	}
	
	@Override
	public void addToFavorite(String loginId, String name, int foodNum, String foodName) throws Exception {
		try(Connection con = ds.getConnection()){
			//お気に入りリスト重複チェック
			String sql = "SELECT * FROM favorite WHERE login_id = ? AND food_num = ?";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			stmt.setInt(2, foodNum);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			System.out.println("foodDaoImpl_addToFavorite：rs=" + rs);
			//変換
			if(rs.next()) {
				//お気に入りに追加されていたらwhile文実行
				System.out.println("既にお気に入り登録されているため、登録処理を行いません");
			}else {
			//お気に入りに追加されていなかったら以下の追加処理を実行
			//SQL文
			String sql2 = "INSERT INTO favorite(login_id, login_name, food_num, food_name) "
					+ " VALUE(?, ?, ?, ?)";
			
			//SQL文準備
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.setString(1, loginId);
			stmt2.setString(2, name);
			stmt2.setInt(3, foodNum);
			stmt2.setString(4, foodName);
		
			System.out.println("foodDaoImpl_addToFavoriteメソッド：" + loginId +"," + name +"," + foodNum +"," + foodName);
			//SQL実行
			stmt2.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("foodDaoImpl_addToFavorite失敗");
		}
	}

	@Override
	public void removeFavorite(String loginId, int foodNum) throws Exception {
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "DELETE FROM favorite WHERE login_id = ? AND food_num = ?";
			
			//SQL文準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			stmt.setInt(2, foodNum);
			
			//SQL実行
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Food checkDuplicate() throws Exception {
		try(Connection con = ds.getConnection()){
			//SQL文
//			String sql = "DELETE FROM favorite WHERE id AND food_num"
//					+ " NOT IN (SELECT min_id from (SELECT MIN(id) min_id FROM favorite GROUP BY food_num, food_name) tmp)";
			//SQL準備
//			PreparedStatement stmt = con.prepareStatement(sql);
//			System.out.println("checkDuplicate:stmt=" + stmt);
			//SQL実行
//			stmt.executeUpdate();
			//変換
//			System.out.println("-------------------------------------------------------------------");
//			while(rs.next()) {
//				Food food = mapToCheckFavorite(rs);
//				System.out.println("FoodDaoImpl_checkDuplicate：food=" + food);
//				foods.add(food);
//			}
//			System.out.println("-------------------------------------------------------------------");
			
			//SQL文
//			String sql = "SELECT * FROM favorite WHERE login_id = ? AND food_num = ?";
//			//SQL準備
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setString(1, loginId);
//			stmt.setInt(2, num);
//			//SQL実行
//			ResultSet rs = stmt.executeQuery();
//			//変換
//			if(rs.next()) {
//				Food food = mapToCheckFavorite(rs);
//				if(food == null) {
//					return food;
//				}
//			}
			
			
		} catch (Exception e) {
			System.out.println("FoodDaoImpl_checkDuplicate：失敗");
			e.getStackTrace();
		}
		return null;
	}
	

	@Override
	public List<Food> checkFavorite(String loginId) throws Exception {
		try(Connection con = ds.getConnection()){
			
			
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
