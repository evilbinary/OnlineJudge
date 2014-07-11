package org.evilbinary.db;

public class DataBaseSingleton {
	private static DBUtil db=null;
	public DataBaseSingleton(){
		
	}
	public static DBUtil instance(){
		if(db==null){
			db= new DBUtil();
		}
		return db;
	}
}
