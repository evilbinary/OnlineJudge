package org.evilbinary.db;

import java.util.Vector;

import org.evilbinary.entity.Problem;
 

public class ProblemServer {
	private DBUtil db;
	private Vector vector;
	private Vector<String[]> vv;
	private state result;
	public   enum state {
		addSuccess, delSuccess, modifySuccess, findSuccess, none,
		addFailed,delFailed,modifyFailed,findFailed
	};

	public ProblemServer() {
		db = DataBaseSingleton.instance();
		result = state.none;
		
	}
	
	public Problem getProblem(String pid) {
		Problem problem = null;
		db.executeQuery("select * from problem where id='"+pid+"'");
		
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			
			problem=new Problem();
			problem.setId(((String) vector.get(0)));
			problem.setTitle((String)vector.get(1));
			problem.setContent((String)vector.get(2));
			problem.setCreateDate((String)vector.get(3));
			problem.setOwner((String)vector.get(4));
//			System.out.println("title"+problem.getTitle());
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return problem;
	}
	public int getAllProblemCount(String type){
		db.executeQuery("select count(*) from problemclassify where problemType='"+type+"'");
		return Integer.valueOf( (String) db.getResultsVectorRow(0).get(0));
	}
	public Problem getproblemByTitle(String title){
		Problem problem = null;
		db.executeQuery("select * from problem where title='"+title+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			problem=new Problem();
			problem.setId(((String) vector.get(0)));
			problem.setTitle((String)vector.get(1));
			problem.setContent((String)vector.get(2));
			problem.setCreateDate((String)vector.get(3));
			problem.setOwner((String)vector.get(4));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return problem;
	}
	public void addProblem(Problem problem) {
		String sql="insert into problem (title,content,createDate,owner) values(?,?,?,?);";
		int i=db.executeNonQuery(sql,problem.getParametersNonPrimary());
		if (i > 0) {
			result = state.addSuccess;
		} else {
			result=state.addFailed;
		}
	}
	public String getPrimaryKey(){
		db.executeQuery("select LAST_INSERT_ID()");
		vector=db.getResultsVectorRow(0);
		return (String) vector.get(0);
	}
	public void modifyProblem(Problem problem){
		String sql="update problem set title=? ,content=? ,createDate=? ,owner=? where id='"+problem.getId()+"'";
		int i=db.executeNonQuery(sql,problem.getParametersNonPrimary());
		if (i > 0) {
			result = state.modifySuccess;
		} else {
			result=state.modifyFailed;
		}
	}
	public void deleteProblem(String pid){
		String sql="delete from problem where id='"+pid+"'";
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public Vector<Problem> getAllproblems(){
		String sql="select * from problem";
		return getproblemBySql(sql);
		
	}
	private Vector<Problem> getproblemBySql(String sql){
		Vector<Problem> problems=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings();
		if(vv.size()>0){
			problems=new Vector<Problem>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				Problem problem=new Problem();
				problem.setId(v[0]);
				problem.setTitle(v[1]);
				problem.setContent(v[2]);
				problem.setCreateDate(v[3]);
				problem.setOwner(v[4]);
				problems.add(problem);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return problems;
	}
	public state getState(){
		return result;
	}
}
