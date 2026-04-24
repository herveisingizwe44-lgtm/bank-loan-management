package BankOfKigali.homeLoan;

import BankOfKigali.loanManager.LoanManager;

public class HomeLoan extends LoanManager {
    private String propertyAddress;


    public HomeLoan() {
        super();
        this.setLoanType("Home");
        this.setInterestRate(0.12);
    }

    public HomeLoan(String loanId, double loanAmount, int loanDuration, String officerName, String branchLocation,
                    String propertyAddress) {
        super(loanId, "Home", loanAmount, 0.12, loanDuration, officerName, branchLocation);
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }


    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() * (getLoanDuration() / 12.0);
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() < 200000000;
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String toString() {
        return super.toString() + "\nProperty Address: " + propertyAddress;
    }

}
