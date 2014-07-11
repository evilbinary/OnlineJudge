package org.evilbinary.db;

import java.util.Vector;

import org.evilbinary.db.AcceptCodeServer.state;
import org.evilbinary.entity.AcceptCode;

public class AcceptCodeServer {
	private DBUtil db;
	private Vector vector;
	private Vector<String[]> vv;
	private state result;

	public enum state {
		addSuccess, delSuccess, modifySuccess, findSuccess, none,
		addFailed,delFailed,modifyFailed,findFailed
	};
	public AcceptCodeServer() {
		db = DataBaseSingleton.instance();
		result = state.none;
	}
	public String getPrimaryKey(){
		db.executeQuery("select LAST_INSERT_ID()");
		vector=db.getResultsVectorRow(0);
		return (String) vector.get(0);
	}
	public AcceptCode getAcceptCode(String aid) {
		AcceptCode AcceptCode = null;
		db.executeQuery("select * from AcceptCode where aid='"+aid+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			AcceptCode=new AcceptCode();
			AcceptCode.setAid((String) vector.get(0));
			AcceptCode.setPid((String) vector.get(1));
			AcceptCode.setUid((String) vector.get(2));
			AcceptCode.setCode((String) vector.get(3));
			AcceptCode.setPassDate((String) vector.get(4));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return AcceptCode;
	}
	
	public void addAcceptCode(AcceptCode AcceptCode) {
		String sql="insert into AcceptCode (pid,uid,code,passDate) values(?,?,?,? );";
		int i=db.executeNonQuery(sql,AcceptCode.getParametersNonPrimary());
		if (i > 0) {
			result = state.addSuccess;
		} else {
			result=state.addFailed;
		}
	}
	public void modifyAcceptCode(AcceptCode AcceptCode){
		String sql="update AcceptCode set pid=? ,uid=? ,code=? passDate=? where aid='"+AcceptCode.getAid()+"'";
		int i=db.executeNonQuery(sql,AcceptCode.getParametersNonPrimary());
		if (i > 0) {
			result = state.modifySuccess;
		} else {
			result=state.modifyFailed;
		}
	}
	public void deleteAcceptCode(String id){
		String sql="delete from AcceptCode where aid="+id;
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public void deleteAcceptCodeByProblemId(String pid){
		String sql="delete from AcceptCode where pid="+pid;
		System.out.println(sql);
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public Vector<AcceptCode> getAllAcceptCodes(){
		String sql="select * from AcceptCode";
		return getAcceptCodesBySql(sql);
		
	}
	private Vector<AcceptCode> getAcceptCodesBySql(String sql){
		Vector<AcceptCode> AcceptCodes=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings();
		if(vv.size()>0){
			new Vector<AcceptCode>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				AcceptCode AcceptCode=new AcceptCode();
				AcceptCode.setAid(v[0]);
				AcceptCode.setPid(v[1]);
				AcceptCode.setUid(v[2]);
				AcceptCode.setCode(v[3]);
				AcceptCode.setPassDate(v[4]);
				AcceptCodes.add(AcceptCode);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return AcceptCodes;
	}
	public state getState(){
		return result;
	}
}
