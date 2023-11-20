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
	
	public JapaneseDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	List<Japanese> japaneseFoods = new ArrayList<>();
	
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
	public List<Japanese> select() throws Exception {
		
		Random r = new Random();
		int random = r.nextInt(4)+1;
//		double d;
//		d = (int)Math.random()*10;
		System.out.println("random" + random);
		
		int id = random;
		
		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT * FROM japanese_food WHERE id = ?";
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLを実行
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			System.out.println("rs"+rs);
			//変換
			if(rs.next()) {
				Japanese japaneseFood = mapToFood(rs);
				japaneseFoods.add(japaneseFood);
				System.out.println("japaneseDaoImpl："+ japaneseFoods);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return japaneseFoods;
	}
	
	
	public Japanese mapToFood(ResultSet rs) throws SQLException {
		Japanese japaneseFood = Japanese.builder()
				.id(rs.getInt("id"))
				.name(rs.getString("name"))
				.build();
//		japaneseFoods.add(japaneseFood);
		return japaneseFood;
	}

}
