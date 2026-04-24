package BankOfKigali.businessLoan;

import BankOfKigali.loanManager.LoanManager;

public class BusinessLoan extends LoanManager {

    private String businessRegistrationNumber;


    public BusinessLoan() {
        super();
        this.setLoanType("Business");
        this.setInterestRate(0.20);
    }

    public BusinessLoan(String loanId, double loanAmount, int loanDuration, String officerName, String branchLocation,
                        String businessRegistrationNumber) {
        super(loanId, "Business", loanAmount, 0.20, loanDuration, officerName, branchLocation);
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
    }


    @Override
    public double calculateInterest() {

        return getLoanAmount() * getInterestRate() * (getLoanDuration() / 12.0);
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() < 500000000;
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String toString() {
        return super.toString() + "\nBusiness Registration Number: " + businessRegistrationNumber;
    }

}

