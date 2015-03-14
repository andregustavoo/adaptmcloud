package br.ufrn.bb.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import br.ufrn.bb.algorithm.FeatureModelSolver;
import br.ufrn.bb.model.Feature;
import br.ufrn.bb.model.FeatureModel;
import br.ufrn.bb.model.FeatureProperty;
import br.ufrn.bb.model.PermutationSet;
import br.ufrn.bb.model.Solution;

public class MainDatabase {

	public static void main(String[] args) {
	
		//execute27Solutions();
		//execute54Solutions();
		//execute64Solutions();
		//execute128Solutions();
		//execute250Solutions();
		
		try {
			//execute27Solutions();
			//execute54Solutions();
			//execute64Solutions();
			//execute128Solutions();
			//execute250Solutions();
			//execute540Solutions();
			execute1080Solutions();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void execute1080Solutions() throws InterruptedException{
		FeatureModel fm=new FeatureModel(4);
		String host="jdbc:mysql://127.0.0.1:3306/monitor";
		String user="root";
		String pwd="c3f3t";
		Connection conn=null;
		Statement stmt=null;
		String sql="select * from Service_History";
		ResultSet rs=null;
		short[] position={0,1,0,0,1};
		Solution s,initialSolution;
		PermutationSet solutionSpace;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(host, user, pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Feature f;
			rs=stmt.executeQuery(sql);
			rs.next();
			Map<String,Feature>data;
			for(int i=0;i<30;i++){
				fm.getFeatures().clear();
				fm=new FeatureModel(5);
				data=loadData(rs);
				f=new Feature("HPDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("HPDatabases", f);
				f=new Feature("HPFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("HPFiles", f);
				
				f=new Feature("GoGridDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("GoGridDatabases", f);
				f=new Feature("GoGridFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("GoGridFiles", f);
				
				f=new Feature("GoogleDrive");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("Dropbox").getProperties().get("responseTime").getValue()));
				
				data.put("GoogleDrive", f);
				
				f=new Feature("GoMessages");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("GoMessages", f);
				
				fm.getFeatures().get(0).add(data.get("AmazonRDS"));
				fm.getFeatures().get(0).add(data.get("GoogleCloudSQL"));
				fm.getFeatures().get(0).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(0).add(data.get("HPDatabases"));
				fm.getFeatures().get(0).add(data.get("GoGridDatabases"));
				fm.getFeatures().get(1).add(data.get("AmazonDynamoDB"));
				fm.getFeatures().get(1).add(data.get("Dropbox"));
				fm.getFeatures().get(1).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(1).add(data.get("HPFiles"));
				fm.getFeatures().get(1).add(data.get("GoGridFiles"));
				fm.getFeatures().get(1).add(data.get("GoogleDrive"));
				fm.getFeatures().get(2).add(data.get("AmazonS3"));
				fm.getFeatures().get(2).add(data.get("Dropbox"));
				fm.getFeatures().get(2).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(2).add(data.get("HPFiles"));
				fm.getFeatures().get(2).add(data.get("GoGridFiles"));
				fm.getFeatures().get(2).add(data.get("GoogleDrive"));
				fm.getFeatures().get(3).add(data.get("AmazonRDS"));
				fm.getFeatures().get(3).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(3).add(data.get("GoMessages"));
				fm.getFeatures().get(4).add(data.get("AmazonRDS"));
				fm.getFeatures().get(4).add(data.get("RackspaceDatabase"));
				solutionSpace=new PermutationSet(fm);
				FeatureModelSolver solver=new FeatureModelSolver(solutionSpace);
				initialSolution =new Solution();
				initialSolution=solutionSpace.getSolution(position);
				solver.setInitalPosition(position);
				//watch=Stopwatch.createStarted();
				long start=System.nanoTime();
				s=solver.solve(initialSolution);
				
				solutionSpace.evaluateSolution(s);
				long stop=System.nanoTime();
				
				double diff=(stop-start)/1000000.0;
				//System.out.println(diff);
				System.out.println(solver.getContInteractions()+"-"+(solver.getContInteractions()-solver.getContSuccessInteractions()));
				

				//Thread.sleep(3000);
				
				//watch.stop();
				//System.out.println(watch);
				//watch=null;
				//System.out.println(milis);
				
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void execute540Solutions() throws InterruptedException{
		FeatureModel fm=new FeatureModel(4);
		String host="jdbc:mysql://127.0.0.1:3306/monitor";
		String user="root";
		String pwd="c3f3t";
		Connection conn=null;
		Statement stmt=null;
		String sql="select * from Service_History";
		ResultSet rs=null;
		short[] position={0,1,0,0};
		Solution s,initialSolution;
		Stopwatch watch=Stopwatch.createUnstarted();
		PermutationSet solutionSpace;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(host, user, pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Feature f;
			rs=stmt.executeQuery(sql);
			rs.next();
			Map<String,Feature>data;
			for(int i=0;i<30;i++){
				fm.getFeatures().clear();
				fm=new FeatureModel(4);
				data=loadData(rs);
				f=new Feature("HPDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("HPDatabases", f);
				f=new Feature("HPFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("HPFiles", f);
				
				f=new Feature("GoGridDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("GoGridDatabases", f);
				f=new Feature("GoGridFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("GoGridFiles", f);
				
				f=new Feature("GoogleDrive");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("Dropbox").getProperties().get("responseTime").getValue()));
				
				data.put("GoogleDrive", f);
				
				f=new Feature("GoMessages");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("GoMessages", f);
				
				fm.getFeatures().get(0).add(data.get("AmazonRDS"));
				fm.getFeatures().get(0).add(data.get("GoogleCloudSQL"));
				fm.getFeatures().get(0).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(0).add(data.get("HPDatabases"));
				fm.getFeatures().get(0).add(data.get("GoGridDatabases"));
				fm.getFeatures().get(1).add(data.get("AmazonDynamoDB"));
				fm.getFeatures().get(1).add(data.get("Dropbox"));
				fm.getFeatures().get(1).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(1).add(data.get("HPFiles"));
				fm.getFeatures().get(1).add(data.get("GoGridFiles"));
				fm.getFeatures().get(1).add(data.get("GoogleDrive"));
				fm.getFeatures().get(2).add(data.get("AmazonS3"));
				fm.getFeatures().get(2).add(data.get("Dropbox"));
				fm.getFeatures().get(2).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(2).add(data.get("HPFiles"));
				fm.getFeatures().get(2).add(data.get("GoGridFiles"));
				fm.getFeatures().get(2).add(data.get("GoogleDrive"));
				fm.getFeatures().get(3).add(data.get("AmazonRDS"));
				fm.getFeatures().get(3).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(3).add(data.get("GoMessages"));
				solutionSpace=new PermutationSet(fm);
				FeatureModelSolver solver=new FeatureModelSolver(solutionSpace);
				initialSolution =new Solution();
				initialSolution=solutionSpace.getSolution(position);
				solver.setInitalPosition(position);
				long start=System.nanoTime();
				s=solver.solve(initialSolution);
				
				solutionSpace.evaluateSolution(s);
				long stop=System.nanoTime();
				
				double diff=(stop-start)/1000000.0;
				//System.out.println(diff);
				System.out.println(solver.getContInteractions()+"-"+(solver.getContInteractions()-solver.getContSuccessInteractions()));

				//Thread.sleep(3000);
				
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void execute250Solutions() throws InterruptedException{
		FeatureModel fm=new FeatureModel(4);
		String host="jdbc:mysql://127.0.0.1:3306/monitor";
		String user="root";
		String pwd="c3f3t";
		Connection conn=null;
		Statement stmt=null;
		String sql="select * from Service_History";
		ResultSet rs=null;
		short[] position={0,1,0,0};
		Solution s,initialSolution;
		Stopwatch watch=Stopwatch.createUnstarted();
		PermutationSet solutionSpace;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(host, user, pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Feature f;
			rs=stmt.executeQuery(sql);
			rs.next();
			Map<String,Feature>data;
			for(int i=0;i<30;i++){
				fm.getFeatures().clear();
				fm=new FeatureModel(4);
				data=loadData(rs);
				f=new Feature("HPDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("HPDatabases", f);
				f=new Feature("HPFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("HPFiles", f);
				
				f=new Feature("GoGridDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("GoGridDatabases", f);
				f=new Feature("GoGridFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("GoGridFiles", f);
				
				fm.getFeatures().get(0).add(data.get("AmazonRDS"));
				fm.getFeatures().get(0).add(data.get("GoogleCloudSQL"));
				fm.getFeatures().get(0).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(0).add(data.get("HPDatabases"));
				fm.getFeatures().get(0).add(data.get("GoGridDatabases"));
				fm.getFeatures().get(1).add(data.get("AmazonDynamoDB"));
				fm.getFeatures().get(1).add(data.get("Dropbox"));
				fm.getFeatures().get(1).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(1).add(data.get("HPFiles"));
				fm.getFeatures().get(1).add(data.get("GoGridFiles"));
				fm.getFeatures().get(2).add(data.get("AmazonS3"));
				fm.getFeatures().get(2).add(data.get("Dropbox"));
				fm.getFeatures().get(2).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(2).add(data.get("HPFiles"));
				fm.getFeatures().get(2).add(data.get("GoGridFiles"));
				fm.getFeatures().get(3).add(data.get("AmazonRDS"));
				fm.getFeatures().get(3).add(data.get("RackspaceDatabase"));
				solutionSpace=new PermutationSet(fm);
				FeatureModelSolver solver=new FeatureModelSolver(solutionSpace);
				initialSolution =new Solution();
				initialSolution=solutionSpace.getSolution(position);
				solver.setInitalPosition(position);
				long start=System.nanoTime();
				s=solver.solve(initialSolution);
				
				solutionSpace.evaluateSolution(s);
				long stop=System.nanoTime();
				
				double diff=(stop-start)/1000000.0;
				//System.out.println(diff);
				System.out.println(solver.getContInteractions()+"-"+(solver.getContInteractions()-solver.getContSuccessInteractions()));
				//Thread.sleep(3000);
				//System.out.println(milis);
				
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void execute128Solutions() throws InterruptedException{
		FeatureModel fm=new FeatureModel(4);
		String host="jdbc:mysql://127.0.0.1:3306/monitor";
		String user="root";
		String pwd="c3f3t";
		Connection conn=null;
		Statement stmt=null;
		String sql="select * from Service_History";
		ResultSet rs=null;
		short[] position={0,1,0,0};
		Solution s,initialSolution;
		Stopwatch watch=Stopwatch.createUnstarted();
		PermutationSet solutionSpace;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(host, user, pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Feature f;
			rs=stmt.executeQuery(sql);
			rs.next();
			Map<String,Feature>data;
			for(int i=0;i<30;i++){
				fm.getFeatures().clear();
				fm=new FeatureModel(4);
				data=loadData(rs);
				f=new Feature("HPDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("HPDatabases", f);
				f=new Feature("HPFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("HPFiles", f);
				fm.getFeatures().get(0).add(data.get("AmazonRDS"));
				fm.getFeatures().get(0).add(data.get("GoogleCloudSQL"));
				fm.getFeatures().get(0).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(0).add(data.get("HPDatabases"));
				fm.getFeatures().get(1).add(data.get("AmazonDynamoDB"));
				fm.getFeatures().get(1).add(data.get("Dropbox"));
				fm.getFeatures().get(1).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(1).add(data.get("HPFiles"));
				fm.getFeatures().get(2).add(data.get("AmazonS3"));
				fm.getFeatures().get(2).add(data.get("Dropbox"));
				fm.getFeatures().get(2).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(2).add(data.get("HPFiles"));
				fm.getFeatures().get(3).add(data.get("AmazonRDS"));
				fm.getFeatures().get(3).add(data.get("RackspaceDatabase"));
				solutionSpace=new PermutationSet(fm);
				FeatureModelSolver solver=new FeatureModelSolver(solutionSpace);
				initialSolution =new Solution();
				initialSolution=solutionSpace.getSolution(position);
				solver.setInitalPosition(position);
				long start=System.nanoTime();
				s=solver.solve(initialSolution);
				
				solutionSpace.evaluateSolution(s);
				long stop=System.nanoTime();
				
				double diff=(stop-start)/1000000.0;
				//System.out.println(diff);
				System.out.println(solver.getContInteractions()+"-"+(solver.getContInteractions()-solver.getContSuccessInteractions()));
				//Thread.sleep(3000);
				//System.out.println(milis);
				
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void execute64Solutions() throws InterruptedException{
		FeatureModel fm=new FeatureModel(3);
		String host="jdbc:mysql://127.0.0.1:3306/monitor";
		String user="root";
		String pwd="c3f3t";
		Connection conn=null;
		Statement stmt=null;
		String sql="select * from Service_History";
		ResultSet rs=null;
		short[] position={0,1,0};
		Solution s,initialSolution;
		Stopwatch watch=Stopwatch.createUnstarted();
		PermutationSet solutionSpace;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(host, user, pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Feature f;
			rs=stmt.executeQuery(sql);
			rs.next();
			Map<String,Feature>data;
			for(int i=0;i<30;i++){
				fm.getFeatures().clear();
				fm=new FeatureModel(3);
				data=loadData(rs);
				f=new Feature("HPDatabases");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonRDS").getProperties().get("responseTime").getValue()));
				
				data.put("HPDatabases", f);
				f=new Feature("HPFiles");
				f.getProperties().put("responseTime", new FeatureProperty("responseTime", 
						data.get("AmazonS3").getProperties().get("responseTime").getValue()));
				
				data.put("HPFiles", f);
				fm.getFeatures().get(0).add(data.get("AmazonRDS"));
				fm.getFeatures().get(0).add(data.get("GoogleCloudSQL"));
				fm.getFeatures().get(0).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(0).add(data.get("HPDatabases"));
				fm.getFeatures().get(1).add(data.get("AmazonDynamoDB"));
				fm.getFeatures().get(1).add(data.get("Dropbox"));
				fm.getFeatures().get(1).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(1).add(data.get("HPFiles"));
				fm.getFeatures().get(2).add(data.get("AmazonS3"));
				fm.getFeatures().get(2).add(data.get("Dropbox"));
				fm.getFeatures().get(2).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(2).add(data.get("HPFiles"));
				solutionSpace=new PermutationSet(fm);
				FeatureModelSolver solver=new FeatureModelSolver(solutionSpace);
				initialSolution =new Solution();
				initialSolution=solutionSpace.getSolution(position);
				solver.setInitalPosition(position);
				long start=System.nanoTime();
				s=solver.solve(initialSolution);
				
				solutionSpace.evaluateSolution(s);
				long stop=System.nanoTime();
				
				double diff=(stop-start)/1000000.0;
				//System.out.println(diff);
				System.out.println(solver.getContInteractions()+"-"+(solver.getContInteractions()-solver.getContSuccessInteractions()));
				//Thread.sleep(3000);
				//System.out.println(milis);
				
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void execute54Solutions() throws InterruptedException{
		FeatureModel fm=new FeatureModel(3);
		String host="jdbc:mysql://127.0.0.1:3306/monitor";
		String user="root";
		String pwd="c3f3t";
		Connection conn=null;
		Statement stmt=null;
		String sql="select * from Service_History";
		ResultSet rs=null;
		short[] position={0,1,0,0};
		Solution s,initialSolution;
		Stopwatch watch=Stopwatch.createUnstarted();
		PermutationSet solutionSpace;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(host, user, pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery(sql);
			rs.next();
			Map<String,Feature>data;
			for(int i=0;i<30;i++){
				fm.getFeatures().clear();
				fm=new FeatureModel(4);
				data=loadData(rs);
				fm.getFeatures().get(0).add(data.get("AmazonRDS"));
				fm.getFeatures().get(0).add(data.get("GoogleCloudSQL"));
				fm.getFeatures().get(0).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(1).add(data.get("AmazonDynamoDB"));
				fm.getFeatures().get(1).add(data.get("Dropbox"));
				fm.getFeatures().get(1).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(2).add(data.get("AmazonS3"));
				fm.getFeatures().get(2).add(data.get("Dropbox"));
				fm.getFeatures().get(2).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(3).add(data.get("AmazonRDS"));
				fm.getFeatures().get(3).add(data.get("RackspaceDatabase"));
				solutionSpace=new PermutationSet(fm);
				FeatureModelSolver solver=new FeatureModelSolver(solutionSpace);
				initialSolution =new Solution();
				initialSolution=solutionSpace.getSolution(position);
				solver.setInitalPosition(position);
				long start=System.nanoTime();
				s=solver.solve(initialSolution);
				
				solutionSpace.evaluateSolution(s);
				long stop=System.nanoTime();
				
				double diff=(stop-start)/1000000.0;
				//System.out.println(diff);
				System.out.println(solver.getContInteractions()+"-"+(solver.getContInteractions()-solver.getContSuccessInteractions()));
				//Thread.sleep(3000);
				//System.out.println(milis);
				
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void execute27Solutions() throws InterruptedException{
		FeatureModel fm=new FeatureModel(3);
		String host="jdbc:mysql://127.0.0.1:3306/monitor";
		String user="root";
		String pwd="c3f3t";
		Connection conn=null;
		Statement stmt=null;
		String sql="select * from Service_History";
		ResultSet rs=null;
		short[] position={0,1,0};
		Solution s,initialSolution;
		Stopwatch watch=Stopwatch.createUnstarted();
		PermutationSet solutionSpace;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(host, user, pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery(sql);
			rs.next();
			Map<String,Feature>data;
			for(int i=0;i<30;i++){
				fm.getFeatures().clear();
				fm=new FeatureModel(3);
				data=loadData(rs);
				fm.getFeatures().get(0).add(data.get("AmazonRDS"));
				fm.getFeatures().get(0).add(data.get("GoogleCloudSQL"));
				fm.getFeatures().get(0).add(data.get("RackspaceDatabase"));
				fm.getFeatures().get(1).add(data.get("AmazonDynamoDB"));
				fm.getFeatures().get(1).add(data.get("Dropbox"));
				fm.getFeatures().get(1).add(data.get("RackspaceCloudFiles"));
				fm.getFeatures().get(2).add(data.get("AmazonS3"));
				fm.getFeatures().get(2).add(data.get("Dropbox"));
				fm.getFeatures().get(2).add(data.get("RackspaceCloudFiles"));
				solutionSpace=new PermutationSet(fm);
				FeatureModelSolver solver=new FeatureModelSolver(solutionSpace);
				initialSolution =new Solution();
				initialSolution=solutionSpace.getSolution(position);
				long start=System.nanoTime();
				s=solver.solve(initialSolution);
				
				solutionSpace.evaluateSolution(s);
				long stop=System.nanoTime();
				
				double diff=(stop-start)/1000000.0;
				//System.out.println(diff);
				System.out.println(solver.getContInteractions()+"-"+(solver.getContInteractions()-solver.getContSuccessInteractions()));
				//Thread.sleep(3000);
				//System.out.println(milis);
				
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static Map<String, Feature> loadData(ResultSet rs){
		Map<String, Feature>data=new HashMap<String,Feature>();
		Feature f;
		for(int i=0;i<7;i++){
			try {
				f=new Feature(rs.getString("nome"));
				f.getProperties().put("responseTime", new FeatureProperty("responseTime",rs.getDouble("RT")));
				data.put(rs.getString("nome"), f);
				rs.next();
			} catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return data;
	}
	

}
