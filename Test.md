1. Reverse Words in a String
Problem: Given a string, reverse the order of the words in the string without reversing the individual words.

Example:

Input: "The quick brown fox"
Output: "fox brown quick The"
Requirements:

Do not use any built-in library methods to reverse the string or words.
Solve in O(n) time complexity.

2. Find the Missing Number
Problem: Given an array of integers from 1 to n where one number is missing, find the missing number.

Example:

Input: [3, 7, 1, 2, 8, 4, 5]
Output: 6
Requirements:

Do it in O(n) time complexity and O(1) extra space (i.e., without using additional data structures).

3. Longest Substring Without Repeating Characters
Problem: Given a string, find the length of the longest substring without repeating characters.

Example:

Input: "abcabcbb"
Output: 3 (substring "abc")
Requirements:

Solve it in O(n) time complexity.

4. Merge Intervals
Problem: Given a collection of intervals, merge any overlapping intervals.

Example:

Input: [[1, 3], [2, 4], [5, 7]]
Output: [[1, 4], [5, 7]]
Requirements:

Implement this function with an efficient sorting and merging algorithm.

5. Binary Search on a Rotated Sorted Array
Problem: Given a rotated sorted array and a target value, find the index of the target element using binary search.

Example:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Requirements:

Solve in O(log n) time complexity.
6. Group Anagrams
Problem: Given an array of strings, group the anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
Requirements:

Try to optimize the solution using hashing (using a hash map or a similar data structure).
7. Top K Frequent Elements
Problem: Given a non-empty array of integers, return the k most frequent elements.

Example:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1, 2]
Requirements:

Implement this in O(n log k) time complexity.
8. Find All Duplicates in an Array
Problem: Given an array of integers, where each element is between 1 and n (inclusive), find all the elements that appear more than once in the array.

Example:

Input: [4,3,2,7,8,2,3,1]
Output: [2, 3]
Requirements:

Solve the problem in O(n) time complexity with O(1) extra space.
9. Path Sum in Binary Tree
Problem: Given a binary tree and a sum, return true if there is a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example:

Input: Tree with values [5,4,8,11,null,13,4,7,2,null,null,null,1] and sum = 22
Output: true (because 5 -> 4 -> 11 -> 2 equals 22)
Requirements:

Implement this with recursion or DFS traversal.
10. Linked List Cycle Detection
Problem: Given a linked list, determine if it has a cycle in it.

Example:

Input: head = [3, 2, 0, -4], pos = 1
Output: true
Requirements:

Use Floyd's Cycle Detection algorithm (Tortoise and Hare), which runs in O(n) time and O(1) space.
11. Rotate an Array
Problem: Given an array of integers, rotate the array to the right by k steps.

Example:

Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
Output: [5, 6, 7, 1, 2, 3, 4]
Requirements:

Do this in O(n) time and O(1) space.
12. Dynamic Programming - Coin Change
Problem: Given a set of coin denominations and a target amount, find the fewest number of coins that you need to make up that amount.

Example:

Input: coins = [1, 2, 5], amount = 11
Output: 3 (because 5 + 5 + 1 = 11)
Requirements:

Use dynamic programming to solve this in O(n * m) time complexity, where n is the target amount and m is the number of coin denominations.