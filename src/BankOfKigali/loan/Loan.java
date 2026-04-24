package BankOfKigali.loan;

public abstract class Loan {
    private String loanId;
    private String loanType;
    private double loanAmount;
    private double interestRate;
    private int loanDuration;
    private String loanStatus;

    public Loan() {
    }

    public Loan(String loanId, String loanType, double loanAmount, double interestRate, int loanDuration,
                String loanStatus) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
        this.loanStatus = loanStatus;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        if (loanId != null && loanId.matches("\\d+")) {
            this.loanId = loanId;
        } else {
            System.out.println("Invalid Loan Id");
        }
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    @Override
    public String toString() {
        return "Loan Id: " + loanId + "\nLoan Type: " + loanType + "\nLoan Amount: " + loanAmount + "\nInterest Rate: "
                + interestRate + "\nLoan Duration: " + loanDuration + "\nLoan Status: " + loanStatus;
    }

    public abstract double calculateInterest();

    public abstract double calculateMonthlyInstallment();

    public abstract boolean checkEligibility();

    public abstract boolean approveLoan();

    public abstract boolean rejectLoan();

    public abstract double calculateTotalRepayment();

    public abstract void generateLoanReport();

    public abstract boolean validateLoanDetails();

}

