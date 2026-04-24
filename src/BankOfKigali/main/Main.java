package BankOfKigali.main;

import BankOfKigali.customer.Customer;
import BankOfKigali.inputValidator.InputValidator;
import BankOfKigali.loan.Loan;
import BankOfKigali.loanFactory.LoanFactory;
import BankOfKigali.loanManager.LoanManager;
import BankOfKigali.personalLoan.PersonalLoan;
import BankOfKigali.homeLoan.HomeLoan;
import BankOfKigali.carLoan.CarLoan;
import BankOfKigali.businessLoan.BusinessLoan;
import BankOfKigali.studentLoan.StudentLoan;
import BankOfKigali.agricultureLoan.AgricultureLoan;
import BankOfKigali.repayment.Repayment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== BANK OF KIGALI LOAN SYSTEM ==========");

        System.out.println("\n--- Enter Customer Details ---");
        int customerId = getValidInt(scanner, "Enter Customer ID: ");
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        String nationalId = "";
        while (true) {
            System.out.print("Enter National ID (16 digits): ");
            nationalId = scanner.nextLine();
            if (InputValidator.isValidNationalId(nationalId))
                break;
            System.out.println("Error: Invalid National ID format. Must be exactly 16 digits.");
        }

        String phone = "";
        while (true) {
            System.out.print("Enter Phone Number (e.g., 07... 10 digits): ");
            phone = scanner.nextLine();
            if (InputValidator.isValidPhoneNumber(phone))
                break;
            System.out.println("Error: Invalid Phone Number format.");
        }
        Customer customer = new Customer(customerId, customerName, nationalId, phone);

        System.out.println("\n--- Enter Loan Details ---");
        Loan loan = null;
        while (loan == null) {
            System.out.print("Enter Loan Type (Personal, Home, Car, Business, Student, Agriculture): ");
            String type = scanner.nextLine();
            loan = LoanFactory.createLoan(type);
        }

        String loanId = "";
        while (true) {
            System.out.print("Enter Loan ID (digits only): ");
            loanId = scanner.nextLine();
            if (InputValidator.isValidLoanId(loanId))
                break;
            System.out.println("Error: Invalid Loan ID. Must contain only numbers.");
        }
        loan.setLoanId(loanId);

        double amount = 0;
        while (true) {
            amount = getValidDouble(scanner, "Enter Loan Amount (RWF): ");
            if (InputValidator.isValidAmount(amount))
                break;
            System.out.println("Error: Loan amount must be greater than 0.");
        }
        loan.setLoanAmount(amount);

        int duration = 0;
        while (true) {
            duration = getValidInt(scanner, "Enter Loan Duration (in months): ");
            if (InputValidator.isValidDuration(duration))
                break;
            System.out.println("Error: Invalid duration (must be 1 to 360 months).");
        }
        loan.setLoanDuration(duration);

        if (loan instanceof LoanManager) {
            LoanManager lm = (LoanManager) loan;
            System.out.print("Enter Loan Officer Name: ");
            lm.setOfficerName(scanner.nextLine());
            System.out.print("Enter Branch Location: ");
            lm.setBranchLocation(scanner.nextLine());

            if (lm instanceof PersonalLoan) {
                System.out.print("Enter Loan Purpose: ");
                ((PersonalLoan) lm).setPurpose(scanner.nextLine());
            } else if (lm instanceof HomeLoan) {
                System.out.print("Enter Property Address: ");
                ((HomeLoan) lm).setPropertyAddress(scanner.nextLine());
            } else if (lm instanceof CarLoan) {
                System.out.print("Enter Vehicle Model: ");
                ((CarLoan) lm).setVehicleModel(scanner.nextLine());
            } else if (lm instanceof BusinessLoan) {
                System.out.print("Enter Business Registration Number: ");
                ((BusinessLoan) lm).setBusinessRegistrationNumber(scanner.nextLine());
            } else if (lm instanceof StudentLoan) {
                System.out.print("Enter University Name: ");
                ((StudentLoan) lm).setUniversityName(scanner.nextLine());
            } else if (lm instanceof AgricultureLoan) {
                System.out.print("Enter Farm Type: ");
                ((AgricultureLoan) lm).setFarmType(scanner.nextLine());
            }
        }


        System.out.println("\n========== SYSTEM SUMMARY ==========");
        System.out.println(customer.toString());
        System.out.println("\n" + loan.toString());

        double totalRepayment = loan.calculateTotalRepayment();
        System.out.println("\nCalculated Interest: " + String.format("%.2f", loan.calculateInterest()) + " RWF");
        System.out.println("Total Amount to Repay: " + String.format("%.2f", totalRepayment) + " RWF");


        System.out.println("\n--- Repayment Process ---");
        double paymentAmount = 0;
        while (true) {
            paymentAmount = getValidDouble(scanner, "Enter Payment Amount (RWF): ");
            if (paymentAmount > 0 && paymentAmount <= totalRepayment)
                break;
            System.out.println(
                    "Error: Payment must be > 0 and cannot exceed the total repayment (" + totalRepayment + ").");
        }

        Repayment repayment = new Repayment(101, loan.getLoanId(), paymentAmount, "2023-10-25", totalRepayment);
        repayment.processPayment(paymentAmount);

        System.out.println("\n========== PAYMENT RECEIPT ==========");
        System.out.println(repayment.toString());
        System.out.println("Remaining Balance: " + String.format("%.2f", repayment.getRemainingBalance()) + " RWF");
        System.out.println("=====================================");

        scanner.close();
    }

    private static int getValidInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid whole number (no text or decimals).");
                sc.nextLine();
            }
        }
    }

    private static double getValidDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number (e.g., 50000 or 50000.50).");
                sc.nextLine();
            }
        }
    }
}

