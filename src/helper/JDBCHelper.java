package helper;

import java.sql.*;

public class JDBCHelper {
	String url;
	String uname;
	String pass;	
	Statement st;
	ResultSet rs;
	Connection con;
	
	
 public JDBCHelper(String url,String uname,String pass) throws SQLException {
	 this.url=url;
	 this.uname=uname;
	 this.pass=pass;	 
	 con=DriverManager.getConnection(url,uname,pass);
	    //Statement st=con.createStatement();
	  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);
 }
 
 public void UpdateQuery(String query) throws SQLException 
 { 
	 rs=st.executeQuery(query);
	 System.out.println("query updated");
 }
 
 public String GetString(int row ,String ColumnName) throws Exception {
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	 rs.absolute(row);
	 return rs.getString(ColumnName); 
 } 

 public int GetInt(int row ,String ColumnName) throws Exception {
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	 rs.absolute(row);
	 return rs.getInt(ColumnName); 
 }  
 
 public void UpdateRow(int row,int column ,int value) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	 rs.updateInt(column, value);
	   rs.updateRow();
	   System.out.println("value have been updatedd to column no"+column +"and row no:" +row); 
 }

 public void InsertRow(int column ,int value) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	   rs.moveToInsertRow();
	   rs.updateInt(column, value);
	   rs.insertRow();
	   System.out.println("value have been insertedd to column no"+column ); 
 }
 
 public void InsertRow(int column ,String value) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	   rs.moveToInsertRow();
	   rs.updateString(column, value);
	   rs.insertRow();
	   System.out.println("value have been insertedd to column no"+column ); 
 }
 
 public void InsertRow(int[] columns ,int[] values) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	 if(columns.length!=values.length) {
		 throw new Exception("size of columns and Strings must be equal");
	 }
	 rs.moveToInsertRow();
  for(int i=0;i<values.length;i++) {
	  rs.updateInt(columns[i], values[i]);	  
  }
	   rs.insertRow();
	   System.out.println("values have been inserted" ); 
 }
 
 public void InsertRow(int[] columns ,String[] values) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	 if(columns.length!=values.length) {
		 throw new Exception("size of columns and Strings must be equal");
	 }
	 rs.moveToInsertRow();
  for(int i=0;i<values.length;i++) {
	  rs.updateString(columns[i], values[i]);	  
  }
	   rs.insertRow();
	   System.out.println("values have been inserted" ); 
 }
 
 public void UpdateRow(int row,int column ,String value) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	   rs.updateString(column, value);
	   rs.updateRow();
	   System.out.println("value have been updatedd to column no"+column +"and row no:" +row); 
 }
 
 public void UpdateRow(int row,int[] columns ,String[] values) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	 if(columns.length!=values.length) {
		 throw new Exception("size of columns and Strings must be equal");
	 }
  for(int i=0;i<values.length;i++) {
	  rs.updateString(columns[i], values[i]);	  
  }
	   rs.updateRow();
	   System.out.println("values have been updatedd to row no:" +row); 
 }
 
 public void UpdateRow(int row,int[] columns ,int[] values) throws Exception{
	 if(rs==null) {
		 throw new Exception("No queries have been updated !!,Try to update a query  ");
	 }
	 if(columns.length!=values.length) {
		 throw new Exception("size of columns and Strings must be equal");
	 }
  for(int i=0;i<values.length;i++) {
	  rs.updateInt(columns[i], values[i]);	  
  }
	   rs.updateRow();
	   System.out.println("values have been updatedd to row no:" +row); 
 }
 
 public void DeleteRow(int row) throws SQLException {
	 rs.absolute(row);
	 rs.deleteRow();
     System.out.println("row no."+row+" have been Deleted");
 }
 
 public int FindLastRow() throws SQLException {
	 int n=0;
	 while(rs.next()) {
		 n++;
	 }
	 return n;
 }
 
 
 public void End() throws SQLException {
	   st.close();
	   con.close(); 
 }
}
