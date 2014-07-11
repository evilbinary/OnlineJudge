package org.evilbinary.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.evilbinary.db.AcceptCodeServer;
import org.evilbinary.db.ErroCodeServer;
import org.evilbinary.db.ProblemClassifyServer;
import org.evilbinary.db.ProblemLimitServer;
import org.evilbinary.db.ProblemServer;
import org.evilbinary.db.TestDataServer;
import org.evilbinary.entity.Admin;
import org.evilbinary.entity.Problem;
import org.evilbinary.entity.ProblemClassify;
import org.evilbinary.entity.ProblemLimit;
import org.evilbinary.entity.TestData;

public class ProblemManager {
	
	private ProblemClassifyServer problemClassifyServer;
	private ProblemServer problemServer;
	private TestDataServer testDataServer;
	private ProblemLimitServer problemLimitServer;
	private AcceptCodeServer acceptCodeServer;
	private ErroCodeServer erroCodeServer;
	public ProblemManager(){
		
		problemClassifyServer=new ProblemClassifyServer();
		problemServer=new ProblemServer();
		testDataServer=new TestDataServer();
		problemLimitServer=new ProblemLimitServer();
		acceptCodeServer=new AcceptCodeServer();
		erroCodeServer=new ErroCodeServer();
	}
	public Vector<String> getAllProblemType(){
		return problemClassifyServer.getProblemclassifyTypes();
		
	}
	public Vector<String> getProblemType(String pid){
		Vector<ProblemClassify> p=problemClassifyServer.getProbemClassifyTypeById(pid);
		if(p==null)
			return null;
		Vector<String> v=new Vector<String>();
		for(int i=0;i<p.size();i++){
			ProblemClassify pc=p.get(i);
			if(p!=null)
				v.add(pc.getProblemType());
		}
		return v;
		
	}
	public Vector<Problem> getTypeProblem(String type){		//可以改进进行跨表查询
		Vector<ProblemClassify> problemClassifys=problemClassifyServer.getProblemClassifysByType(type);
		Vector<Problem> problems=null;
		try{
		if(problemClassifys!=null){
			problems=new Vector<Problem> ();
			for(int i=0;i<problemClassifys.size();i++){
				
				String id=problemClassifys.get(i).getId();
				
				Problem p=problemServer.getProblem(id);
				if(p!=null){
//					System.out.println(p.getTitle()+" type===");
					problems.add(p);
				}
			}
			
		}
		}catch(Exception e){
			System.out.println(e.getMessage()+"错误a");
			return null;
		}
		return problems;
	}
	public Vector<Problem> getTypeProblem(String type,int pageNum,int quality){		//可以改进进行跨表查询
		Vector<ProblemClassify> problemClassifys=problemClassifyServer.getProblemClassifysByType(type,pageNum,quality);
		Vector<Problem> problems=null;
		try{
		if(problemClassifys!=null){
			problems=new Vector<Problem> ();
			for(int i=0;i<problemClassifys.size();i++){
				
				String id=problemClassifys.get(i).getId();
//				System.out.println(id+" id");
				problems.add(problemServer.getProblem(id));
			}
			
		}
		}catch(Exception e){
			System.out.println(e.getMessage()+"错误a");
			return null;
		}
		return problems;
	}
	public int getAllProblemCount(String type){
		return problemServer.getAllProblemCount(type);
	}
	public Vector<Problem> getAllProblem(){
		return problemServer.getAllproblems();
		
	}
	public Problem getProblemById(String id){
		return problemServer.getProblem(id);
	}
	public Vector<TestData> getProblemTestData(String pid){
		Vector<TestData> tests=testDataServer.getProblemTestData(pid);
		return  tests;
	}
	public Vector<TestData> getProblemAlTestData(String pid){
		return testDataServer.getAllTestData();
	}
	public boolean addNewProblem(String problemTitle,String problemContent,String owner,String type){
		Problem problem=new Problem();
		problem.setTitle(problemTitle);
		problem.setContent(problemContent);
		problem.setOwner(owner);
		SimpleDateFormat dayFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		problem.setCreateDate(dayFormat.format(new Date()));
		problemServer.addProblem(problem);
		if(problemServer.getState()== ProblemServer.state.addSuccess){
			ProblemClassify problemClassify=new ProblemClassify();
			problemClassify.setId(problemServer.getPrimaryKey());
			problemClassify.setCreateDate(dayFormat.format(new Date()));
			problemClassify.setProblemType(type);
			problemClassifyServer.addProblemClassify(problemClassify);
			if(problemClassifyServer.getState()==ProblemClassifyServer.state.addSuccess){
				return true;
			}
			return false;
		}
		return false;
	}
	public boolean dropProblem(String problemId){
		erroCodeServer.deleteErroCodeByProblemId(problemId);
		acceptCodeServer.deleteAcceptCodeByProblemId(problemId);
		problemLimitServer.deleteProblemLimitByProblemId(problemId);
		testDataServer.deleteTestDataByProblemId(problemId);
		problemServer.deleteProblem(problemId);
		if(problemServer.getState()==ProblemServer.state.delSuccess){
			return true;
		}else{
			return false;
		}
	}
	public void setProblemLimit(){
		
	}
	public void setTestData(){
		
	}
	public void addTestData(){
		
	}
	public void dropTestData(){
		
	}
	public void addAcceptCode(){
		
	}
	public boolean modifyProblem(String problemId,String problemTitile,String problemContent,String userId,String newType){
		SimpleDateFormat dayFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Problem problem=new Problem();
		problem.setId(problemId);
		problem.setTitle(problemTitile);
		problem.setContent(problemContent);
		problem.setOwner(userId);
		problem.setCreateDate(dayFormat.format(new Date()));
		problemServer.modifyProblem(problem);
		
		if(problemServer.getState()==ProblemServer.state.modifySuccess){
			Vector<ProblemClassify> v=problemClassifyServer.getProbemClassifyTypeById(problemId);
			String oldType=null;
			if(v!=null){
				oldType=v.get(0).getProblemType();
			}
			ProblemClassify oldProblemClassify;
			if(oldType==null){
				oldProblemClassify=new ProblemClassify();
				oldProblemClassify.setId(problemId);
				oldProblemClassify.setProblemType(newType);
				oldProblemClassify.setCreateDate(dayFormat.format(new Date()));
				problemClassifyServer.addProblemClassify(oldProblemClassify);
				return true;
			}else{
				oldProblemClassify=new ProblemClassify();
				oldProblemClassify.setId(problemId);
				oldProblemClassify.setProblemType(oldType);
				ProblemClassify newProblemClassify=new ProblemClassify();
				newProblemClassify.setCreateDate(dayFormat.format(new Date()));
				newProblemClassify.setProblemType(newType);
				problemClassifyServer.modifyProblemClassify(oldProblemClassify,newProblemClassify);
				if( problemClassifyServer.getState()==ProblemClassifyServer.state.modifySuccess){
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
	}
	public void addNewSubmit(){
		
	}
	public boolean addClassify(String type){
		ProblemClassify problemClassify=new ProblemClassify();
		SimpleDateFormat dayFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		problemClassify.setProblemType(type);
		problemClassify.setCreateDate(dayFormat.format(new Date()));
		problemClassify.setId("0");
		problemClassifyServer.addProblemClassify(problemClassify);
		if(problemClassifyServer.getState()==ProblemClassifyServer.state.addSuccess ){
			return true;
		}else{
			return false;
		}
	}
	public void getProblemList(){	//分页
		
	}
	public void getSubmitState(){ //分页
		
	}
	public String[] getTimeAndMemoryLimit(String problemId){
		Vector<ProblemLimit> v=problemLimitServer.getProblemLimit(problemId);
		String []a=new String[2];
		if(v!=null){
			ProblemLimit problemLimit=v.get(0);
			a[0]=problemLimit.getTimeLimit();
			a[1]=problemLimit.getMemoryLimit();
			return a;
		}
		return null;
	}
	public Admin getOwnerById(String id){
		return  problemClassifyServer.getProblemOwnerById(id);
	}
	public boolean modifyProblem(String problemId, String problemTitile,
			String problemContent, String userId) {
		SimpleDateFormat dayFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Problem problem=new Problem();
		problem.setId(problemId);
		problem.setTitle(problemTitile);
		problem.setContent(problemContent);
		problem.setOwner(userId);
		problem.setCreateDate(dayFormat.format(new Date()));
		problemServer.modifyProblem(problem);
		if(problemServer.getState()==ProblemServer.state.modifySuccess){
			return true;
		}
		return false;
	}
}
