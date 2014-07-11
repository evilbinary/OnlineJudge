package org.evilbinary.db;

import java.text.SimpleDateFormat;
import java.util.Vector;

import org.evilbinary.entity.Admin;
import org.evilbinary.entity.User;

public class UserServer {
	private DBUtil db;
	private Vector vector;
	private Vector<String[]> vv;
	private state result;

	public enum state {
		addSuccess, delSuccess, modifySuccess, findSuccess, none,
		addFailed,delFailed,modifyFailed,findFailed
	};

	public UserServer() {
		db = DataBaseSingleton.instance();
		result = state.none;
	}

	public User getUser(String uid) {
		User user = null;
		db.executeQuery("select * from user where id='"+uid+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			user=new User();
			user.setEmail((String) vector.get(3));
			user.setMark((String) vector.get(5));
			user.setName((String) vector.get(1));
			user.setPassword((String) vector.get(2));
			user.setRegisteDate((String) vector.get(4));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return user;
	}
	public User getUserByName(String name){
		User user = null;
		db.executeQuery("select * from user where name='"+name+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			user=new User();
			user.setEmail((String) vector.get(3));
			user.setMark((String) vector.get(5));
			user.setName((String) vector.get(1));
			user.setPassword((String) vector.get(2));
			user.setRegisteDate((String) vector.get(4));
			user.setId((String) vector.get(0));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return user;
	}
	public Admin getAdminByName(String name){
		Admin admin = null;
		db.executeQuery("select * from admin where name='"+name+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			admin=new Admin();
			admin.setId((String) vector.get(0));
			admin.setName((String) vector.get(1));
			admin.setPassword((String) vector.get(2));
			admin.setPrivilege((String) vector.get(3));
			admin.setEmail((String) vector.get(4));
			admin.setRegisteDate((String) vector.get(5));
			admin.setMark((String) vector.get(6));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return admin;
	}
	public Admin getAdmin(String id) {
		Admin admin=null;
		db.executeQuery("select * from admin where id='"+id+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			admin=new Admin();
			admin.setId((String) vector.get(0));
			admin.setName((String) vector.get(1));
			admin.setPassword((String) vector.get(2));
			admin.setPrivilege((String) vector.get(3));
			admin.setEmail((String) vector.get(4));
			admin.setRegisteDate((String) vector.get(5));
			admin.setMark((String) vector.get(6));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return admin;
 
	}
	public void addUser(User user) {
		String sql="insert into user (name,password,email,registeDate,mark) values(?,?,?,?,?);";
		int i=db.executeNonQuery(sql,user.getParametersNonPrimary());
		if (i > 0) {
			result = state.addSuccess;
		} else {
			result=state.addFailed;
		}
	}
	public void modifyUser(User user){
		String sql="update user set name=? ,password=? ,email=? ,registeDate=?,mark=? where id='"+user.getId()+"'";
		int i=db.executeNonQuery(sql,user.getParametersNonPrimary());
		if (i > 0) {
			result = state.modifySuccess;
		} else {
			result=state.modifyFailed;
		}
	}
	public void deleteUser(String uid){
		String sql="delete from user where id='"+uid+"'";
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public Vector<User> getAllUsers(){
		String sql="select * from user";
		return getUserBySql(sql);
		
	}
	public Vector<String[]> getUserPassInfo(String uid){
		String sql = "select pid,problem.title,passDate,acceptcode.aid "
				+ "from acceptcode,user,problem "
				+ "where user.id=acceptcode.uid "
				+ "and problem.id=acceptcode.pid "
				+ "and user.id="+uid;
		db.executeQuery(sql);
		return db.getResultsVectorStrings();
	}
	private Vector<User> getUserBySql(String sql){
		Vector<User> users=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings();
		if(vv.size()>0){
			new Vector<User>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				User user=new User();
				user.setId(v[0]);
				user.setEmail(v[3]);
				user.setMark(v[5]);
				user.setName(v[1]);
				user.setPassword(v[2]);
				user.setRegisteDate(v[4]);
				users.add(user);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return users;
	}
	public state getState(){
		return result;
	}

	
}
