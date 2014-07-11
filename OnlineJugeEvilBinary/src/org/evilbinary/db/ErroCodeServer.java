package org.evilbinary.db;

import java.util.Vector;

import org.evilbinary.db.ErroCodeServer.state;
import org.evilbinary.entity.ErroCode;

public class ErroCodeServer {
	private DBUtil db;
	private Vector vector;
	private Vector<String[]> vv;
	private state result;

	public enum state {
		addSuccess, delSuccess, modifySuccess, findSuccess, none,
		addFailed,delFailed,modifyFailed,findFailed
	};
	public ErroCodeServer() {
		db = DataBaseSingleton.instance();
		result = state.none;
	}
	public ErroCode getErroCode(String eid) {
		ErroCode erroCode = null;
		db.executeQuery("select * from errocode where eid='"+eid+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			erroCode=new ErroCode();
			erroCode.setEid((String) vector.get(0));
			erroCode.setPid((String) vector.get(1));
			erroCode.setUid((String) vector.get(2));
			erroCode.setCode((String) vector.get(3));
			erroCode.setJugeDate((String) vector.get(4));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return erroCode;
	}
	
	public void addErroCode(ErroCode errocode) {
		String sql="insert into errocode(pid,uid,code,jugeDate) values(?,?,?,? )";
//		System.out.println(sql);
		int i=db.executeNonQuery(sql,errocode.getParametersNonPrimary());
		if (i > 0) {
			result = state.addSuccess;
		} else {
			result=state.addFailed;
		}
	}
	public void modifyErroCode(ErroCode errocode){
		String sql="update errocode set pid=? ,uid=? ,code=? jugeDate=? where eid='"+errocode.getEid()+"'";
		int i=db.executeNonQuery(sql,errocode.getParametersNonPrimary());
		if (i > 0) {
			result = state.modifySuccess;
		} else {
			result=state.modifyFailed;
		}
	}
	public void deleteErroCode(String eid){
		String sql="delete from errocode where eid='"+eid+"'";
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public void deleteErroCodeByProblemId(String pid){
		String sql="delete from errocode where pid="+pid;
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public Vector<ErroCode> getAllErroCodes(){
		String sql="select * from errocode";
		return getErroCodesBySql(sql);
		
	}
	private Vector<ErroCode> getErroCodesBySql(String sql){
		Vector<ErroCode> erroCodes=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings();
		if(vv.size()>0){
			new Vector<ErroCode>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				ErroCode erroCode=new ErroCode();
				erroCode.setEid(v[0]);
				erroCode.setPid(v[1]);
				erroCode.setUid(v[2]);
				erroCode.setCode(v[3]);
				erroCode.setJugeDate(v[4]);
				erroCodes.add(erroCode);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return erroCodes;
	}
	public state getState(){
		return result;
	}
	public String getPrimaryKey(){
		db.executeQuery("select LAST_INSERT_ID()");
		vector=db.getResultsVectorRow(0);
		return (String) vector.get(0);
	}
}
