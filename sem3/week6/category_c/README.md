# Week 6 Assignment — Category C Practice Problems

> **STEP SEM-3 · Week 6 Assignment · CodInClub \| Powered by BridgeLabz**  
> **Author:** Akula Srikar — STEP SEM-3

---

## 📑 Problem Index

| # | Problem | Source File | Key OOP Concepts |
|---|---|---|---|
| **M1** | [Student Placement Record Management](file:///d:/SRM/SEM-3/APP/tutorial/category_c/StudentPlacementRecordManagement.java) | `StudentPlacementRecordManagement.java` | Classes & Objects, Instance Methods, Arrays of Objects |
| **M2** | [Hostel Mess Wallet Management](file:///d:/SRM/SEM-3/APP/tutorial/category_c/HostelMessWalletManagement.java) | `HostelMessWalletManagement.java` | Encapsulation, Private Data Hiding, Validated Operations, Read-Only Property |
| **M3** | [Course Credit Management](file:///d:/SRM/SEM-3/APP/tutorial/category_c/CourseCreditManagement.java) | `CourseCreditManagement.java` | Constructor Overloading, Constructor Chaining via `this(...)` |
| **M4** | [Library ID Card Management](file:///d:/SRM/SEM-3/APP/tutorial/category_c/LibraryIdCardManagement.java) | `LibraryIdCardManagement.java` | Object References, Reference Aliasing, Reference Comparison using `==` |
| **M5** | [Student and College Information Management](file:///d:/SRM/SEM-3/APP/tutorial/category_c/StudentAndCollegeInformationManagement.java) | `StudentAndCollegeInformationManagement.java` | Static Fields, Static Methods, Class-Level Shared State vs Instance State |

---

## 💡 Problem Details & Solutions

### M1. Student Placement Record Management
- **Goal:** Replace 3 desynchronized parallel arrays with an OOP `PlacementRecord` class and an array of objects.
- **Output:**
  ```text
  Ravi -> TCS @ 4.5 LPA
  Anitha -> Zoho @ 6.2 LPA
  Karthik -> Infosys @ 4.0 LPA
  ```

### M2. Hostel Mess Wallet Management
- **Goal:** Protect wallet balance from negative values and direct external overwrites using encapsulation.
- **Output:**
  ```text
  Balance after top-up: 700.0
  Deduct rejected: insufficient balance
  Final balance: 700.0
  ```

### M3. Course Credit Management
- **Goal:** Support both theory-only courses and theory+lab courses without duplicate initialization logic using `this(...)` constructor chaining.
- **Output:**
  ```text
  21CSC201J total credits: 4
  21CSC205L total credits: 4
  ```

### M4. Library ID Card Management
- **Goal:** Prove how reference variables point to objects in the heap and demonstrate that `==` checks memory addresses rather than field values.
- **Output:**
  ```text
  Ravi's booksIssued (via first variable): 3
  duplicate == ravi: true
  separate == ravi: false
  ```

### M5. Student and College Information Management
- **Goal:** Prevent redundant object-level memory duplication of the college name and maintain a centralized student count using `static` members.
- **Output:**
  ```text
  SRM Institute of Science and Technology
  Students created: 2
  ```

---

## 🚀 How to Compile & Run

```bash
# Compile all 5 assignment solutions:
javac -d . category_c/*.java

# Run individually:
java StudentPlacementRecordManagement
java HostelMessWalletManagement
java CourseCreditManagement
java LibraryIdCardManagement
java StudentAndCollegeInformationManagement
```
