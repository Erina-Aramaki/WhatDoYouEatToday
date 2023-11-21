package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import domain.Chinese;

public class ChineseDaoImpl implements ChineseDao{
	
	DataSource ds;
	List<Chinese> chineseFoods = new ArrayList<>();
	String stapleChinese;
	Chinese chineseFood;
	
	public ChineseDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Chinese> findAll() throws Exception {
		
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT * FROM chinese_food";
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLを実行
			ResultSet rs = stmt.executeQuery();
			//変換
			while(rs.next()) {
				Chinese chineseFood = mapToFood(rs);
				chineseFoods.add(chineseFood);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return chineseFoods;
	}
	
	@Override
	public Chinese stapleFood(String strId) throws Exception {
		try(Connection con = ds.getConnection()){
			//SQL文
//			String sql = "SELECT chinese_food.id, chinese_food.name, chinese_food.staple_id, "
//					+ " staple_food.name AS staplefood_name "
//					+ " FROM chinese_food JOIN staple_food ON chinese_food.staple_id = staple_food.id "
//					+ " HAVING staplefood_name = ?";
			
			String sql = "SELECT ROW_NUMBER() OVER(ORDER BY id ASC) Num, id, Name, staple_id, staplefood_name "
					+ " FROM (SELECT chinese_food.id, chinese_food.name, chinese_food.staple_id, "
					+ " staple_food.name AS staplefood_name "
					+ " FROM chinese_food JOIN staple_food ON chinese_food.staple_id = staple_food.id "
					+ " HAVING staplefood_name = ?) AS staple_chinese";
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLを実行
			stmt.setString(1, strId);
			ResultSet rs = stmt.executeQuery();
			System.out.println("ChineseDaoImpl：rs = " + rs);
			//変換
			while(rs.next()) {
				Chinese chineseFood = mapToFood(rs);
				System.out.println("ChineseDaoImpl："+ chineseFood);
				this.chineseFood = chineseFood;
				chineseFoods.add(chineseFood);
			}
			
			//ランダム関数
//			int max = Collections.max(num.get(0));
			System.out.println("chineseFood.getNum()=" + chineseFood.getNum());
			Random r = new Random();
//			int random = r.nextInt(chineseFoods.size())+1;
//			System.out.println("chineseDaoImple：chineseFoods.size()=" + chineseFoods.size()+1);
			int random = r.nextInt(chineseFood.getNum())+1;
			int num = random;
			System.out.println("stapleFood（ランダム）ID：" + num);
			
			
			String sql2 = "SELECT staple_chinese.* "
					+ "FROM( "
					+ " SELECT ROW_NUMBER() OVER(ORDER BY id ASC) Num, id, Name, staple_id, staplefood_id, staplefood_name "
					+ " FROM (SELECT chinese_food.id, chinese_food.name, chinese_food.staple_id, "
					+ " staple_food.id AS staplefood_id, staple_food.name AS staplefood_name "
					+ " FROM chinese_food JOIN staple_food ON chinese_food.staple_id = staple_food.id "
					+ " HAVING staplefood_name = ? ) AS staple_chinese)staple_chinese WHERE Num = ?";
			//SQLを準備
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			//SQLを実行
			stmt2.setString(1, strId);
			stmt2.setInt(2, num);
			ResultSet rs2 = stmt2.executeQuery();
			System.out.println("ChineseDaoImpl-stapleFoodランダム関数：rs2 = " + rs2);
			
			//変換
			if(rs2.next()) {
				Chinese chineseFood2 = mapToFood(rs2);
				System.out.println("ChineseDaoImpl（stapleFood）chineseFood2："+ chineseFood2);
				chineseFood = chineseFood2;
//				chineseFoods.add(chineseFood);
				return chineseFood;
			}

		}catch(Exception e) {
			System.out.println("ChineseDaoImpl：失敗");
			e.printStackTrace();
		}
		return null;
	}

	//後ほど実装：詳細を表示させる？？
	@Override
	public List<Chinese> select() throws Exception {

		Random r = new Random();
		int random = r.nextInt(2)+1;
//		double d;
//		d = (int)Math.random()*10;
		System.out.println("random" + random);
		
		int id = random;
		
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT * FROM chinese_food WHERE id = ?";
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLを実行
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			System.out.println("rs"+rs);
			//変換
			if(rs.next()) {
				Chinese japaneseFood = mapToFood(rs);
				chineseFoods.add(japaneseFood);
				System.out.println("japaneseDaoImpl："+ chineseFoods);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return chineseFoods;
	}
	
	public Chinese mapToFood(ResultSet rs) throws SQLException {
		Chinese chineseFood = Chinese.builder()
				.num(rs.getInt("num"))
				.id(rs.getInt("id"))
				.name(rs.getString("name"))
				.stapleId(rs.getInt("staple_id"))
				.build();
		System.out.println("chineseFood"+chineseFood);
		return chineseFood;
	}

	
}
