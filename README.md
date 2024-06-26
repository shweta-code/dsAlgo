# DS - Algo

**Concepts**

1. Heaps are complete Binary Tree.
2. Tree Map/ Red Black Trees in JAVA - [Internal Working of TreeMap in Java - GeeksforGeeks](https://www.geeksforgeeks.org/internal-working-of-treemap-in-java/)
3. Graphs - Kahns, Topolgical Sort, Union Find, Cycle Detection, Disjoint Set ([(3) Explore - LeetCode](https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3840/))
4. Quick Union is when you track of roots of each node. Quick Union is when you keep track of parent of each node not roots.
5. Kahn's algorithm, Union Find can be used to detect cycle in graph.

* **1). hash function design**: the purpose of hash function is to map a key value to an address in the storage space, similarly to the system that we assign a postcode to each mail address.
  As one can image, for a good hash function, it should map different keys ***evenly*** across the storage space, so that we don't end up with the case that the majority of the keys are *concentrated* in a few spaces.
* **2). collision handling**: essentially the hash function reduces the vast key space into a limited address space. As a result, there could be the case where two different keys are mapped to the same address, which is what we call *'collision'*.
  Since the collision is inevitable, it is important that we have a strategy to handle the collision.

// Algorithmic Questions for

Binary Search - Edge Case - low, mid, high are same element
low and mid = i ; high = i+1

``

**Google Preparation**

a) Framework -

1. Clarify - Validity of Input, Limits of input, Return Type, Input Type, return modulo?, Longs/Integers?
2. Assume - If input is sorted
3. Start Simple - Define scope, input and expected output during this exercise. Ask for optimization that needs to be done- Time Complexity and Space Complexity
4. Iterate
5. Implement

b)  Have to do Combinatorics, Divide and Conquer, BST question too, Binary Search Algo, Water Rain Trapping, Montone Increasing Q, [Word Ladder - LeetCode](https://leetcode.com/problems/word-ladder/), Heap, [Subtree of Another Tree - LeetCode,](https://leetcode.com/problems/subtree-of-another-tree/).Design Problems in Editorail/Solution section of [Design Parking System - LeetCode](https://leetcode.com/problems/design-parking-system/editorial/?envType=study-plan-v2&id=programming-skills)  , Median of two sorted arrays, [(3) The Latest Time to Catch a Bus - LeetCode](https://leetcode.com/problems/the-latest-time-to-catch-a-bus/)

c) Binary Search Questions- [Binary Search Interview Questions - Google, Facebook, Amazon - YouTube](https://www.youtube.com/watch?v=W9QJ8HaRvJQ)
This is a nice template
https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems

d) [Google Spring' 23 High Frequency - Study Plan - LeetCode](https://leetcode.com/studyplan/google-spring-23-high-frequency/)

e) You can practice - https://leetcode.com/discuss/interview-question/3378926/System-Design-or-Uber-or-SSE
https://leetcode.com/discuss/interview-question/2099405/Uber-SSE-Phone-Screen-NY


