package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {
	
	public static AdminDao createAdminDao() {
		//DB接続
		return new AdminDaoImpl(getDataSource());
	}
	
	public static FoodDao createFoodDao() {
		//DB接続
		return new FoodDaoImpl(getDataSource());
	}
	
	public static JapaneseDao createJapaneseDao() {
		//DB接続
		return new JapaneseDaoImpl(getDataSource());
	}
	
	public static ChineseDao createChineseDao() {
		//DB接続
		return new ChineseDaoImpl(getDataSource());
	}
	
	public static WesternDao createWesternDao() {
		//DB接続
		return new WesternDaoImpl(getDataSource());
	}
	
	//DB接続のメソッド
	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/my_project");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				if(ctx != null) {
					ctx.close();					
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		return ds;
	}
}
