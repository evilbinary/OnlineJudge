
package org.evilbinary.oj;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import org.evilbinary.db.UserServer;
import org.evilbinary.db.DBUtil;
import org.evilbinary.entity.User;

public class Main extends Frame implements ActionListener,WindowListener{
	private Button button;
	private Button button1;
	private Button testButton;
	private Thread system;
	
	public Main(){
		system=new JugeSystem("Java");
		button=new Button("add target");
		button1=new Button("juge targets");
		testButton=new Button("test db");
		this.add(button);
		this.add(button1);
		this.add(testButton);
		button.addActionListener(this);
		button1.addActionListener(this);
		testButton.addActionListener(this);
	    this.setSize(400, 300);
	    this.setLocation(300, 100);
	    this.addWindowListener(this);
	    this.setLayout(new FlowLayout());
	    Date day=new Date();
	    SimpleDateFormat dayFormat=new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
	    System.out.println(dayFormat.format(day));
//	    String result="421_123";
//	  String[] pu=result.split("_");
//		System.out.println("0="+pu[0]+" 1="+pu[1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("abc");
//		Compiler c=new Compiler();
//		c.compile();
//		System.out.println(c.getResult().getState());
//		Engine java=  EngineFactory.createEngine("Java");
//		java.target(target);
//		java.run();
//		System.out.println(java.getManager().result.getState());
		
	   Main m=new Main();
	   m.setVisible(true);
	   //m.testOj();
	   System.out.println("main");
	}
 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button){
			Target target=new Target();
			target.fileName="Hello";
			target.filePath="D:\\My Documents\\Java\\out\\";
			target.fileExtension=".java";
			target.objExtension=".class"; 
			target.output="3";
			target.input="1 2";
			target.setLimit(5000, 1000);
		    ((JugeSystem) system).addTarget(target);
		    System.out.println("target number="+((JugeSystem) system).getTargetNumber());
		}else if(e.getSource()==button1){
			 system.run();
			 System.out.println("juge");
		}else if(e.getSource()==testButton){
			 UserServer manager=new UserServer();
			 User u=manager.getUser("1");
			 printUser(u);
			 u.setName("п║уе");
			 manager.addUser(u);
			 Vector<User> users=manager.getAllUsers();
			 for(int i=0;i<users.size();i++){
				 u=users.get(i);
				 printUser(u);
			 }
			 
			 
		 
		}
	}
	private void printUser(User u){
		 System.out.print("id "+u.getId());
		 System.out.print(" name "+u.getName());
		 System.out.print(" password "+u.getPassword());
		 System.out.print(" registeDate "+u.getRegisteDate());
		 System.out.println(" make "+u.getMark());
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		 
	}
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(1);
	}
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
