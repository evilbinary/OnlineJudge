package org.evilbinary.db;

import java.util.Vector;
import org.evilbinary.db.ProblemClassifyServer.state;
import org.evilbinary.entity.ProblemClassify;
import org.evilbinary.entity.ProblemLimit;

public class ProblemLimitServer {
	private DBUtil db;
	private Vector vector;
	private Vector<String[]> vv;
	private state result;
	public ProblemLimitServer() {
		db = DataBaseSingleton.instance();
		result = state.none;
	}
	public Vector<ProblemLimit> getProblemLimit(String problemId){
		String sql="select * from problemlimit where pid="+problemId;
		return getProblemLimitBySql(sql);
	}
	public  Vector<ProblemLimit> getAllProblemLimit(){
		return getProblemLimitBySql("SELECT * FROM problemlimit");
	}
	public void deleteProblemLimitByProblemId(String pid){
		String sql="delete from problemlimit where pid="+pid;
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	private  Vector<ProblemLimit> getProblemLimitBySql(String sql){
		Vector<ProblemLimit> problemLimits=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings();
		if(vv.size()>0){
			problemLimits=new Vector<ProblemLimit>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				ProblemLimit problemLimit=new ProblemLimit();
				problemLimit.setPid(v[0]);
				problemLimit.setTimeLimit(v[1]);
				problemLimit.setMemoryLimit(v[2]);
				problemLimit.setSubmitDateLimit(v[3]);
				problemLimits.add(problemLimit);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return problemLimits;
	}
	public state getState(){
		return result;
	}
	
}
