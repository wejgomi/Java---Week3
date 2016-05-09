package database;

import javax.swing.table.*;
import java.sql.*;

import java.util.*;
import javax.swing.event.*;



public class FillTable extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	private int rowCount;
	private int colCount;
	
	private ArrayList data = new ArrayList();

	//constructor 
	public FillTable(ResultSet rs) throws Exception{
		this.rs = rs;
		
		//get information from ResultSet object
		ResultSetMetaData md = rs.getMetaData();
		rowCount = 0;
		colCount = md.getColumnCount();
		
		while(rs.next()){
			Object[] row = new Object[colCount];
			for (int j = 0; j<colCount; j++){
				row[j] = rs.getObject(j+1);
			}
			data.add(row);
			rowCount++;
		}
		
	}
	public int getColumnCount(){
		return colCount;
	}
	public int getRowCount(){
		return rowCount;
	}
	
	public Object getValueAt(int rowIndex, int colIndex){
		Object[] row =  (Object[]) data.get(rowIndex);
		return row[colIndex];
	}
	public String getColumnName(int colIndex){
		try{
			ResultSetMetaData md = rs.getMetaData();
			return md.getColumnName(colIndex + 1);
			
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
