# 🧠 Heap-Based Priority Queue (Java)

A custom implementation of **Min Priority Queue** and **Max Priority Queue** from scratch using a **Binary Heap** in Java.

This project demonstrates strong understanding of:
- Data Structures (**Heap / Complete Binary Tree**)
- Object-Oriented Programming (**Generics, Encapsulation**)
- Algorithm Design (**Heapify operations**)

---

## 🚀 Features

- ✅ Min Priority Queue (Smallest priority first)
- ✅ Max Priority Queue (Largest priority first)
- ✅ Generic implementation using `<T>`
- ✅ Custom `Element<T>` (value + priority mapping)
- ✅ Heap implemented using `ArrayList`
- ✅ Efficient insert & delete using heapify
- ✅ Custom Exception handling

---

## 🧩 Core Concept Behind Implementation

### 🌳 1. Complete Binary Tree (CBT)

The heap is always maintained as a **Complete Binary Tree**, meaning:

- All levels are completely filled except possibly the last
- The last level is filled **from left to right**

👉 This property ensures:
- Efficient storage using **ArrayList (no pointers needed)**
- Easy index relationships:
  - Parent = `(i - 1) / 2`
  - Left Child = `2i + 1`
  - Right Child = `2i + 2`

---

### ⚖️ 2. Heap Order Property

Depending on the type:

#### 🔹 Min Heap
- Parent node ≤ Children  
- Root contains **minimum element**

#### 🔹 Max Heap
- Parent node ≥ Children  
- Root contains **maximum element**

---

## ⚙️ How Heap Maintains These Properties

### ➤ Insert Operation (Heapify-Up)

1. Insert element at the end (maintains CBT)
2. Compare with parent
3. Swap until heap order is restored

➡️ Ensures both:
- CBT structure ✔
- Heap order ✔

---

### ➤ Remove Operation (Heapify-Down)

1. Remove root element
2. Replace with last element
3. Compare with children
4. Swap with correct child until order is restored

➡️ Again maintains:
- CBT structure ✔
- Heap order ✔

---

## ⚙️ Time Complexity

| Operation         | Complexity |
|------------------|----------|
| Insert           | O(log n) |
| Remove (Min/Max) | O(log n) |
| Peek             | O(1)     |
| Space            | O(n)     |

---

## 🏗️ Project Structure
```
priorityqueue/
│
├── Element.java
├── Priority_Queue.java # Min Priority Queue
├── PriorityQueueException.java
├── PriorityQueueTest.java
│
maxPriorityQueue/
│
├── mPriority_Queue.java # Max Priority Queue
```

---

## 💻 Sample Usage

```java
Priority_Queue<String> pq = new Priority_Queue<>();

pq.insert("A", 3);
pq.insert("B", 1);
pq.insert("C", 2);

System.out.println(pq.getMin());    // B
System.out.println(pq.removeMin()); // B
```
# 🌟 Bonus Highlights (Key Strengths)
```
🔥 1. Generic Implementation (<T>)
Works with any data type
Makes the structure reusable and scalable
🔥 2. Complete Binary Tree via Array
No explicit tree structure used
Efficient mapping using indices
Shows strong understanding of internal heap representation
🔥 3. Dual Heap Design
Implemented both:
Min Priority Queue
Max Priority Queue
Demonstrates deeper mastery (not just basic problem-solving)
🔥 4. From Scratch Implementation
No use of Java’s built-in PriorityQueue
Full control over heap operations
Strong DSA foundation
🔥 5. Clean OOP Design
Element<T> separates value & priority
Encapsulation maintained
Custom exception handling
```

# 👨‍💻 Author
Mrutunjaya Panda

# ⭐ Support
If you found this useful, give it a ⭐ and feel free to fork!
