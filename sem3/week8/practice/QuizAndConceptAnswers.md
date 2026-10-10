# Week 8 Practice: Quiz and Concept Answers

## Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | C | Polymorphism: call `render()` on a `Document` reference and let each subclass decide, instead of if-else on type. |
| 2 | A, B, C | These are genuine "is-a" relationships. D is "has-a" (composition). |
| 3 | C | Runtime method dispatch picks the override based on the actual object type. |
| 4 | C | Inheritance-based (runtime) polymorphism. |
| 5 | A, C, D | `Book` extends inherited behavior, `LibraryItem` defines the common contract, and a `DVD` can be used through a `LibraryItem` reference. B is wrong: DVD's fixed period is overridden behavior, not shared behavior. |
| 6 | A, C | The `Animal` reference runs `Dog`'s override. B is wrong (the base method is generic) and D is wrong (derived classes can add their own new methods). |
| 7 | C | A new `WalletPayment` plugs in without touching the processor's loop. |
| 8 | A | Inheritance without a real "is-a" gives tight coupling and a rigid, misleading hierarchy. |
| 9 | A, C | The sender is generic, and new channels can be added without changing it. |
| 10 | A, B, C | D is the opposite of the real benefit. |

## Concept questions

**1. Reuse and extend.** A subclass inherits fields and methods from its base class and can add new ones or override existing ones. Example: `Account` has `deposit()` and `getBalance()`. `SavingsAccount` reuses both and overrides `withdraw()` to enforce a minimum balance, and adds `addInterest()`.

**2. "Is-a".** `B is-a A` means every B can be used wherever an A is expected without surprising behavior (Liskov substitution). Getting it right matters because inheritance couples the subclass to the base class's whole contract. A false "is-a" leaks irrelevant or invalid behavior into the subclass and makes the design brittle.

**3. Method overriding.** A subclass provides its own implementation of a method with the same signature as the base class. Example: `Employee.calculateSalary()` is overridden by `FullTimeEmployee` (monthly salary), `PartTimeEmployee` (hours × rate) and `Contractor` (fixed contract amount). Callers invoke `calculateSalary()` and each type applies its own rule.

**4. Runtime polymorphism.** When a method is called on a base-type reference, the JVM looks at the actual object's class at runtime (via the virtual method table) and runs that class's override. The reference type decides which methods are callable, and the object type decides which implementation runs.

**5. Polymorphic collections.** Example: `List<Payment> list = List.of(new CardPayment(..), new WalletPayment(..), new BankTransferPayment(..));`. One loop calls `p.finalAmount()` on each element. The advantages are uniform processing, no type checks or casts, and new types that can be added without changing the loop.

**6. Polymorphism vs if-else/switch.** A conditional chain puts all type knowledge in one place that must be edited for every new type, and it is easy to miss a branch. Polymorphism moves each rule into its own class, so new types are added without modifying existing code (open/closed principle), the code is easier to test, and there is no central chain to grow.

**7. Adding new types.** The processing logic depends only on the `PaymentMethod` base type. To add `CryptoPayment`, write one new subclass that overrides `finalAmount()`. The loop `for (PaymentMethod p : list) p.finalAmount();` stays unchanged.

**8. Inherited vs overridden.** Inherited behavior is used as-is from the base class (for example `Vehicle.getRegistrationNumber()` is the same for all vehicles). Overridden behavior is replaced because the subclass needs a different rule (for example `Truck.calculateToll()` differs from `Car.calculateToll()`). Inherit when the logic is common, and override when it varies by type.

**9. Inheritance only for reuse.** Without a genuine "is-a", subclasses inherit methods that make no sense for them (for example `Stack extends ArrayList` exposes `add(index, x)`), which breaks encapsulation. The result is tight coupling, a fragile base class, confusing hierarchies, and substitutability bugs. Composition (has-a) or utility classes are better.

**10. VehicleRental.** Common behavior and data in `Rental` are the customer, the vehicle id, the days rented, `getDays()` and `printSummary()`. Specialized behavior is `CarRental.cost()` (daily rate plus insurance) and `TruckRental.cost()` (daily rate plus per-km and load charges). `Rental` declares `abstract double cost()`, the subclasses override it, and a `List<Rental>` is processed uniformly.
