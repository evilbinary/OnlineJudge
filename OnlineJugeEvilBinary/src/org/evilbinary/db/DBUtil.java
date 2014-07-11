package org.evilbinary.db;

import java.sql.*;
import java.util.Vector;


public class DBUtil {
	private String userName;
	private String password;
	private String connectUrl;
	private String driverName;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private Connection connection;
	private ResultSet resultSet;
	private CallableStatement callStatement;
	public DBUtil(){
		driverName="com.mysql.jdbc.Driver";
		connectUrl="jdbc:mysql://localhost:3306/oj";
		userName="root";
		password="123";
		connect();
	}
	public DBUtil(String connectUrl,String userName,String password){
		driverName="com.mysql.jdbc.Driver";
		this.connectUrl=connectUrl;
		this.userName=userName;
		this.password=password;
		connect();
	}
	public void connect(){
		if(connection!=null)
			return;
		try {
			Class.forName(driverName);
			connection=DriverManager.getConnection(connectUrl,userName,password);
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver can not found!"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("connect failed!"+e.getMessage());
		}catch(Exception e){
			System.out.println("Error!"+e.getMessage());
		}
	}
	public void close(){
		try {
			if(statement!=null&&!statement.isClosed())
				statement.close();
			if(callStatement!=null&&!callStatement.isClosed())
				callStatement.close();
			if(preparedStatement!=null&&!preparedStatement.isClosed())
				preparedStatement.close();
			if(connection!=null&&!connection.isClosed())
				connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void executeQuery(String sql){
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("executeQuery failed!"+e.getMessage());
		}catch(Exception e){
			System.out.println("executeQuery error!"+e.getMessage());
		}
	}
	public void executeQuery(String sql,String parameters[]){
		try {
			preparedStatement=connection.prepareStatement(sql);
			for(int i=0;i<parameters.length;i++){
				preparedStatement.setString(i+1, parameters[i]);
			}
			resultSet=preparedStatement.executeQuery();
			//ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
			//int numCols=resultSetMetaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("executeQuery error!"+e.getMessage());
		}
	}
	public int executeNonQuery(String sql){
		int resultCount=-1;
		try {
			statement=connection.createStatement();
			resultCount=statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS); //×Ô¶¯·µ»Økey
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("executeNonQuery error!"+e.getMessage());
		}
		return resultCount;
	}
	public int executeNonQuery(String sql,String parameters[]){
		int resultCount=-1;
		try {
			preparedStatement=connection.prepareStatement(sql);
			for(int i=0;i<parameters.length;i++){
				preparedStatement.setString(i+1, parameters[i]);
			}
			//System.out.println(preparedStatement.getWarnings());
			resultCount=preparedStatement.executeUpdate();
			//ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
			//int numCols=resultSetMetaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("executeNonQuery failed!"+e.getMessage());
		}catch(Exception e){
			System.out.println("executeNonQuery error!"+e.getMessage());
		}
		return resultCount;
	}
	public void executeProcedure(String procedureName){
		try {
			//System.out.println(procedureName);
			callStatement=connection.prepareCall("{call "+procedureName+"}");
			resultSet=callStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void executeProcedure(String procedureName,String parameters[]){
		try {
			callStatement=connection.prepareCall("{call "+procedureName+"}");
			for(int i=0;i<parameters.length;i++){
				callStatement.setString(i+1, parameters[i]);
			}
			resultSet=callStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Vector<String[]> getResultsVectorStrings(){
		
		ResultSetMetaData resultSetMetaData;
		Vector<String[]> vv=new Vector<String[]>();
		try {
			resultSetMetaData = resultSet.getMetaData();
			int numCols=resultSetMetaData.getColumnCount();
			while(resultSet.next())
            { 
                String[] v=new String[numCols];
                for(int i=0;i<numCols;i++){
                    v[i]=resultSet.getString(i+1);
                    //System.out.println("v="+v[i]);
                }
                vv.add(v);
            }
			//resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		return vv;
	}
	public Vector<String[]> getResultsVectorStrings(int page,int quantity){
		ResultSetMetaData resultSetMetaData;
		Vector<String[]> vv=new Vector<String[]>();
		try {
			resultSetMetaData = resultSet.getMetaData();
			int numCols=resultSetMetaData.getColumnCount();
			 int first=(page-1)*quantity;
             int temp=0;
             if(first!=0){
            	 resultSet.absolute(first);
             }
			while(resultSet.next()&&(temp<quantity))
            { 
                String[] v=new String[numCols];
                for(int i=0;i<numCols;i++){
                    v[i]=resultSet.getString(i+1);
                    //System.out.println("v="+v[i]);
                }
                temp++;
                vv.add(v);
            }
			//resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		return vv;
	}
	public Vector getResultsVectorColum(int columnIndex){
		
//		ResultSetMetaData resultSetMetaData;
		Vector<String> vv=new Vector<String>();
		try {
			resultSet.beforeFirst();
//			resultSetMetaData = resultSet.getMetaData();
			//int numCols=resultSetMetaData.getColumnCount();
			while(resultSet.next())
            { 
                String s=resultSet.getString(1+columnIndex);
                vv.addElement(s);
            }
			//resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		return vv;
	}
	public Vector getResultsVectorRow(int rowIndex){
		ResultSetMetaData resultSetMetaData;
		Vector<String> vv=new Vector<String>();
		try {
			resultSet.beforeFirst();
			resultSetMetaData = resultSet.getMetaData();
			int numCols=resultSetMetaData.getColumnCount();
//			while(resultSet.next()&&rowIndex>0)
//            { 
//				rowIndex--;
//            }
			
			resultSet.absolute(rowIndex+1);
//			if(rowIndex==0){
				for(int i=0;i<numCols;i++){
					String s=resultSet.getString(i+1);
	                vv.addElement(s.toString());
				}
//			}
			//resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		return vv;
	}
	public String getGeneratedKey(int index){
		int id = -1;
		try {
			 resultSet=statement.getGeneratedKeys();
			 id=resultSet.getInt(index+1);
			return String.valueOf(id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+ "gernerral key erro");
		}catch(Exception e){
			System.out.println(e.getMessage()+ "key erro");
		}
		return String.valueOf(id);
	}
	 
	public int getColumnCount(){
		int columnCount=0;
		ResultSetMetaData resultSetMetaData;
		try {
			resultSetMetaData = resultSet.getMetaData();
			columnCount=resultSetMetaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return columnCount;
	}
//	public int getRowCount(){
//		int rowCount=0;
//		try {
//			resultSet.absolute(1);
//			while(resultSet.next()){
//				rowCount++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return -1;
//		}
//		return rowCount;
//	}
}
