# Assignment #5 — Strategy Pattern

**Course:** Software Design Patterns  
**Topic:** Strategy Behavioral Pattern  
**Package:** `com.fintech.strategy`

---

## Overview

This project implements the **Strategy pattern** for calculating loan repayment schedules in a banking system. 
Instead of hardcoding interest formulas and using `if-else` or `switch` statements inside the calculator, the calculation logic is separated into interchangeable strategy classes. The client can switch repayment algorithms at runtime.

### Architecture Components

1. **Strategy Interface (`RepaymentStrategy`):**
   - Declares the common method `calculate(amount, months, annualRate)` implemented by all repayment algorithms.

2. **Concrete Strategies (3 algorithms):**
   - `AnnuityRepaymentStrategy`: Equal monthly payments throughout the entire term (standard bank annuity).
   - `DifferentiatedRepaymentStrategy`: Fixed principal reduction with decreasing monthly payments as remaining debt drops.
   - `GracePeriodRepaymentStrategy`: 3-month interest-only grace period before full repayment begins.

3. **Context (`LoanCalculator`):**
   - Holds a reference to a `RepaymentStrategy`.
   - Provides `setStrategy(RepaymentStrategy strategy)` for dynamic runtime switching.
   - Contains zero conditional branching logic; simply delegates calculation to the active strategy.

4. **Model & Client:**
   - `RepaymentPlan`: Stores calculation details (`name`, `total`, `note`) and formats a clean one-line summary.
   - `Main`: Demonstrates configuring the calculator and switching between all three strategies at runtime for the same loan parameters.

---

## Clean Code Principles Applied

1. **Elimination of Conditional Logic:** Replaced `if-else` or `switch` statements with polymorphism. The `LoanCalculator` executes the algorithm without checking what type of strategy it is.
2. **Single Responsibility Principle (SRP):** Each strategy class encapsulates exactly one mathematical repayment model and has only one reason to change.
3. **Open/Closed Principle (OCP):** New repayment schemes (such as promotional 0% installment plans) can be added simply by creating a new class implementing `RepaymentStrategy` without editing existing code.
4. **Context is Algorithm-Agnostic:** `LoanCalculator` depends only on the `RepaymentStrategy` abstraction and knows nothing about internal formula mechanics.
5. **Meaningful, Intention-Revealing Names:** Class and method names (`AnnuityRepaymentStrategy`, `LoanCalculator`, `setStrategy`, `calculate`) clearly state their purpose without needing comments.

---

## How to Run

```bash
javac -d bin $(find src -name "*.java")
java -cp bin com.fintech.strategy.Main
```
