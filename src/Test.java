import helper.JDBCHelper;

public class Test {

	public static void main(String[] args) throws Exception {
		

		String url="jdbc:mysql://localhost:3306/mysql";
		String uname="root";
		String pass="root@123";
		String query="Select * from items;";
		
	  JDBCHelper jdbc=new JDBCHelper(url,uname,pass);
	  jdbc.UpdateQuery(query);
	  
//	  jdbc.InsertRow(2,"pen");
//	  
//	  jdbc.InsertRow(2,"pencil");
//
//	  jdbc.InsertRow(2,"eraser");
//
//	  jdbc.InsertRow(2,"bottle");
	  
	  
	  Log(jdbc.GetString(1, "name"));
	  jdbc.UpdateRow(1, 3, 2);
	  jdbc.UpdateRow(2, 3, 10);
	  jdbc.UpdateRow(3, 3, 1);
	  jdbc.UpdateRow(4, 3, 60);
	  
	  //Log(jdbc.GetString(1, "name"));	  
	  jdbc.DeleteRow(5); 
      jdbc.End();
	}
  
	
	static void Log(String value) {
		System.out.println(value);
	}
}
