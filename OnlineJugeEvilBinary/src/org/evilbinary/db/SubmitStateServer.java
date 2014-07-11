package org.evilbinary.db;

import java.util.Vector;

import org.evilbinary.entity.SubmitState;

public class SubmitStateServer {
 
		private DBUtil db;
		private Vector vector;
		private Vector<String[]> vv;
		private state result;

		public enum state {
			addSuccess, delSuccess, modifySuccess, findSuccess, none,
			addFailed,delFailed,modifyFailed,findFailed
		};
		public SubmitStateServer() {
			db = DataBaseSingleton.instance();
			result = state.none;
		}
		public SubmitState getSubmitstate(String id) {
			SubmitState submitState = null;
			db.executeQuery("select * from submitstate where id='"+id+"'");
			vector = db.getResultsVectorRow(0);
			if (vector != null && vector.size() > 0) {
				submitState=new SubmitState();
				submitState.setId((String) vector.get(0));
				submitState.setCid((String) vector.get(1));
				submitState.setState((String) vector.get(2));
				submitState.setCodeType((String) vector.get(3));
				submitState.setMemory((String) vector.get(4));
				submitState.setRuntime((String) vector.get(5));
				submitState.setSubmitDate((String) vector.get(6));
				submitState.setCodeLength((String) vector.get(7));
				result = state.findSuccess;
			}else{
				result = state.findFailed;
			}
			return submitState;
		}
		 
		public void addSubmitstate(SubmitState submitState) {
			String sql="insert into submitstate (cid,state,codeType,memory,runtime,submitDate,codeLength) values(?,?,?,?,?,?,?);";
			int i=db.executeNonQuery(sql,submitState.getParametersNonPrimary());
			if (i > 0) {
				result = state.addSuccess;
			} else {
				result=state.addFailed;
			}
		}
		public void modifySubmitstate(SubmitState submitState){
			String sql="update submitstate set cid=? ,state=? ,codeType=? memory=?,runtime=?,submitDate=?,codeLength=? where id='"+submitState.getId()+"'";
			int i=db.executeNonQuery(sql,submitState.getParametersNonPrimary());
			if (i > 0) {
				result = state.modifySuccess;
			} else {
				result=state.modifyFailed;
			}
		}
		public void deleteSubmitstate(String id){
			String sql="delete from submitstate where id='"+id+"'";
			int i=db.executeNonQuery(sql);
			if (i > 0) {
				result = state.delSuccess;
			} else {
				result=state.delFailed;
			}
		}
		public Vector<SubmitState> getAllSubmitstates(){
			String sql="select * from submitstate";
//			System.out.println(sql);
			return getSubmitstatesBySql(sql);
			
		}
		public Vector<SubmitState> getAllSubmitstatesOderByDesc(){
			String sql="select * from submitstate order by id desc";
			return getSubmitstatesBySql(sql);
			
		}
		public Vector<String[]> getAllSubmitStateOderByTime(){
			String sql="select submitstate.id submitId, problem.id problemId,user.name,state,codeType,memory,runtime,submitDate,codeLength "+
				"from submitstate,acceptcode,user,problem,errocode "+
				"where (acceptcode.uid=user.id "+
				"and acceptcode.aid=submitstate.cid "+
				"and submitstate.state='rightAnswer' "+
				"and acceptcode.pid=problem.id) "+
				"or ( errocode.uid=user.id "+
				"and submitstate.state<>'rightAnswer' "+
				"and errocode.eid=submitstate.cid "+
				"and errocode.pid=problem.id) "+
				"group by submitstate.id order by submitstate.submitDate desc"
				;
//			System.out.println(sql);
			db.executeQuery(sql);
			vv=db.getResultsVectorStrings();
			return vv;
		}
		private Vector<SubmitState> getSubmitstatesBySql(String sql){
			Vector<SubmitState> submitStates=null;
			db.executeQuery(sql);
			vv=db.getResultsVectorStrings();
			if(vv.size()>0){
				
				submitStates=new Vector<SubmitState>();
				for(int i=0;i<vv.size();i++){
					String[] v=vv.get(i);
					SubmitState submitState=new SubmitState();
					submitState.setId(v[0]);
					submitState.setCid(v[1]);
					submitState.setState(v[2]);
					submitState.setCodeType(v[3]);
					submitState.setMemory(v[4]);
					submitState.setRuntime(v[5]);
					submitState.setSubmitDate(v[6]);
					submitState.setCodeLength(v[7]);
					submitStates.add(submitState);
				}
				result=state.findSuccess;
			}else{
				result=state.findFailed;
			}
			return submitStates;
		}
		public state getState(){
			return result;
		}
 

}
