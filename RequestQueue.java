public class RequestQueue {

    // Internal node representing an element in the queue
    private class QueueNode {
        ServiceRequest data;
        QueueNode next;

        QueueNode(ServiceRequest data) {
            this.data = data;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;
    private int size;

    // Initialize an empty queue
    public RequestQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue
    public void enqueue(ServiceRequest request) {
        QueueNode newNode = new QueueNode(request);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Service request [" + request.getRequestId() + "] added to queue successfully.");
    }

    // Dequeue
    public ServiceRequest dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No service requests to process.");
            return null;
        }
        ServiceRequest processedRequest = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return processedRequest;
    }

    // Display all pending service requests in arrival order
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No pending service requests in the queue.");
            return;
        }

        System.out.println("\n--- Pending Service Requests (Queue) ---");
        QueueNode current = front;
        int count = 1;
        while (current != null) {
            System.out.println("[" + count + "]");
            current.data.displayRequest();
            System.out.println("----------------------------------------");
            current = current.next;
            count++;
        }
    }

    
    public int getSize() {
        return size;
    }
}