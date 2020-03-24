package dao;

import entity.Admin;

public interface AdminDAO {
	public Admin findByAdminCode(String adminCode);
}


