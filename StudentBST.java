public class StudentBST {

    private class TreeNode {
        Student data;
        TreeNode left;
        TreeNode right;

        TreeNode(Student data) {
            this.data = data;
        }
    }

    private TreeNode root;

    // Insert a student
    public boolean insert(Student student) {
        if (search(student.getStudentID()) != null) {
            return false;
        }
        root = insertRec(root, student);
        return true;
    }

    private TreeNode insertRec(TreeNode node, Student student) {
        if (node == null) {
            return new TreeNode(student);
        }
        if (student.getStudentID().compareToIgnoreCase(node.data.getStudentID()) < 0) {
            node.left = insertRec(node.left, student);
        } else {
            node.right = insertRec(node.right, student);
        }
        return node;
    }

    // Find a student by ID
    public Student search(String studentID) {
        TreeNode current = root;
        while (current != null) {
            int cmp = studentID.compareToIgnoreCase(current.data.getStudentID());
            if (cmp == 0) {
                return current.data;
            }
            current = (cmp < 0) ? current.left : current.right;
        }
        return null;
    }

    // Delete a student by ID
    public boolean delete(String studentID) {
        if (search(studentID) == null) {
            return false;
        }
        root = deleteRec(root, studentID);
        return true;
    }

    private TreeNode deleteRec(TreeNode node, String studentID) {
        if (node == null) {
            return null;
        }
        int cmp = studentID.compareToIgnoreCase(node.data.getStudentID());
        if (cmp < 0) {
            node.left = deleteRec(node.left, studentID);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, studentID);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;


            TreeNode successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            node.data = successor.data;
            node.right = deleteRec(node.right, successor.data.getStudentID());
        }
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Display all students(in-order traversal)
    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("[Notice] No student records available in the BST.");
            return;
        }

        System.out.println("\n--- Students sorted by ID (BST in-order traversal) ---");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-20s | %-15s | %-8s\n", "Student ID", "Name", "Programme", "Marks");
        System.out.println("--------------------------------------------------------------------------------");
        inOrderRec(root);
        System.out.println("--------------------------------------------------------------------------------");
    }

    private void inOrderRec(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderRec(node.left);
        Student s = node.data;
        System.out.printf("%-12s | %-20s | %-15s | %-8.2f\n",
                          s.getStudentID(), s.getName(), s.getProgramme(), s.getMarks());
        inOrderRec(node.right);
    }
}