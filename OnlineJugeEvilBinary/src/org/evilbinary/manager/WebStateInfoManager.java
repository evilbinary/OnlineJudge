package org.evilbinary.manager;

import java.util.Iterator;
import java.util.Vector;
import org.evilbinary.entity.*;

//保存 在application 记录在线用户列表 type=1 user type=0  dmin type=2 guest 
public class WebStateInfoManager {
	private Vector<String[]> userList;
	public WebStateInfoManager(){
		userList=new Vector<String[]>() ;
	}
	
	public Vector<String[]> getUserList() {
		return userList;
	}

	public void addGuest(String guestId,String guestName){
		addUserList(guestId,guestName,"2");
	}
	public void dropLogoutGuest(String guestId){
		dropUserList(guestId,"2");
	}
	public void addLoginUser(String userId, String userName) {
		addUserList(userId,userName,"1");
	}

	public void addLoginAdmin(String adminId, String adminName) {
	 
		addUserList(adminId,adminName,"0");
		 
	}
	public void dropLogoutUser(String userId){
		dropUserList(userId,"1");
	}
	public void dropLogoutAdmin(String adminId){
		dropUserList(adminId,"0");
	}
	private void addUserList(String id,String name,String type){ // type=1 user type=0  dmin type=2 guest 
		if(!isExsit(id)){
			String[] userInfo = { id, name, type };
			userList.add(userInfo);
		}
	}
	private void dropUserList(String id,String type){
		Iterator ite=userList.iterator();
		while(ite.hasNext()){
			 String[] s=(String[])ite.next();
			 if(type.equals(s[2])&&id.equals(s[0])){
				 ite.remove();
			 }
		}
	}
	private boolean isExsit(String id){
		Iterator ite=userList.iterator();
		while(ite.hasNext()){
			 String[] s=(String[])ite.next();
			 if(id.equals(s[0])){
				 return true;
			 }
		}
		return false;
	}
	 
}
