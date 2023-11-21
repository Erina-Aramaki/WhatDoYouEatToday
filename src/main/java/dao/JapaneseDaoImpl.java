package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import domain.Japanese;

public class JapaneseDaoImpl implements JapaneseDao{
	
	private DataSource ds;
	List<Japanese> japaneseFoods = new ArrayList<>();
	String stapleJapanese;
	Japanese japaneseFood;
	
	public JapaneseDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	
	@Override
	public List<Japanese> findAll() throws Exception {
		
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT * FROM japanese_food";
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLを実行
			ResultSet rs = stmt.executeQuery();
			//変換
			while(rs.next()) {
				Japanese japaneseFood = mapToFood(rs);
				japaneseFoods.add(japaneseFood);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return japaneseFoods;
	}
	

	@Override
	public Japanese select(String strId) throws Exception {
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT ROW_NUMBER() OVER(ORDER BY id ASC) Num, id, Name, staple_id, staplefood_name "
					+ " FROM (SELECT japanese_food.id, japanese_food.name, japanese_food.staple_id, "
					+ " staple_food.name AS staplefood_name "
					+ " FROM japanese_food JOIN staple_food ON japanese_food.staple_id = staple_food.id "
					+ " HAVING staplefood_name = ?) AS staple_japanese";
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLを実行
			stmt.setString(1, strId);
			ResultSet rs = stmt.executeQuery();
			System.out.println("JapaneseDaoImpl：rs = " + rs);
			//変換
			System.out.println("-------------------------------------------------------------------");
			while(rs.next()) {
				Japanese japaneseFood = mapToFood(rs);
				System.out.println("JapaneseDaoImpl："+ japaneseFood);
				this.japaneseFood = japaneseFood;
				japaneseFoods.add(japaneseFood);
			}
			System.out.println("-------------------------------------------------------------------");
			
			//ランダム関数
			System.out.println("JapaneseDaoImpl：ランダム数（getNum()）=" + japaneseFood.getNum());
			Random r = new Random();
			int random = r.nextInt(japaneseFood.getNum())+1; //0～4→1～5に変更
			int num = random;
			System.out.println("stapleFood（ランダム結果）num：" + num);
			
			
			String sql2 = "SELECT staple_japanese.* "
					+ "FROM( "
					+ " SELECT ROW_NUMBER() OVER(ORDER BY id ASC) Num, id, Name, staple_id, staplefood_id, staplefood_name "
					+ " FROM (SELECT japanese_food.id, japanese_food.name, japanese_food.staple_id, "
					+ " staple_food.id AS staplefood_id, staple_food.name AS staplefood_name "
					+ " FROM japanese_food JOIN staple_food ON japanese_food.staple_id = staple_food.id "
					+ " HAVING staplefood_name = ? ) AS staple_japanese)staple_japanese WHERE Num = ?";
			//SQLを準備
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			//SQLを実行
			stmt2.setString(1, strId);
			stmt2.setInt(2, num);
			ResultSet rs2 = stmt2.executeQuery();
			System.out.println("JapaneseDaoImpl-stapleFoodランダム関数：rs2 = " + rs2);
			
			//変換
			if(rs2.next()) {
				Japanese japaneseFood2 = mapToFood(rs2);
				System.out.println("JapaneseDaoImpl（stapleFood）japaneseFood2："+ japaneseFood2);
				japaneseFood = japaneseFood2;
				return japaneseFood;
			}

		}catch(Exception e) {
			System.out.println("JapaneseDaoImpl：失敗");
			e.printStackTrace();
		}
		return null;
	}
		
//	public List<Japanese> select() throws Exception {
//		
//		Random r = new Random();
//		int random = r.nextInt(4)+1;
////		double d;
////		d = (int)Math.random()*10;
//		System.out.println("random" + random);
//		
//		int id = random;
//		
//		try(Connection con = ds.getConnection()){
//			//SQL文
//			String sql = "SELECT * FROM japanese_food WHERE id = ?";
//			//SQLを準備
//			PreparedStatement stmt = con.prepareStatement(sql);
//			//SQLを実行
//			stmt.setInt(1, id);
//			ResultSet rs = stmt.executeQuery();
//			System.out.println("rs"+rs);
//			//変換
//			if(rs.next()) {
//				Japanese japaneseFood = mapToFood(rs);
//				japaneseFoods.add(japaneseFood);
//				System.out.println("japaneseDaoImpl："+ japaneseFoods);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return japaneseFoods;
//	}
	
	@Override
	public List<Japanese> detailFood() throws Exception {
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
					+ " SELECT western_food.name, western_food.staple_id FROM western_food)AS staple_food"
					+ "  WHERE staple_id = ?";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setInt(1, );
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			//変換
			while(rs.next()) {
				Japanese japanese = mapToFood(rs);
				japaneseFoods.add(japanese);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return japaneseFoods;
	}
	
	
	public Japanese mapToFood(ResultSet rs) throws SQLException {
		Japanese japaneseFood = Japanese.builder()
				.num(rs.getInt("num"))
				.id(rs.getInt("id"))
				.name(rs.getString("name"))
				.stapleId(rs.getInt("staple_id"))
				.build();
		System.out.println("japaneseFood" + japaneseFood);
		return japaneseFood;
	}


	

}
