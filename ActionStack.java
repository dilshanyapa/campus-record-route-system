public class ActionStack {

    // Internal node representing an action in the stack
    private class StackNode {
        String action;
        StackNode next;

        StackNode(String action) {
            this.action = action;
            this.next = null;
        }
    }

    private StackNode top;
    private int count;

    // Initialize an empty stack
    public ActionStack() {
        this.top = null;
        this.count = 0;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Push
    public void push(String action) {
        StackNode newNode = new StackNode(action);
        newNode.next = top;
        top = newNode;
        count++;
    }

    // Pop
    public String pop() {
        if (isEmpty()) {
            System.out.println("No recent actions found.");
            return null;
        }
        String recentAction = top.action;
        top = top.next;
        count--;
        return recentAction;
    }

    // Peek
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return top.action;
    }

    // Display history
    public void displayHistory() {
        if (isEmpty()) {
            System.out.println("No recent actions recorded.");
            return;
        }

        System.out.println("\n--- Recent System Actions (Stack: Newest First) ---");
        StackNode current = top;
        int index = 1;
        while (current != null) {
            StringBuilder line = new StringBuilder();
            line.append(index).append(". ").append(current.action);
            System.out.println(line.toString());
            current = current.next;
            index++;
        }
        System.out.println("---------------------------------------------------");
    }

    
    public void displayActions() {
        displayHistory();
    }

    
    public int getCount() {
        return count;
    }
}