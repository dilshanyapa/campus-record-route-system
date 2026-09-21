import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // MEMBER 1 (Y.M.C.D.Yapa): PRIMARY DATA STRUCTURE

        StudentLinkedList studentList = new StudentLinkedList();

        // Member 2 (Chanuki Waththuhewa):
        ActionStack historyStack = new ActionStack();
        RequestQueue requestQueue = new RequestQueue();

        // Member 3 (Sadhanee Devindi):
        StudentBST studentBST = new StudentBST();
        StudentHashTable studentHashTable = new StudentHashTable();

        // Member 4 (Dushan Maleesha):
        // CampusGraph campusGraph = new CampusGraph();

        boolean running = true;

        while (running) {
            System.out.println("\n========================================================");
            System.out.println(" SLTC STUDENT RECORD & CAMPUS ROUTE SYSTEM");
            System.out.println("========================================================");
            System.out.println(" 1. Add Student Record");
            System.out.println(" 2. Update Student Record");
            System.out.println(" 3. Delete Student Record");
            System.out.println(" 4. Display All Records using Linked List");
            System.out.println(" 5. Add Service Request to Queue");
            System.out.println(" 6. Process Next Service Request");
            System.out.println(" 7. Display Recent Actions using Stack");
            System.out.println(" 8. Display Students using BST/AVL");
            System.out.println(" 9. Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection/Road");
            System.out.println("13. Remove Campus Connection/Road");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse Campus Locations using BFS or DFS");
            System.out.println("16. Exit");
            System.out.println("========================================================");
            System.out.print("Enter your choice (1-16): ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[Error] Invalid input format. Please enter an integer between 1 and 16.");
                continue;
            }

            switch (choice) {
                // MEMBER 1 IMPLEMENTATION: CASES 1 - 4
                case 1:
                    // Add Student Record
                    System.out.println("\n--- Add Student Record ---");
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine().trim();
                    if (id.isEmpty()) {
                        System.out.println("[Error] Student ID cannot be empty.");
                        break;
                    }
                    if (studentList.contains(id)) {
                        System.out.println("[Error] Student ID '" + id + "' already exists in the system.");
                        break;
                    }

                    System.out.print("Enter Full Name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("[Error] Student name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Programme: ");
                    String programme = scanner.nextLine().trim();
                    if (programme.isEmpty()) {
                        System.out.println("[Error] Programme cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Marks (0.00 - 100.00): ");
                    double marks;
                    try {
                        marks = Double.parseDouble(scanner.nextLine().trim());
                        if (marks < 0 || marks > 100) {
                            System.out.println("[Error] Marks must be between 0 and 100.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("[Error] Invalid marks input. Must be a numeric value.");
                        break;
                    }

                    Student newStudent = new Student(id, name, programme, marks);
                    studentList.addStudent(newStudent);

                    // --- Integration Hooks for Members 2 & 3 ---
                    // historyStack.push("Added student record: " + id);
                    studentBST.insert(newStudent);
                    studentHashTable.put(id, newStudent);

                    System.out.println("[Success] Student record added successfully.");
                    break;

                case 2:
                    // Update Student Record
                    System.out.println("\n--- Update Student Record ---");
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine().trim();
                    if (!studentList.contains(updateId)) {
                        System.out.println("[Error] Student ID '" + updateId + "' does not exist.");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine().trim();
                    if (newName.isEmpty()) {
                        System.out.println("[Error] Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter New Programme: ");
                    String newProg = scanner.nextLine().trim();
                    if (newProg.isEmpty()) {
                        System.out.println("[Error] Programme cannot be empty.");
                        break;
                    }

                    System.out.print("Enter New Marks (0.00 - 100.00): ");
                    double newMarks;
                    try {
                        newMarks = Double.parseDouble(scanner.nextLine().trim());
                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println("[Error] Marks must be between 0 and 100.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("[Error] Invalid marks input.");
                        break;
                    }

                    boolean updated = studentList.updateStudent(updateId, newName, newProg, newMarks);
                    if (updated) {
                        // --- Integration Hook for Member 2 ---
                        // historyStack.push("Updated student record: " + updateId);
                        System.out.println("[Success] Student record updated successfully.");
                    } else {
                        System.out.println("[Error] Could not update record.");
                    }
                    break;

                case 3:
                    // Delete Student Record
                    System.out.println("\n--- Delete Student Record ---");
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine().trim();

                    boolean deleted = studentList.deleteStudent(deleteId);
                    if (deleted) {
                        // --- Integration Hook for Member 2 ---
                        // historyStack.push("Deleted student record: " + deleteId);
                        System.out.println("[Success] Student record deleted successfully.");
                    } else {
                        System.out.println("[Error] Student ID '" + deleteId + "' not found.");
                    }
                    break;

                case 4:
                    // Display All Records via Linked List
                    studentList.displayAll();
                    break;

                // MEMBER 2 PLACEHOLDERS: CASES 5 - 7 (Stack & Queue)

                case 5:
                    // Add Service Request to Queue
                    System.out.println("[Notice] Service Request Queue functionality (Assigned to Member 2).");
                    // Member 2 code hook:
                    System.out.print("Enter Student ID: ");
                    String reqStudentId = scanner.nextLine().trim();
                    System.out.print("Enter Service Description: ");
                    String desc = scanner.nextLine().trim();
                    requestQueue.enqueue(new ServiceRequest(reqStudentId, desc));
                    break;

               case 6:
                    // Process Next Service Request
                    System.out.println("\n--- Process Next Service Request ---");
                    if (requestQueue.isEmpty()) {
                        System.out.println("[Notice] Queue is empty. No service requests to process.");
                    } else {
                        ServiceRequest processed = requestQueue.dequeue();
                        if (processed != null) {
                            historyStack.push("Processed service request for: " + processed.getStudentID());
                            System.out.println("[Success] Processed request: " + processed);
                        }
                    }
                    break;

                case 7:
                    // Display Recent Actions using Stack
                    System.out.println("[Notice] Recent Actions Stack functionality (Assigned to Member 2).");
                    // Member 2 code hook:
                    historyStack.displayHistory();
                    break;

                // MEMBER 3 PLACEHOLDERS: CASES 8 - 9 (Tree & Hashing)

                case 8:
                    // Display Students using BST/AVL
                    studentBST.inOrderTraversal();
                    break;

                case 9:
                    // Search Student using Hashing
                    System.out.print("Enter Student ID to search: ");
                    String searchKey = scanner.nextLine().trim();
                    if (searchKey.isEmpty()) {
                        System.out.println("[Error] Student ID cannot be empty.");
                        break;
                    }
                    Student res = studentHashTable.get(searchKey);
                    if (res != null) {
                        System.out.println("[Found] " + res);
                    } else {
                        System.out.println("[Error] Student ID '" + searchKey + "' not found.");
                    }
                    break;

                // MEMBER 4 PLACEHOLDERS: CASES 10 - 15 (Graph & Traversals)

                case 10:
                    // Add Campus Location
                    System.out.println("[Notice] Add Campus Location functionality (Assigned to Member 4).");
                    // Member 4 code hook:
                    // System.out.print("Enter Location Name: ");
                    // String loc = scanner.nextLine().trim();
                    // campusGraph.addLocation(loc);
                    break;

                case 11:
                    // Remove Campus Location
                    System.out.println("[Notice] Remove Campus Location functionality (Assigned to Member 4).");
                    // Member 4 code hook:
                    // System.out.print("Enter Location Name to remove: ");
                    // campusGraph.removeLocation(scanner.nextLine().trim());
                    break;

                case 12:
                    // Add Campus Connection/Road
                    System.out.println("[Notice] Add Campus Road functionality (Assigned to Member 4).");
                    // Member 4 code hook:
                    // System.out.print("Enter Source Location: ");
                    // String src = scanner.nextLine().trim();
                    // System.out.print("Enter Destination Location: ");
                    // String dest = scanner.nextLine().trim();
                    // campusGraph.addConnection(src, dest);
                    break;

                case 13:
                    // Remove Campus Connection/Road
                    System.out.println("[Notice] Remove Campus Road functionality (Assigned to Member 4).");
                    // Member 4 code hook:
                    // campusGraph.removeConnection(src, dest);
                    break;

                case 14:
                    // Display Campus Connections
                    System.out.println("[Notice] Display Campus Network functionality (Assigned to Member 4).");
                    // Member 4 code hook:
                    // campusGraph.displayNetwork();
                    break;

                case 15:
                    // Traverse Campus Locations (BFS or DFS)
                    System.out.println("[Notice] Campus Graph Traversal functionality (Assigned to Member 4).");
                    // Member 4 code hook:
                    // campusGraph.traverseBFS("Library");
                    break;

                case 16:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("[Error] Invalid option. Please select a valid number between 1 and 16.");
                    break;
            }
        }
        scanner.close();
    }
}