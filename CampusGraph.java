import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CampusGraph {

    private Map<String, List<String>> adjacencyList;

        public CampusGraph() {
        adjacencyList = new LinkedHashMap<>();
    }

    // 1. Add a new campus location (vertex)
    public boolean addLocation(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("[Error] Location name cannot be empty.");
            return false;
        }
        name = name.trim();
        if (adjacencyList.containsKey(name)) {
            System.out.println("[Error] Location '" + name + "' already exists.");
            return false;
        }
        adjacencyList.put(name, new ArrayList<>());
        System.out.println("[Success] Location '" + name + "' added.");
        return true;
    }

    // 2. Remove a campus location (vertex), along with every road connected to it
    public boolean removeLocation(String name) {
        if (name == null || !adjacencyList.containsKey(name)) {
            System.out.println("[Error] Location '" + name + "' does not exist.");
            return false;
        }
        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(name);
        }
        adjacencyList.remove(name);
        System.out.println("[Success] Location '" + name + "' and its connections were removed.");
        return true;
    }

    // 3. Add a bidirectional road/connection between two existing locations
    public boolean addConnection(String locA, String locB) {
        if (!adjacencyList.containsKey(locA) || !adjacencyList.containsKey(locB)) {
            System.out.println("[Error] Both locations must exist before connecting them.");
            return false;
        }
        if (locA.equals(locB)) {
            System.out.println("[Error] Cannot connect a location to itself.");
            return false;
        }
        if (adjacencyList.get(locA).contains(locB)) {
            System.out.println("[Error] A road between '" + locA + "' and '" + locB + "' already exists.");
            return false;
        }
        adjacencyList.get(locA).add(locB);
        adjacencyList.get(locB).add(locA);
        System.out.println("[Success] Road added between '" + locA + "' and '" + locB + "'.");
        return true;
    }

    // 4. Remove the road/connection between two locations
    public boolean removeConnection(String locA, String locB) {
        if (!adjacencyList.containsKey(locA) || !adjacencyList.containsKey(locB)) {
            System.out.println("[Error] Both locations must exist to remove a connection.");
            return false;
        }
        boolean removedA = adjacencyList.get(locA).remove(locB);
        adjacencyList.get(locB).remove(locA);
        if (!removedA) {
            System.out.println("[Error] No road exists between '" + locA + "' and '" + locB + "'.");
            return false;
        }
        System.out.println("[Success] Road removed between '" + locA + "' and '" + locB + "'.");
        return true;
    }
    
    // 5. Display all locations and their connections
    public void displayConnections() {
        if (adjacencyList.isEmpty()) {
            System.out.println("[Notice] No campus locations have been added yet.");
            return;
        }
        System.out.println("\n--- Campus Network ---");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            String neighbours = entry.getValue().isEmpty()
                    ? "(no connections)"
                    : String.join(", ", entry.getValue());
            System.out.println(entry.getKey() + " -> " + neighbours);
        }
    }

    // 6a. Breadth-First Search: visits the nearest locations first, level by level, using a Queue
    public void traverseBFS(String start) {
        if (start == null || !adjacencyList.containsKey(start)) {
            System.out.println("[Error] Starting location '" + start + "' does not exist.");
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
 
        System.out.print("\n--- BFS Traversal from '" + start + "' ---\n");
        boolean first = true;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print((first ? "" : " -> ") + current);
            first = false;
            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
        reportUnreached(visited);
    }

    // 6b. Depth-First Search: visits as far as possible along each branch before backtracking, using recursion
        public void traverseDFS(String start) {
        if (start == null || !adjacencyList.containsKey(start)) {
            System.out.println("[Error] Starting location '" + start + "' does not exist.");
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        Deque<String> stack = new LinkedList<>();
        stack.push(start);
 
        System.out.print("\n--- DFS Traversal from '" + start + "' ---\n");
        boolean first = true;
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            System.out.print((first ? "" : " -> ") + current);
            first = false;
 
            List<String> neighbours = adjacencyList.get(current);
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                if (!visited.contains(neighbours.get(i))) {
                    stack.push(neighbours.get(i));
                }
            }
        }
        System.out.println();
        reportUnreached(visited);
    }
 
    private void reportUnreached(Set<String> visited) {
        int unreached = adjacencyList.size() - visited.size();
        if (unreached > 0) {
            System.out.println("[Notice] " + unreached + " location(s) were not reachable from the start point.");
        }
    }

    // Lets Main.java validate a location name before prompting for more input
    public boolean hasLocation(String name) {
        return adjacencyList.containsKey(name);
    }


}
