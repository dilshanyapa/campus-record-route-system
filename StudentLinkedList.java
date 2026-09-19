public class StudentLinkedList {
    private StudentNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    // Check if a student ID already exists 
    public boolean contains(String studentID) {
        StudentNode current = head;
        while (current != null) {
            if (current.data.getStudentID().equalsIgnoreCase(studentID)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Add a student record to the end of the list
    public void addStudent(Student student) {
        StudentNode newNode = new StudentNode(student);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    //Update an existing student record by ID
    public boolean updateStudent(String studentID, String newName, String newProgramme, double newMarks) {
        StudentNode current = head;
        while (current != null) {
            if (current.data.getStudentID().equalsIgnoreCase(studentID)) {
                current.data.setName(newName);
                current.data.setProgramme(newProgramme);
                current.data.setMarks(newMarks);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Delete a student record by ID
    public boolean deleteStudent(String studentID) {
        if (head == null) {
            return false;
        }

        // If head node itself holds the ID to be deleted
        if (head.data.getStudentID().equalsIgnoreCase(studentID)) {
            head = head.next;
            return true;
        }

        StudentNode current = head;
        while (current.next != null && !current.next.data.getStudentID().equalsIgnoreCase(studentID)) {
            current = current.next;
        }

        // If record not found
        if (current.next == null) {
            return false;
        }

        // Unlink the node
        current.next = current.next.next;
        return true;
    }

    //Display all records in the list
    public void displayAll() {
        if (head == null) {
            System.out.println("[Notice] No student records available to display.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-20s | %-15s | %-8s\n", "Student ID", "Name", "Programme", "Marks");
        System.out.println("--------------------------------------------------------------------------------");

        StudentNode current = head;
        while (current != null) {
            Student s = current.data;
            System.out.printf("%-12s | %-20s | %-15s | %-8.2f\n", 
                              s.getStudentID(), s.getName(), s.getProgramme(), s.getMarks());
            current = current.next;
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    //Retrieve a student record by ID
    public Student getStudent(String studentID) {
        StudentNode current = head;
        while (current != null) {
            if (current.data.getStudentID().equalsIgnoreCase(studentID)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
}
