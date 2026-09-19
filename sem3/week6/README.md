# Week 6 — Access Modifiers, Encapsulation & Object Modeling

> **STEP SEM-3 · Week 6 · CodInClub | Powered by BridgeLabz**  
> **Author:** Akula Srikar — STEP SEM-3

---

## 📑 Table of Contents
1. [Topic Overview](#-topic-overview)
2. [Section 1: Access Modifiers (`private`, `default`, `protected`, `public`)](#-section-1-access-modifiers)
3. [Section 2: Visibility Rules Across Packages and Inheritance](#-section-2-visibility-rules-across-packages-and-inheritance)
4. [Section 3: Encapsulation — Data Hiding](#-section-3-encapsulation--data-hiding)
5. [Section 4: The JavaBean Standard — Getters and Setters](#-section-4-the-javabean-standard)
6. [Section 5: Read-Only and Write-Only Properties](#-section-5-read-only-and-write-only-properties)
7. [Section 6: Immutable Objects](#-section-6-immutable-objects)
8. [Section 7: final Fields and Encapsulation (Defensive Copying)](#-section-7-final-fields-and-encapsulation)
9. [Wrap-Up: Object Modeling — Putting It All Together](#-wrap-up-object-modeling--putting-it-all-together)
10. [Cheat Sheet](#-cheat-sheet)
11. [Self-Assessment: Test Yourself Solutions](#-self-assessment-test-yourself-solutions)
12. [How to Compile & Run](#-how-to-compile--run)

---

## 🎯 Topic Overview

| # | Topic | The Question It Answers |
|---|-------|-------------------------|
| 1 | **Access Modifiers** — `private`, `default`, `protected`, `public` | Who is actually allowed to see or touch this field or method? |
| 2 | **Visibility Across Packages and Inheritance** | Does being a subclass, or being in the same package, change what I can reach? |
| 3 | **Encapsulation — Data Hiding** | Why hide fields behind methods instead of just leaving them public? |
| 4 | **The JavaBean Standard — Getters & Setters** | What naming convention makes my class instantly recognisable to tools and frameworks? |
| 5 | **Read-Only and Write-Only Properties** | What if a value should be seen but never changed — or changed but never read back? |
| 6 | **Immutable Objects** | What happens if I remove every setter and never let a field change again? |
| 7 | **final Fields and Encapsulation** | How do `final` and `private` work together to build objects that truly protect themselves? |

---

## 🛡 Section 1: Access Modifiers

Java provides **four** access levels, not two. Choosing the narrowest possible modifier is a deliberate API design choice:

| Modifier | Keyword | Accessible From |
|---|---|---|
| **private** | `private` | Only code inside the exact same class. |
| **default** (package-private) | *(no keyword)* | Any class in the exact same package — nothing else. |
| **protected** | `protected` | Same package, plus any subclass, even in a different package. |
| **public** | `public` | Anywhere at all, with no restriction. |

### Code Implementation (`srm.fees.FeeAccount`):
```java
package srm.fees;

public class FeeAccount {
    private String regNo;        // Only FeeAccount itself can touch this
    double totalFee;             // default (package-private): only classes inside srm.fees
    protected double amountPaid; // srm.fees, plus any subclass anywhere
    public String accountType;   // any class, in any package
}
```

---

## 🌐 Section 2: Visibility Rules Across Packages and Inheritance

### The Full Visibility Matrix

| Modifier | Same Class | Same Package | Subclass (Different Package) | Unrelated Class (Different Package) |
|---|:---:|:---:|:---:|:---:|
| `private` | **Yes** | No | No | No |
| `default` | **Yes** | **Yes** | No | No |
| `protected`| **Yes** | **Yes** | **Yes** (via inheritance) | No |
| `public` | **Yes** | **Yes** | **Yes** | **Yes** |

### Key Takeaways:
- `protected` members can be accessed in another package **only through the `extends` inheritance relationship**, not on an arbitrary instance created by an unrelated class.
- Package boundaries in Java are logical, defined by the `package` declaration, not just the directory path.

---

## 🔒 Section 3: Encapsulation — Data Hiding

Encapsulation keeps fields private and exposes validated, controlled operations through public methods.

- **Without Encapsulation:** Any caller can directly assign negative amounts (`acc.amountPaid = -50000;`), corrupting object state.
- **With Encapsulation:** There is exactly one entrance:
```java
public void pay(double amount) {
    if (amount <= 0) {
        System.out.println("Payment rejected: must be positive");
        return;
    }
    this.amountPaid += amount;
}
```

---

## ☕ Section 4: The JavaBean Standard

The JavaBean convention standardizes method names so reflection-based frameworks (e.g., Spring, Jackson, Hibernate) can automatically bind and serialize properties:

| Field | Getter | Setter | Notes |
|---|---|---|---|
| `private String name;` | `public String getName()` | `public void setName(String name)` | Standard prefix `get` / `set` |
| `private int age;` | `public int getAge()` | `public void setAge(int age)` | Numeric / Object properties |
| `private boolean active;` | `public boolean isActive()` | `public void setActive(boolean active)` | **Crucial:** `isX()`, NOT `getX()` |

> **Requirement:** A full JavaBean also requires a **public no-argument constructor** so frameworks can instantiate empty objects prior to injecting properties.

---

## 📖 Section 5: Read-Only and Write-Only Properties

Properties do not always need both a getter and a setter:

1. **Read-Only Property (`getter`, no `setter`):**
   - E.g., `regNo` in `SrmStudent`: Immutable identity set in constructor. Callers can inspect it, but can never alter it.
2. **Write-Only Property (`setter`, no `getter`):**
   - E.g., `passwordHash` in `PortalAccount`: Accepts a plaintext password, hashes it, but deliberately exposes **no `getPassword()`**. Provides verification via `verifyPassword(plain)`.

---

## 🧊 Section 6: Immutable Objects

An object whose state can never change after construction:
- Mark the class `final` (prevents subclasses from adding mutable state).
- Mark all fields `private final`.
- Provide **no setters**.
- To "change" state, implement **Wither methods** (e.g., `withCourse(newCourse)`) that construct and return a **brand-new object**, leaving the original instance untouched.

---

## 🛡 Section 7: final Fields and Encapsulation (Defensive Copying)

### The Reference Gap
Declaring a field `final` locks the **reference**, not the **contents** of mutable objects (such as `int[]` arrays or `List` collections).

### The Solution: Defensive Copying
```java
public class CourseRoster {
    private final String courseCode;
    private final int[] scores;

    // Defensive Copy IN
    public CourseRoster(String courseCode, int[] scores) {
        this.courseCode = courseCode;
        this.scores = (scores != null) ? scores.clone() : new int[0];
    }

    // Defensive Copy OUT
    public int[] getScores() {
        return scores.clone();
    }
}
```

---

## 🏗 Wrap-Up: Object Modeling — Putting It All Together

In `SrmStudentProfile`, four deliberate design decisions work in unison:
```java
public final class SrmStudentProfile {
    private final String regNo;    // Identity: final, read-only
    private final String name;     // Identity: final, read-only
    private double attendance;     // State: private, read-write with validation (0-100%)
    
    // ...
}
```

---

## 📌 Cheat Sheet

| Topic | Remember This |
|---|---|
| **Access Modifiers** | `private`: this class only. `default`: this package only. `protected`: package + subclasses anywhere. `public`: everyone. |
| **Visibility Across Packages** | `protected` reaches a subclass in another package only through inheritance, never sideways to unrelated classes. |
| **Encapsulation** | Private fields, public methods enforcing invariants. One door in, one door out. |
| **JavaBean Standard** | `getX()` / `setX()` for normal fields, `isX()` for booleans, plus a public no-arg constructor. |
| **Read-Only / Write-Only** | Getter with no setter = read-only. Setter with no getter = write-only. |
| **Immutable Objects** | Every field `final`, class `final`, no setters. State changes produce a new instance. |
| **final Fields** | Locks the reference, not mutable contents. Defensive copying (`.clone()`) closes the gap. |

---

## 📝 Self-Assessment: Test Yourself Solutions

### Q1. What is the one situation where `protected` actually reaches code in a different package — and why does it not reach every class in that package?
**Answer:**  
`protected` only reaches code in a different package when the accessing class is a **direct or indirect subclass** of the declaring class (via `extends`), accessed through inheritance. It does not reach every class in that external package because `protected` is designed to support the **open-closed principle and inheritance**, not to expose internals to unrelated third-party classes.

### Q2. Give a concrete example of a bug that public fields alone would allow, which encapsulation prevents.
**Answer:**  
In a `FeeAccount` class with `public double amountPaid;`, any outside caller can execute `acc.amountPaid = -50000;` or `acc.totalFee = Double.NaN;`. With encapsulation, `amountPaid` is `private`, and the only modification path is `public void pay(double amount)` which explicitly checks `if (amount <= 0)` and rejects corrupted values.

### Q3. Why does a boolean JavaBean property use `isX()` instead of `getX()`?
**Answer:**  
It reads naturally as an English predicate question (e.g., `student.isScholarshipHolder()`) and follows the official JavaBeans specification (JSR-924). Standard JSON mappers (Jackson, Gson) and EL (Expression Language) in frameworks look specifically for the `is` prefix for boolean getters to bind JSON booleans.

### Q4. Describe a real field that should be a read-only property, and a real field that should be write-only.
**Answer:**  
- **Read-Only Property:** A student's University Registration Number (`regNo`) or an employee's PAN/SSN. Set once during account creation and retrievable anywhere, but never allowed to mutate via a setter.
- **Write-Only Property:** A user's plaintext password (`passwordHash`). A caller can submit a new password via `setPassword(String raw)`, but should never have a `getPassword()` method that exposes credentials.

### Q5. What does it mean to "change" an immutable object, if none of its fields can actually be reassigned?
**Answer:**  
You do not change the object itself. Instead, you create and return a **new instance** with the updated values, while leaving the original instance completely unmodified in memory. (This is identical to how `String.replace()` or `String.toUpperCase()` operates).

### Q6. A class has a `private final int[]` field with no defensive copying. Describe exactly how an outside caller could still mutate it.
**Answer:**  
1. **Via the Constructor:** If the caller retains a reference to the array passed into the constructor (`int[] myScores = {90, 80}; new CourseRoster("CSE", myScores);`), the caller can later modify `myScores[0] = 0;`, modifying the internal array.
2. **Via the Getter:** If `getScores()` returns the internal array directly, a caller can write `roster.getScores()[0] = 0;`, directly modifying the class's internal state.

### Q7. Why is a public no-argument constructor part of the JavaBean standard, even for a class whose fields are all mandatory in spirit?
**Answer:**  
Frameworks and serialization libraries (like Spring Beans, Hibernate, and Jackson) instantiate classes dynamically using reflection (`Class.getDeclaredConstructor().newInstance()`) before populating properties via setters or field reflection. Without a no-arg constructor, automated instantiation fails.

### Q8. In the `SrmStudentProfile` example, why are `regNo` and `name` final while `attendance` is not — what's the underlying design reason?
**Answer:**  
`regNo` and `name` constitute the **immutable identity** of the student — a student's legal identity does not fluctuate during daily academic operations. In contrast, `attendance` is **mutable operational state** that changes after each lecture. Modeling immutable identity with `final` guarantees stability, while keeping state mutable with validation ensures flexible tracking.

---

## 🚀 How to Compile & Run

### 1. Compile All Files:
```bash
javac -d . srm/fees/*.java srm/hostel/*.java srm/student/*.java Week6Demo.java
```

### 2. Run the Master Demonstration:
```bash
java Week6Demo
```

### 3. Run Individual Subsystem Demos:
```bash
# Section 1 & 3 demo:
java srm.fees.FeeOfficeDemo

# Section 2 cross-package demo:
java srm.hostel.HostelOfficeDemo
```
