import helper.jsqlAPI;

public class Test {

	public static void main(String[] args) throws Exception {
		

		String url="jdbc:mysql://localhost:3306/mysql";
		String uname="root";
		String pass="root@123";
		String query="Select * from items;";
		
	  jsqlAPI api=new jsqlAPI(url,uname,pass);
	  api.UpdateQuery(query);
	  
	  api.InsertRow(2,"pen");
	  
	  api.InsertRow(2,"pencil");

	  api.InsertRow(2,"eraser");

	  api.InsertRow(2,"bottle");
	  
	  
	  Log(api.GetString(1, "name"));
	  api.UpdateRow(1, 3, 2);
	  api.UpdateRow(2, 3, 10);
	  api.UpdateRow(3, 3, 1);
	  api.UpdateRow(4, 3, 60);
	  
	  //Log(api.GetString(1, "name"));	  
	  api.DeleteRow(5); 
      api.End();
	}
  
	
	static void Log(String value) {
		System.out.println(value);
	}
}
