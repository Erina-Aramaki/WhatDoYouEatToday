package dao;

import java.util.List;

import domain.Admin;

public interface AdminDao {
	
	List<Admin> findAll() throws Exception;
	
	Admin findById(Integer id) throws Exception;
	
	void insert(Admin admin) throws Exception;
	
//	void update(Admin admin) throws Exception; 時間があれば実装
	
//	void delete(Admin admin) throws Exception; 時間があれば実装
	
	Admin findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception;


}
