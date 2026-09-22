// Represents a student service request in the queue
public class ServiceRequest {
    private static int counter = 1;
    private String requestId;
    private String studentId;
    private String description;

    // Constructor with 2 parameters 
    public ServiceRequest(String studentId, String description) {
        this.requestId = "REQ" + (counter++);
        this.studentId = studentId;
        this.description = description;
    }

    // Constructor with 3 parameters
    public ServiceRequest(String requestId, String studentId, String description) {
        this.requestId = requestId;
        this.studentId = studentId;
        this.description = description;
    }

    // Getters
    public String getRequestId() {
        return requestId;
    }

    public String getStudentId() {
        return studentId;
    }

   
    public String getStudentID() {
        return studentId;
    }

    public String getDescription() {
        return description;
    }

    // Display formatted request details
    public void displayRequest() {
        System.out.println("Request ID : " + requestId);
        System.out.println("Student ID : " + studentId);
        System.out.println("Description: " + description);
    }

    
    @Override
    public String toString() {
        return "[" + requestId + "] Student ID: " + studentId + " - " + description;
    }
}