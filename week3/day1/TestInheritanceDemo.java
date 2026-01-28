public class TestData {
	 public void enterCredentials() {
	        System.out.println("Entering test credentials...");
	        System.out.println("Username: testuser@example.com");
	        System.out.println("Password: Test@123");
	    }
	    
	    public void navigateToHomePage() {
	        System.out.println("Navigating to Home Page...");
	        System.out.println("URL:https://www.testleaf.com/home");
	    }
}

public class LoginTestData extends TestData {
	public void enterUsername() {
        System.out.println("Entering Username: admin@test.com");
    }
    
    public void enterPassword() {
        System.out.println("Entering Password: SecurePass123!");
    }

}

public class TestInheritanceDemo {

	public static void main(String[] args) {
		// Create superclass object
        System.out.println("=== Superclass TestData Demo ===");
        TestData testData = new TestData();
        testData.enterCredentials();
        testData.navigateToHomePage();
        
        System.out.println("\n=== Subclass LoginTestData Demo ===");
        // Create subclass object (inherits superclass methods!)
        LoginTestData loginData = new LoginTestData();
        loginData.enterCredentials();
        loginData.navigateToHomePage();
        loginData.enterUsername();
        loginData.enterPassword();

	}

}
