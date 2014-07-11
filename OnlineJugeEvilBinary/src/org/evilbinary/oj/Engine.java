package org.evilbinary.oj;

public class Engine implements IEngine {
	private Manager manager;
	public Engine(){
	}
	public void run() {
		if(manager==null){
			System.out.println("û��Ŀ���ļ���");
			return;
		}
		manager.control();
	}
	public Manager getManager() {
		if(manager==null){
			System.out.println("û��Ŀ���ļ���");
			return null;
		}
		return manager;
	}
	public void target(Target target) {
		if(target==null){
			System.out.println("û��Ŀ���ļ�!");
			return;
		}
		manager=new Manager(target);
	}
}
