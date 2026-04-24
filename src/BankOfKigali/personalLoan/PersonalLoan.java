package BankOfKigali.personalLoan;

import BankOfKigali.loanManager.LoanManager;

public class PersonalLoan extends LoanManager {
    private String purpose;

    public PersonalLoan() {
        super();
        this.setLoanType("Personal");
        this.setInterestRate(0.18);
    }

    public PersonalLoan(String loanId, double loanAmount, int loanDuration, String officerName, String branchLocation,
                        String purpose) {
        super(loanId, "Personal", loanAmount, 0.18, loanDuration, officerName, branchLocation);
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() * (getLoanDuration() / 12.0);
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() < 50000000;
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String toString() {
        return super.toString() + "\nLoan Purpose: " + purpose;
    }

}
