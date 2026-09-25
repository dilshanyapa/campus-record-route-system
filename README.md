# SLTC Student Record & Campus Route System

A modular Java console application designed for student information records and campus route navigation. The system implements foundational data structures from scratch without relying on built-in collections, including custom Singly Linked Lists, Stacks, Queues, Binary Search Trees, Hash Tables with Separate Chaining, and Adjacency List Graphs.

Developed for **CIT300 Data Structures & Algorithms — Graded Practical Assignment 1**.

---

## 👥 Team Details & Contribution Matrix

**Team Number:** 49  

| Student ID | Member Name | Assigned Role | Data Structures & Responsibilities | Handled Menu Options |
| :--- | :--- | :--- | :--- | :--- |
| **23DA2-0236** | **Y. M. C. D. Yapa** | **Member 1 (Leader)** | Core `Student` model, `StudentNode`, custom `StudentLinkedList` (Insert, Search, Update, Pointer Relinking Deletion) | Options 1 – 4 |
| **23DA2-0238** | **W. H. M. Chanuki** | **Member 2** | `ServiceRequest` model, pointer-based `RequestQueue` (FIFO Enqueue/Dequeue), linked `ActionStack` (LIFO Auditing) | Options 5 – 7 |
| **23DA2-0041** | **P. K. Sadhanee Devindi** | **Member 3** | `StudentBST` (Recursive BST insertion, In-order traversal), `StudentHashTable` (Custom hash function, Separate Chaining lookup) | Options 8 – 9 |
| **23DA2-0101** | **H. N. M. Dushan** | **Member 4** | `CampusGraph` (Adjacency List vertex & bidirectional edge management, Breadth-First Search / Depth-First Search traversal) | Options 10 – 15 |

---

## 📌 System Architecture & Implemented Data Structures

1. **Singly Linked List (`StudentLinkedList.java`):**
   * Stores dynamic student entities (`Student.java`) with unique IDs, full names, academic programmes, and marks.
   * Handles head and middle-node deletions via pointer rewiring with boundary checks ($0 \le \text{marks} \le 100$) and duplicate ID detection.

2. **FIFO Queue (`RequestQueue.java`):**
   * Manages student operational inquiries (`ServiceRequest.java`) strictly in arrival order using `front` and `rear` pointers with underflow protection.

3. **LIFO Stack (`ActionStack.java`):**
   * Maintains an audit trail of mutations (adds, updates, deletions, and processed requests) using a linked `top` pointer for reverse-chronological review.

4. **Binary Search Tree (`StudentBST.java`):**
   * Automatically organizes student records in lexicographical order based on `studentID`, enabling in-order traversal sorting.

5. **Hash Table with Separate Chaining (`StudentHashTable.java`):**
   * Provides average $O(1)$ constant-time student record lookup by hashing the `studentID` into bucket arrays with linked collision chains.

6. **Graph Network (`CampusGraph.java`):**
   * Models campus facilities as vertices and bidirectional roads as edges using an Adjacency List. Supports path traversal via Breadth-First Search (BFS) / Depth-First Search (DFS) while preventing cyclical traversal loops.

---

## 📋 Complete Menu Operations (Options 1–16)

```text
========================================================
 SLTC STUDENT RECORD & CAMPUS ROUTE SYSTEM
========================================================
 1. Add Student Record
 2. Update Student Record
 3. Delete Student Record
 4. Display All Records using Linked List
 5. Add Service Request to Queue
 6. Process Next Service Request
 7. Display Recent Actions using Stack
 8. Display Students using BST/AVL
 9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS or DFS
16. Exit
========================================================