public class APIClient {
   //Method 1:Single parameter (endpoint only)
    public void sendRequest(String endpoint) {
        System.out.println("GET Request sent to: " + endpoint);
        System.out.println("Response:200 OK(Default success)");
    }
    
    //Method 2:Three parameters (endpoint, requestBody, requestStatus)
    public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
        System.out.println("POST Request to: " + endpoint);
        System.out.println("Request Body: " + requestBody);
        if (requestStatus) {
            System.out.println("Status:SUCCESS(200 OK)");
        } else {
            System.out.println("Status:FAILED(500 Error)");
        }
    }
    
    //Main method to demonstrate overloading
    public static void main(String[] args) {
        // Create APIClient object using new keyword
        APIClient client = new APIClient();
        
        // Call single-parameter version
        System.out.println("=== Simple GET Request ===");
        client.sendRequest("/api/users");
     
        // Call three-parameter version (passed status)
        System.out.println("\n=== POST Request with Body ===");
        client.sendRequest("/api/orders","{\"product\":\"Laptop\",\"qty\":1}",true);
      
        // Another three-parameter call (failed status)
        System.out.println("\n=== Failed POST Request ==="); 
        client.sendRequest("/api/payment","{\"amount\":500}",false);
    }
}

