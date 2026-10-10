# Week 9 Practice: Quiz and Concept Answers

## Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | C | Abstraction hides how things are done and exposes only what is done. |
| 2 | C | An abstract class cannot be instantiated directly (A is wrong: it need not have abstract methods; D is wrong: single inheritance only). |
| 3 | B | The subclass must implement every inherited abstract method or itself be declared abstract. |
| 4 | C | `private` is not allowed because subclasses could never override such a method. |
| 5 | C | Interface fields are implicitly `public static final`. |
| 6 | C | A class can implement any number of interfaces. |
| 7 | D | Interface methods are implicitly public, and an override cannot reduce visibility. |
| 8 | C | Interfaces carry no instance state, so multiple implementation avoids the diamond problem with conflicting data. |
| 9 | D | Conflicting default methods give a compile-time error until the class overrides the method. |
| 10 | B | Abstract classes can have constructors, which run via `super(...)` when a subclass object is created. |

## Concept questions

**1. Abstraction.** Abstraction means exposing what an object does while hiding how it does it. Example: an ATM. The user sees "withdraw cash", "check balance" and "deposit". Hidden are bank-server communication, authentication protocols, cash-dispenser mechanics and transaction logging. The user can use the machine without understanding any of that, and the internals can change without changing how it is used.

**2. Abstraction vs encapsulation.** Abstraction is about design: deciding which operations are visible and hiding complexity. Encapsulation is about protection: bundling data with its methods and restricting direct access (private fields). In one class they work together. For example, `BankAccount` abstracts to `deposit()` and `withdraw()`, and encapsulates a private `balance` that can only change through validated methods. Abstraction keeps the interface simple, and encapsulation keeps the data safe.

**3. Abstract class constructors.** An abstract class often holds common state (such as `name` or `units`) that must be initialized. Its constructor does that so each subclass doesn't repeat the code. It runs when a subclass object is created, as the first step of the subclass constructor via `super(...)`, even though the abstract class itself is never instantiated directly.

**4. Why abstract methods can't be private, static or final.**
- **private:** A private method is invisible to subclasses, so they could never override it, which defeats the purpose of an abstract method.
- **static:** Static methods belong to the class and are not overridden (only hidden), so there is no polymorphic dispatch and no way to force a subclass implementation.
- **final:** `final` forbids overriding, while abstract requires overriding, so the two are contradictory.

**5. Diamond problem.** It occurs when a class inherits from two parents that both inherit from the same grandparent, and the child cannot tell which parent's inherited state or implementation to use (for example, two conflicting copies of a field or method). Java avoids it by allowing only one superclass, so there is only one chain of state and implementation. Multiple interfaces are allowed because interfaces carry no instance state. If two default methods conflict, the compiler forces the class to override the method and choose explicitly (for example, `A.super.hello()`).
