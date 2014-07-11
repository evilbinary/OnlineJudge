package org.evilbinary.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.evilbinary.db.UserServer;
import org.evilbinary.entity.Admin;
import org.evilbinary.entity.User;

public class UserManager {
	private UserServer userServer;
	public UserManager() {
		userServer = new UserServer();
	}

	public boolean userLogin(String username, String password) {
		if ("".equals(username) || "".equals(password))
			return false;
		User u = userServer.getUserByName(username);
		System.out.println(userServer.getState());
		if (u != null && password.equals(u.getPassword())) {
			return true;
		} else {
			return false;

		}
	}
	public User userLoginReturnUser(String username, String password) {
		if ("".equals(username) || "".equals(password))
			return null;
		User u = userServer.getUserByName(username);
		System.out.println(userServer.getState());
		if (u != null && password.equals(u.getPassword())) {
			return u;
		} else {
			return null;

		}
	}
	public boolean isExisitUser(String username){
		User u = userServer.getUserByName(username);
		if (u != null) {
			return true;
		} else {
			return false;

		}
		
	}
	public boolean register(String username, String password, String email) {
		if ("".equals(username) || "".equals(password))
			return false;
		if(isExisitUser(username))
			return false;
		User u = new User();
		u.setName(username);
		u.setPassword(password);
		u.setEmail(email);
		SimpleDateFormat dayFormate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		u.setRegisteDate(dayFormate.format(new Date()));
		userServer.addUser(u);
		return true;
		 
	}

	public void userLogout() {

	}

	public void adminLogout() {

	}

	public void addLoginInfo() {

	}
	public boolean isExisitAdmin(String adminname){
		Admin u = userServer.getAdminByName(adminname);
		if (u != null) {
			return true;
		} else {
			return false;

		}
		
	}
	public Admin adminLogin(String username, String password) {
		Admin admin=userServer.getAdminByName(username);
		if(admin!=null&&admin.getPassword().equals(password)){
			return admin;
		}
		return null;
		
	}

	public void addAdmin() {
		
	}

	public void dropAdmin() {

	}

	public void modifyAdmin() {

	}

	public User findUserByUserName(String username) {
		return userServer.getUserByName(username);
	}
	public User findUserById(String id){
		return userServer.getUser(id);
	}
	public Admin findAdminByUserName(String username) {
		return userServer.getAdminByName(username);
	}
	public Admin findAdminById(String id){
		return userServer.getAdmin(id);
	}
	public Vector<String[]> getUserPassInfo(String uid){
		return userServer.getUserPassInfo( uid);
		
	}
	public void getUserPassCount() {

	}

	public void getUserTotalSubmitCount() {

	}

	public void increaseUserSubmitCount() {

	}

	public void increaseUserPassCount() {

	}

	public void getUserList() { // ·ÖÒ³

	}

	public void createGroup() {

	}

	public void addToGroup() {

	}

	public void dropGroup() {

	}

	public void removeUserFromGroup() {

	}

	public void getGroupMembers() {

	}

	public void getGroupOwner() {

	}
}
