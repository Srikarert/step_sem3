# Week 7 Assignment — Category C Practice Problems

> **STEP SEM-3 · Week 7 Assignment · CodInClub | Powered by BridgeLabz**  
> **Topic:** Encapsulation & Access Control  
> **Author:** Akula Srikar — STEP SEM-3

---

## 📑 Problem Index

| # | Problem | Primary Class | Key OOP / Encapsulation Concepts |
|---|---|---|---|
| **Problem 1** | [The Health Bar](file:///d:/SRM/STEP/sem3-/sem3/week7/category_c/Character.java) | `Character.java` / `HealthBar.java` | Data hiding, `private` state, clamped boundaries, `final` maximum limit, read-only getter |
| **Problem 2** | [The Playlist](file:///d:/SRM/STEP/sem3-/sem3/week7/category_c/Playlist.java) | `Playlist.java` | Defensive copying of internal arrays (`Arrays.copyOf`), read-only counts, reference isolation |
| **Problem 3** | [The Password Checker](file:///d:/SRM/STEP/sem3-/sem3/week7/category_c/PasswordChecker.java) | `PasswordChecker.java` | Write-only / secret state, `final` immutability, zero-leak getter policy, derived strength calculation |
| **Problem 4** | [The Traffic Light](file:///d:/SRM/STEP/sem3-/sem3/week7/category_c/TrafficLight.java) | `TrafficLight.java` | Enforced state transitions (`next()`), no arbitrary setters, immutable identity (`final id`) |
| **Problem 5** | [The Shopping Cart](file:///d:/SRM/STEP/sem3-/sem3/week7/category_c/Cart.java) | `Cart.java` / `ShoppingCart.java` | Internal array shielding, on-demand computation (dynamic recalculation vs stored redundancy), immutable cart ID |

---

## 💡 Problem Details & Solutions

### Problem 1: The Health Bar
- **Scenario:** A game character has health that changes dynamically during battle.
- **Design Goals:**
  - Health must be private and changed strictly through `takeDamage(int amount)` and `heal(int amount)`.
  - Health is clamped between `0` and `maxHealth`. Extra damage is wasted (floored at 0); extra healing is wasted (capped at `maxHealth`).
  - `maxHealth` is `final` and established during object creation.
  - Read-only `getHealth()` method provides access with no external setter.
- **Sample Run:**
  ```text
  Character c = new Character(100);
  c.takeDamage(30)  -> health = 70
  c.heal(50)        -> health = 100 (capped)
  c.takeDamage(150) -> health = 0 (floored)
  ```

---

### Problem 2: The Playlist
- **Scenario:** A music app manages a playlist of songs.
- **Design Goals:**
  - Store song titles in a private array of fixed maximum size.
  - Provide `addSong(String song)` to append songs and `getSongCount()` for the current count.
  - `getSongs()` returns a defensive copy (`Arrays.copyOf(songs, songCount)`) so external mutation cannot corrupt internal playlist state.
- **Sample Run:**
  ```text
  Playlist p = new Playlist(10);
  p.addSong("Song A");
  p.addSong("Song B");
  String[] copy = p.getSongs();
  copy[0] = "Hacked"; // p.getSongs()[0] remains "Song A"
  ```

---

### Problem 3: The Password Checker
- **Scenario:** A signup form verifies password strength without compromising credentials.
- **Design Goals:**
  - Password is accepted in the constructor and stored privately in a `final` field.
  - No getter exists anywhere that exposes the password text.
  - `getStrength()` determines the rating based on length:
    - `"Weak"`: Under 6 characters
    - `"Medium"`: 6–9 characters
    - `"Strong"`: 10+ characters
- **Sample Run:**
  ```text
  PasswordChecker pc1 = new PasswordChecker("abcd");
  pc1.getStrength() -> "Weak"
  PasswordChecker pc2 = new PasswordChecker("abcdefghij");
  pc2.getStrength() -> "Strong"
  ```

---

### Problem 4: The Traffic Light
- **Scenario:** A traffic light cycles predictably through its signal states.
- **Design Goals:**
  - Current color is private, initialized to `"RED"`.
  - The cycle moves strictly forward: `RED -> GREEN -> YELLOW -> RED`.
  - State advances exclusively via `next()`. No direct `setColor(...)` exists.
  - Light ID is `final` and accessible via read-only `getId()`.
- **Sample Run:**
  ```text
  TrafficLight t = new TrafficLight("TL-9");
  t.getColor() -> "RED"
  t.next()     -> "GREEN"
  t.next()     -> "YELLOW"
  t.next()     -> "RED"
  ```

---

### Problem 5: The Shopping Cart
- **Scenario:** An e-commerce cart accumulates prices of items to purchase.
- **Design Goals:**
  - Prices stored in a private internal array of fixed size.
  - `addItem(double price)` adds prices to the cart.
  - `getTotal()` calculates total sum on-demand (iterating over added items each call).
  - `getItemCount()` provides current item count.
  - No method exposes the internal price array directly.
  - Cart ID is immutable and marked `final`.
- **Sample Run:**
  ```text
  Cart cart = new Cart("CART-5", 20);
  cart.addItem(250);
  cart.addItem(99);
  cart.addItem(151);
  cart.getTotal()     -> 500
  cart.getItemCount() -> 3
  ```

---

## 🚀 How to Compile & Run

```bash
# Compile all category_c problem classes:
javac -d . sem3/week7/category_c/*.java

# Run individual problem demonstrations:
java Character       # or java HealthBar
java Playlist
java PasswordChecker
java TrafficLight
java Cart            # or java ShoppingCart
```
