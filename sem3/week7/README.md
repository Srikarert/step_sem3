# STEP SEM-3 — Week 7: Encapsulation & Access Control

> **STEP SEM-3 · CodInClub | Powered by BridgeLabz**  
> **Topic:** Encapsulation & Access Control (Category C Assignment Problems)  
> **Author:** Akula Srikar — STEP SEM-3

---

## 📌 Overview

Week 7 covers the core pillars of Object-Oriented Programming (OOP) in Java focusing on:
1. **Data Hiding & Private Fields:** Restricting unauthorized access to object state.
2. **Controlled Access via Methods:** Enforcing class invariants and business validation rules.
3. **Read-Only & Write-Only Properties:** Providing one-way exposure without violating safety.
4. **Immutable State via `final`:** Preventing post-construction modification of critical identifiers.
5. **Defensive Copying:** Shielding internal collections and arrays from external reference mutation.
6. **On-Demand Computation:** Computing derived values fresh to eliminate state desynchronization.

---

## 📂 Project Structure

```
sem3/
└── week7/
    ├── README.md                          # Week 7 root documentation
    ├── Week7Demo.java                     # Master unified demonstration driver
    └── category_c/                        # Category C Assignment Problems
        ├── Character.java                 # Problem 1: The Health Bar
        ├── HealthBar.java                 # Problem 1: Alias / Driver
        ├── Playlist.java                  # Problem 2: The Playlist
        ├── PasswordChecker.java           # Problem 3: The Password Checker
        ├── TrafficLight.java              # Problem 4: The Traffic Light
        ├── Cart.java                      # Problem 5: The Shopping Cart
        ├── ShoppingCart.java              # Problem 5: Alias / Driver
        └── README.md                      # Detailed problem descriptions & test outputs
```

---

## 🛠️ Compilation & Execution Instructions

### Compile All Files:
```powershell
javac -d . sem3/week7/category_c/*.java sem3/week7/Week7Demo.java
```

### Run Master Demonstration:
```powershell
java Week7Demo
```

### Run Individual Problems:
```powershell
java Character
java Playlist
java PasswordChecker
java TrafficLight
java Cart
```
