public interface DatabaseConnection {
	 void connect();
	 void disconnect();
	 void executeUpdate();

}

public class JavaConnection implements DatabaseConnection {
	@Override
	public void connect() {
		System.out.println("Connected to Java Database(JDBCDriver Loaded)");
		
	}

	@Override
	public void disconnect() {
		 System.out.println("Disconnected from Database");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("SQL UPDATE executed successfully");
		
	}
	public static void main(String[] args) {
		JavaConnection db=new JavaConnection();
		db.connect();
		db.disconnect();
		db.executeUpdate();
	}

}
