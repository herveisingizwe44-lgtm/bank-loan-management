package BankOfKigali.studentLoan;

import BankOfKigali.loanManager.LoanManager;

public class StudentLoan extends LoanManager {
    private String universityName;

    public StudentLoan() {
        super();
        this.setLoanType("Student");
        this.setInterestRate(0.05);
    }

    public StudentLoan(String loanId, double loanAmount, int loanDuration, String officerName, String branchLocation,
                       String universityName) {
        super(loanId, "Student", loanAmount, 0.05, loanDuration, officerName, branchLocation);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }


    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() * (getLoanDuration() / 12.0);
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() < 10000000;
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String toString() {
        return super.toString() + "\nUniversity Name: " + universityName;
    }

}
