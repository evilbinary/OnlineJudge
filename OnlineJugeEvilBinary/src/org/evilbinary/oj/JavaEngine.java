package org.evilbinary.oj;

public class JavaEngine extends Engine {
	
	private Manager javaManager;
	public JavaEngine(){
	}
	public void run() {
		if(javaManager==null){
			System.out.println("û��Ŀ���ļ���");
			return;
		}
		javaManager.control();
	}
	public Manager getManager() {
		if(javaManager==null){
			System.out.println("û��Ŀ���ļ���");
			return null;
		}
		return javaManager;
	}
	public void target(Target target) {
		if(target==null){
			System.out.println("û��Ŀ���ļ�!");
			return;
		}
		javaManager=new Manager(target);
	}
	

}
