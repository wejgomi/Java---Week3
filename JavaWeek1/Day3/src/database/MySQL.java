package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


import java.util.HashSet;
import java.util.Set;



//connect and send statements

public class MySQL {
	//declare variables
	private Connection conn = null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	public FillTable connectToDatabase(String st) throws Exception{
		
		//create collection of words
		Set<String> words = new HashSet<String>();
		words.add("insert");
		words.add("delete");
		words.add("update");
		words.add("create");
		
		// load the driver
		try{
			Class.forName("com.mysql.jdbc.Driver"); // name for driver for MySQL, there are different names for different server eg Microsoft Server
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biraj","root", "Password100");
					//biraj = name of table, 3306 = port no.
			
			boolean updateQ = containsWord(words, st);
			
			//create a statement
			statement = conn.createStatement();
			if(updateQ == true){
				//insert, delete, create	
				statement .executeUpdate(st);
			}else {
				//for query - Select "in mySql cmd line"
				rs = statement.executeQuery(st);
			}
		
		FillTable model = new FillTable(rs);
		return model;
		} catch (Exception e){
			throw e;
		}
	
	}

	public boolean containsWord(Set<String> words, String st){
		for(String w : words){
			if(st.contains(w)) return true;
		}
		return false;
	}
}
