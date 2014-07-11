package org.evilbinary.db;

import java.util.Vector;

import org.evilbinary.db.UserServer.state;
import org.evilbinary.entity.TestData;
import org.evilbinary.entity.User;

public class TestDataServer {
	private DBUtil db;
	private Vector vector;
	private Vector<String[]> vv;
	private state result;

	public enum state {
		addSuccess, delSuccess, modifySuccess, findSuccess, none,
		addFailed,delFailed,modifyFailed,findFailed
	};

	public TestDataServer() {
		db = DataBaseSingleton.instance();
		result = state.none;
	}

	public TestData getTestData(String tid) {
		TestData testData = null;
		db.executeQuery("select * from testdata where id='"+tid+"'");
		vector = db.getResultsVectorRow(0);
		if (vector != null && vector.size() > 0) {
			testData=new TestData();
			testData.setId((String) vector.get(0));
			testData.setPid((String) vector.get(1));
			testData.setInput((String) vector.get(2));
			testData.setOutput((String) vector.get(3));
			result = state.findSuccess;
		}else{
			result = state.findFailed;
		}
		return testData;
	}
	
	public void addTestData(TestData testData) {
		String sql="insert into testdata (pid,input,output) values(?,?,?,);";
		int i=db.executeNonQuery(sql,testData.getParametersNonPrimary());
		if (i > 0) {
			result = state.addSuccess;
		} else {
			result=state.addFailed;
		}
	}
	public void modifyTestDatar(TestData testData){
		String sql="update testdata pid=? ,input=? ,output=? where id="+testData.getId();
		int i=db.executeNonQuery(sql,testData.getParametersNonPrimary());
		if (i > 0) {
			result = state.modifySuccess;
		} else {
			result=state.modifyFailed;
		}
	}
	public void deleteTestData(String tid){
		String sql="delete from testdata where id="+tid;
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public void deleteTestDataByProblemId(String pid){
		String sql="delete from testdata where pid="+pid;
		int i=db.executeNonQuery(sql);
		if (i > 0) {
			result = state.delSuccess;
		} else {
			result=state.delFailed;
		}
	}
	public  Vector<TestData>  getAllTestData(){
		String sql="select * from testdata";
		return getTestDataBySql(sql);
		
	}
	public  Vector<TestData>  getProblemTestData(String pid){
		String sql="select * from testdata where pid="+pid;
		return getTestDataBySql(sql);
		
	} 
	private Vector<TestData> getTestDataBySql(String sql){
		Vector<TestData> testData=null;
		db.executeQuery(sql);
		vv=db.getResultsVectorStrings();
		if(vv.size()>0){
			testData=new Vector<TestData>();
			for(int i=0;i<vv.size();i++){
				String[] v=vv.get(i);
				TestData test=new TestData();
				 test.setId(v[0]);
				 test.setPid(v[1]);
				 test.setInput(v[2]);
				 test.setOutput(v[3]);
				testData.add(test);
			}
			result=state.findSuccess;
		}else{
			result=state.findFailed;
		}
		return testData;
	}
	public state getState(){
		return result;
	}
}
