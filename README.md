# Assignment #4 — Facade Pattern

**Course:** Software Design Patterns  
**Topic:** Facade Structural Pattern  
**Package:** `com.fintech`

---

## Overview

This project implements the **Facade pattern** for a consumer bank loan approval process. 
Instead of having the client coordinate multiple verification steps manually, `BankLoanFacade` handles the entire underwriting workflow in a single call.

### Subsystem Classes (`com.fintech.subsystem`)
- `IdentityValidator`: Checks if the IIN is 12 digits and not blacklisted.
- `CreditScoreService`: Returns the client's credit rating (score scale 300–850).
- `SolvencyService`: Verifies that the client's salary is enough to cover current debt and the new monthly payment.
- `TransferService`: Generates a contract ID (`KZ-XXXXXX`) and completes the transfer.

### Facade (`com.fintech.facade`)
- `BankLoanFacade`: Coordinates the 4 services in order:
  1. Validates identity (rejects if invalid or blacklisted).
  2. Checks credit score (sets 16% or 22% rate, or rejects if score is under 600).
  3. Checks solvency (rejects if monthly payment is too high for salary).
  4. Disburses the loan and returns the contract result.

### Models & Client
- `Applicant`: Stores borrower data (name, IIN, salary, current debt).
- `LoanResult`: Holds the loan outcome and formats a clean single-line summary.
- `Main`: Tests approval, rejection by income, rejection by blacklist, and includes a direct check using `IdentityValidator` to show that subsystem classes work independently.

---

## Clean Code Principles

1. **Single Responsibility Principle (SRP):** `BankLoanFacade` only organizes the steps of the loan pipeline. It doesn't calculate debt ratios or validate IINs itself.
2. **Principle of Least Knowledge (Law of Demeter):** `Main` only calls `BankLoanFacade` and doesn't need to know how the subsystem classes work inside.
3. **Information Hiding:** The facade takes basic arguments and returns a clean `LoanResult` without exposing internal subsystem objects.
4. **Meaningful Names:** Class and method names like `canAfford`, `isValid`, and `applyForLoan` explain their purpose clearly without comments.
5. **Subsystem Independence:** None of the 4 subsystem classes depend on the facade. Advanced clients can still use them directly when needed.

---

## How to Run

```bash
javac -d bin $(find src -name "*.java")
java -cp bin com.fintech.Main
```
