package org.evilbinary.manager;

import java.util.Vector;

import org.evilbinary.db.SubmitStateServer;
import org.evilbinary.entity.SubmitState;

public class SubmitManager {
	private SubmitStateServer submitStateServer;
	public SubmitManager(){
		submitStateServer=new SubmitStateServer();
	}
	public Vector<SubmitState> getAllSubmitJugeResult(){
		return submitStateServer.getAllSubmitstatesOderByDesc();
	}
	public Vector<String[]> getAllSubmitStateOderByTime(){
		return submitStateServer.getAllSubmitStateOderByTime();
	}
}
