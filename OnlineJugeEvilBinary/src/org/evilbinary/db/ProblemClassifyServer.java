package org.evilbinary.db;

import java.util.Vector;

import org.evilbinary.db.ProblemServer.state;
import org.evilbinary.entity.Admin;
import org.evilbinary.entity.Problem;
import org.evilbinary.entity.ProblemClassify;

public class ProblemClassifyServer {
	private DBUtil db;
	private Vector vector;
	private Vector<String[]> vv;
	private state result;

	public enum state {
		addSuccess, delSuccess, modifySuccess, findSuccess, none,
		addFailed,delFailed,modifyFailed,findFailed
	};

	public ProblemClassifyServer() {
		db = DataBaseSingleton.instance();
		result = state.none;
	}

	public  ProblemClassify ProblemClassifyById(String id) {
		 ProblemClassify  problemClassify = null;
		db.executeQuery("select * from problem where id='"+id+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			 problemClassify.setId((String) vector.get(0));
			 problemClassify.setProblemType((String)vector.get(1));
			 problemClassify.setCreateDate((String)vector.get(2));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return problemClassify;
	}
	public Vector<String> getProblemclassifyTypes(){
		Vector<String> v=null;
		String sql=" select distinct problemType FROM problemclassify";
		db.executeQuery(sql);
		v=db.getResultsVectorColum(0);
		if(v!=null&&v.size()>0){
			result=state.findSuccess;
			
		}else{
			result=state.findFailed;
		}
		return v;
	}
	public Admin getProblemOwnerById(String id){
		String sql="select * from Admin where id="+id;
		Admin admin=null;
		db.executeQuery(sql);
		vector=db.getResultsVectorRow(0);
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
	public Vector<ProblemClassify> getProblemClassifysByType(String type){
		return getProblemBySql("select * from problemclassify where problemType='"+type+"'");
	}
	public Vector<ProblemClassify> getProblemClassifysByType(String type,int pageNum,int quality){
		return getProblemBySql("select * from problemclassify where problemType='"+type+"'",pageNum,quality);
	}
	public Vector<ProblemClassify> getProblemClassifysByTypeBySql(String type,int pageNum,int quality){
		return getProblemBySql("select * from problemclassify where problemType='"+type+"' "+pageNum+","+quality);
	}
	public void addProblemClassify(ProblemClassify problemClassify) {
		String sql="insert into problemclassify (id,problemType,createDate) values(?,?,?);";
		int i=db.executeNonQuery(sql,new String[]{problemClassify.getId(),problemClassify.getProblemType(),problemClassify.getCreateDate()});
		if (i > 0) {
			result = state.addSuccess;
		} else {
			result=state.addFailed;
		}
	}
	public Vector<ProblemClassify> getProbemClassifyTypeById(String problemId){
		String sql="select * from problemclassify where id="+problemId;
		return	getProblemBySql(sql);
	}
	public void modifyProblemClassify(ProblemClassify oldProblemClassify,ProblemClassify newProblemClassify){	//primarykey is id and problemtype
		String sql="update problemclassify set id=? ,problemType=? ,createDate=? where id=? and problemType=?";
		String [] params={oldProblemClassify.getId(),newProblemClassify.getProblemType(),newProblemClassify.getCreateDate(),oldProblemClassify.getId(),oldProblemClassify.getProblemType()};
		if("".equals(newProblemClassify.getId())){
			sql="update problemclassify set id=? ,problemType=? ,createDate=? where problemType=?";
			params=new String[]{oldProblemClassify.getId(),newProblemClassify.getProblemType(),newProblemClassify.getCreateDate(),oldProblemClassify.getProblemType()};
		}else if("".equals(newProblemClassify.getProblemType())){
			sql="update problemclassify set id=? ,problemType=? ,createDate=? where id=?";
			params=new String[]{oldProblemClassify.getId(),newProblemClassify.getProblemType(),newProblemClassify.getCreateDate(),oldProblemClassify.getId()};
		}
		System.out.println(sql);
		int i=db.executeNonQuery(sql,params);
		if (i > 0) {
			result = state.modifySuccess;
		} else {
			result=state.modifyFailed;
		}
	}
	public void deleteProblemClassifyById(String pid){
		String sql="delete from problemclassify where id='"+pid+"'";
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public void deleteProblemClassifyByType(String type){
		String sql="delete from problemclassify where problemType='"+type+"'";
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public Vector<ProblemClassify> getAllproblems(){
		String sql="select * from problemclassify";
		return getProblemBySql(sql);
		
	}
	private  Vector<ProblemClassify> getProblemBySql(String sql){
		Vector<ProblemClassify> problemClassifys=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings();
		if(vv.size()>0){
			problemClassifys=new Vector<ProblemClassify>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				ProblemClassify problemClassify=new ProblemClassify();
				problemClassify.setId(v[0]);
				problemClassify.setProblemType(v[1]);
				problemClassify.setCreateDate(v[2]);
				problemClassifys.add(problemClassify);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return problemClassifys;
	}
	private  Vector<ProblemClassify> getProblemBySql(String sql,int page,int quality){
		Vector<ProblemClassify> problemClassifys=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings(page,quality);
		if(vv.size()>0){
			problemClassifys=new Vector<ProblemClassify>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				ProblemClassify problemClassify=new ProblemClassify();
				problemClassify.setId(v[0]);
				problemClassify.setProblemType(v[1]);
				problemClassify.setCreateDate(v[2]);
				problemClassifys.add(problemClassify);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return problemClassifys;
	}
	public state getState(){
		return result;
	}
}
