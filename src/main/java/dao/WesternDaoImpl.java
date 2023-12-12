package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import domain.Western;

public class WesternDaoImpl implements WesternDao{
	
	DataSource ds;
	List<Western> westernFoods = new ArrayList<>();
	String stapleWestern;
	Western westernFood;
	
	public WesternDaoImpl(DataSource ds) {
		this.ds = ds;
	}

//	@Override
//	public List<Western> findAll() throws Exception {
//
//		return null;
//	}

	@Override
	public Western select(String strId) throws Exception {
		try(Connection con = ds.getConnection()){
			//SQL文
			//western_foodの米、麺、肉、魚、軽食から絞り込み
			String sql = "SELECT ROW_NUMBER() OVER(ORDER BY id ASC) Num, id, Name, staple_id, staplefood_name "
					+ " FROM (SELECT western_food.id, western_food.name, western_food.staple_id, "
					+ " staple_food.name AS staplefood_name "
					+ " FROM western_food JOIN staple_food ON western_food.staple_id = staple_food.id "
					+ " HAVING staplefood_name = ?) AS staple_western";
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLを実行
			stmt.setString(1, strId);
			ResultSet rs = stmt.executeQuery();
			System.out.println("WesternDaoImpl：rs = " + rs);
			//変換
			System.out.println("-------------------------------------------------------------------");
			while(rs.next()) {
				Western westernFood = mapToFood(rs);
				System.out.println("WesternDaoImpl："+ westernFood);
				this.westernFood = westernFood;
				westernFoods.add(westernFood);
			}
			System.out.println("-------------------------------------------------------------------");
			
			//ランダム関数
			System.out.println("WesternDaoImpl：ランダム数（getNum()）=" + westernFood.getNum());
			Random r = new Random();
			int random = r.nextInt(westernFood.getNum())+1; //0～4→1～5に変更
			int num = random;
			System.out.println("stapleFood（ランダム結果）num：" + num);
			
			
			//1行のみ表示し、特定の食べ物の詳細情報（num(western_food)、id、name、staple）を取得
			String sql2 = "SELECT staple_western.* "
					+ "FROM( "
					+ " SELECT ROW_NUMBER() OVER(ORDER BY id ASC) Num, id, Name, staple_id, staplefood_id, staplefood_name "
					+ " FROM (SELECT western_food.id, western_food.name, western_food.staple_id, "
					+ " staple_food.id AS staplefood_id, staple_food.name AS staplefood_name "
					+ " FROM western_food JOIN staple_food ON western_food.staple_id = staple_food.id "
					+ " HAVING staplefood_name = ? ) AS staple_western)staple_western WHERE Num = ?";
			//SQLを準備
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			//SQLを実行
			stmt2.setString(1, strId);
			stmt2.setInt(2, num);
			ResultSet rs2 = stmt2.executeQuery();
			System.out.println("WesternDaoImpl-stapleFoodランダム関数：rs2 = " + rs2);
			
			//変換
			if(rs2.next()) {
				Western westernFood2 = mapToFood(rs2);
				System.out.println("WesternDaoImpl（stapleFood）westernFood2："+ westernFood2);
				westernFood = westernFood2;
				return westernFood;
			}

		}catch(Exception e) {
			System.out.println("WesternDaoImpl：失敗");
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public List<Western> detailFood() throws Exception {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
	
	public Western mapToFood(ResultSet rs) throws SQLException {
		Western westernFood = Western.builder()
				.num(rs.getInt("num"))
				.id(rs.getInt("id"))
				.name(rs.getString("name"))
				.stapleId(rs.getInt("staple_id"))
				.build();
		System.out.println("westernFood" + westernFood);
		return westernFood;
	}

}
