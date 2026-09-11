# STEP Semester 3 - Week 4: Arrays, Functions & Logic-Building (Category C)

This repository contains all solutions for **Week 4** including the 5 **Category C** logic-building problems and the 6 core **Array Fundamentals** learning modules.

---

## 🚀 Folder Structure

```
week4/
├ category_c/
   ┕ TwoSum.java                                      #L1: Two Sum
   ┐ BestTimeToBuyAndSellStock.java                     #L2: Best Time to Buy and Sell Stock
   ┐ ContainsDuplicate.java                            #L3: Contains Duplicate
   ┐ MergeTwoSortedArrays.java                           #L4: Merge Two Sorted Arrays
   ┝ RotateArray.java                                   #L5: Rotate Array

┝ array_fundamentals/
   ┝ ArrayFundamentalsPractice.java                       #6 Array Topics (Creation, Init, Loops, Ref)
```

---

## 🚀 Category C Problems Overview & Signatures

### 1. Two Sum (L1)
- **Method**: `int[] twoSum(int[] nums, int target)`
- **Concepts**: Nested for loops, pairwise checks, array indexing.

### 2. Best Time to Buy and Sell Stock (L2)
- **Method**: `int maxProfit(int[] prices)`
- **Concepts**: One-pass traversal, tracking running minimum buy price, maximizing profit.

### 3. Contains Duplicate (L3)
- **Method**: `boolean containsDuplicate(int[] nums)`
- **Concepts**: Nested loops, early exit on first duplicate found.

### 4. Merge Two Sorted Arrays (L4)
- **Method**: `int[] mergeSortedArrays(int[] arr1, int[] arr2)`
- **Concepts**: Two-pointer traversal, comparison and copying without re-sorting.

### 5. Rotate Array (L5)
- **Method**: `int[] rotateArray(int[] nums, int k)`
- **Concepts**: Modulo wraparound `((i + k) % n)`, in-place reconstruction.

---

## 🚀 Array Fundamentals (6 Core Topics)

1. **Creating an Array**: Default zero/null initialization.
2. **Initializing an Array**: Literals vs. index-based population.
3. **Accessing an Array**: 0-based indexing.
4. **Accessing Using a for Loop**: Standard index for vs. Enhanced for-each.
5. **Modifying an Array**: Pass-by-reference behavior when passed to methods.
6. **The length Property**: Determining size and boundaries.

---

## ⛞️ Compilation & Execution

```bash
# Compile solutions
javac sem3/week4/category_c/*.java
javac sem3/week4/array_fundamentals/*.java

# Run Category C solutions
java -cp sem3/week4/category_c TwoSum
java -cp sem3/week4/category_c BestTimeToBuyAndSellStock
java -cp sem3/week4/category_c ContainsDuplicate
java -cp sem3/week4/category_c MergeTwoSortedArrays
java -cp sem3/week4/category_c RotateArray

# Run Array Fundamentals practice
java -cp sem3/week4/array_fundamentals ArrayFundamentalsPractice
```
