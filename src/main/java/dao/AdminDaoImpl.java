package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Admin;

public class AdminDaoImpl implements AdminDao{
	
	DataSource ds;
	List<Admin> admin = new ArrayList<>();
	
	public AdminDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public List<Admin> findAll() throws Exception {
		
		try(Connection con = ds.getConnection()){
			
			//SQL文
			String sql = "SELECT * FROM admin;";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			
			//変換
			while(rs.next()) {
				Admin adminBuilder = mapToAdmin(rs);
				admin.add(adminBuilder);
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public Admin findById(Integer id) throws Exception {

		return null;
	}

	@Override
	public void insert(Admin admin) throws Exception {
		//SQL文
		String sql = "INSERT INTO admin(login_id, login_pass, email, name) VALUES(?, ?, ?, ?)";
		
		//パスワードをハッシュ化
		String loginPass = admin.getLoginPass(); //adminクラスのgetter
		String hashed  = BCrypt.hashpw(loginPass, BCrypt.gensalt());
		System.out.println(hashed);
		
		try(Connection con = ds.getConnection()){
			//SQLを準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getLoginId());
			stmt.setString(2, hashed);
			stmt.setString(3, admin.getEmail());
			stmt.setString(4, admin.getName());
			//SQLを実行
			stmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("AdminDaoImpl：失敗");
			e.getStackTrace();
		}
		
	}

	@Override
	public Admin findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception {

		try(Connection con = ds.getConnection()){
			//SQL文
			String sql = "SELECT * FROM admin WHERE login_id = ?";
			//SQL準備
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			//変換
			if(rs.next()) {
				if(!BCrypt.checkpw(loginPass, rs.getString("login_pass"))){
					return null;
				}
				System.out.println("AdminDaoImpl2："+rs.getString("name"));
				return new Admin(rs.getInt("id"), loginId, null, rs.getString("email"), rs.getString("name"));
			}
		}
		
		return null;
	}
	
	private Admin mapToAdmin(ResultSet rs) throws SQLException {
		Admin admin = Admin.builder()
				.id((Integer)rs.getObject("id"))
				.loginId(rs.getString("loginId"))
				.loginPass(rs.getString("loginPass"))
				.email(rs.getString("email"))
				.name(rs.getString("name"))
				.build();
		return admin;
	}

}
