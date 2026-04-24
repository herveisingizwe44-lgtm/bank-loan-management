package BankOfKigali.loanManager;

import BankOfKigali.loan.Loan;
import BankOfKigali.payable.Payable;

public class LoanManager extends Loan implements Payable {
    private String officerName;
    private String branchLocation;

    public LoanManager(String officerName, String branchLocation) {
        this.officerName = officerName;
        this.branchLocation = branchLocation;
    }

    public LoanManager() {
        super();
    }

    public LoanManager(String loanId, String loanType, double loanAmount, double interestRate, int loanDuration,
                       String officerName, String branchLocation) {
        super(loanId, loanType, loanAmount, interestRate, loanDuration, "Pending");
        this.officerName = officerName;
        this.branchLocation = branchLocation;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    @Override
    public double calRemainingBalance() {

        return 0;

    }

    @Override
    public void ProcessPayment() {

    }

    @Override
    public void generatePaymentReceipt() {

    }

    @Override
    public String toString() {
        return super.toString() + "\nOfficer Name: " + officerName + "\nBranch Location: " + branchLocation;
    }

    @Override
    public double calculateInterest() {

        return 0;
    }

    @Override
    public double calculateMonthlyInstallment() {

        return 0;
    }

    @Override
    public boolean checkEligibility() {

        return false;
    }

    @Override
    public boolean approveLoan() {

        return false;
    }

    @Override
    public boolean rejectLoan() {

        return false;
    }

    @Override
    public double calculateTotalRepayment() {

        return 0;
    }

    @Override
    public void generateLoanReport() {

    }

    @Override
    public boolean validateLoanDetails() {

        return false;
    }

}
