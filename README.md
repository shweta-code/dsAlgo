# DS - Algo

**Concepts**

1. Heaps are complete Binary Tree.
2. Tree Map/ Red Black Trees in JAVA - [Internal Working of TreeMap in Java - GeeksforGeeks](https://www.geeksforgeeks.org/internal-working-of-treemap-in-java/)
3. Graphs - Kahns, Topolgical Sort, Union Find, Cycle Detection, Disjoint Set ([(3) Explore - LeetCode](https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3840/))
4. Quick Union is when you track of roots of each node. Quick Union is when you keep track of parent of each node not roots.
5. Kahn's algorithm, Union Find can be used to detect cycle in graph.
6. The bucket your key is placed in is a function of its `hashCode` modulus the size of the array used to hold the HashMap (which is the number of buckets), so re-hashing can move a key to a different bucket.
7. [2-choice hashing - Wikipedia](https://en.wikipedia.org/wiki/2-choice_hashing)
8.

* **1). hash function design**: the purpose of hash function is to map a key value to an address in the storage space, similarly to the system that we assign a postcode to each mail address.
  As one can image, for a good hash function, it should map different keys ***evenly*** across the storage space, so that we don't end up with the case that the majority of the keys are *concentrated* in a few spaces.
* **2). collision handling**: essentially the hash function reduces the vast key space into a limited address space. As a result, there could be the case where two different keys are mapped to the same address, which is what we call *'collision'*.
  Since the collision is inevitable, it is important that we have a strategy to handle the collision.
*
*
* Revise -
* Hashing solution in - [(3) Subtree of Another Tree - LeetCode
* ](https://leetcode.com/problems/subtree-of-another-tree/solution/)

**Designs**

1. Solution/Editorial is nice -[(3) Design Underground System - LeetCode](https://leetcode.com/problems/design-underground-system/solution/)
2.

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

b)  Have to do Combinatorics, Divide and Conquer, BST question too, Binary Search Algo, Water Rain Trapping, Montone Increasing Q, [Word Ladder - LeetCode](https://leetcode.com/problems/word-ladder/), Heap, [Subtree of Another Tree - LeetCode,](https://leetcode.com/problems/subtree-of-another-tree/).Design Problems in Editorail/Solution section of [Design Parking System - LeetCode](https://leetcode.com/problems/design-parking-system/editorial/?envType=study-plan-v2&id=programming-skills)  , Median of two sorted arrays, [(3) The Latest Time to Catch a Bus - LeetCode](https://leetcode.com/problems/the-latest-time-to-catch-a-bus/), [(3) Scramble String - LeetCode](https://leetcode.com/problems/scramble-string/#:~:text=Scramble%20String%20-%20LeetCode.%20We%20can%20scramble%20a,and%20y%20where%20s%20%3D%20x%20%2B%20y.), [(3) Burst Balloons - LeetCode](https://leetcode.com/problems/burst-balloons/)

c) Binary Search Questions- [Binary Search Interview Questions - Google, Facebook, Amazon - YouTube](https://www.youtube.com/watch?v=W9QJ8HaRvJQ)

d) [Google Spring' 23 High Frequency - Study Plan - LeetCode](https://leetcode.com/studyplan/google-spring-23-high-frequency/)

**How to go about preparation of DSA?**

1) Reading questions/answers -> 3 LRU cache, Trie
2) Thinking -> 2
3) Writing -> 1
4) Revision -> Previous topics
