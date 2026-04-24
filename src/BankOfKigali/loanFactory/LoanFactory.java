package BankOfKigali.loanFactory;

import BankOfKigali.agricultureLoan.AgricultureLoan;
import BankOfKigali.businessLoan.BusinessLoan;
import BankOfKigali.carLoan.CarLoan;
import BankOfKigali.homeLoan.HomeLoan;
import BankOfKigali.loan.Loan;
import BankOfKigali.personalLoan.PersonalLoan;
import BankOfKigali.studentLoan.StudentLoan;

public class LoanFactory {

    public static Loan createLoan(String loanType) {
        if (loanType == null || loanType.trim().isEmpty()) {
            return null;
        }

        switch (loanType.toUpperCase()) {
            case "PERSONAL":
                return new PersonalLoan();
            case "HOME":
                return new HomeLoan();
            case "CAR":
                return new CarLoan();
            case "BUSINESS":
                return new BusinessLoan();
            case "STUDENT":
                return new StudentLoan();
            case "AGRICULTURE":
                return new AgricultureLoan();
            default:
                System.out.println("Error: Invalid loan type '" + loanType + "' specified.");
                return null;
        }
    }
}
