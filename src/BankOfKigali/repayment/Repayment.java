package BankOfKigali.repayment;

public class Repayment {
    private int repaymentId;
    private String loanId;
    private double amountPaid;
    private String date;
    private double remainingBalance;

    public Repayment(int repaymentId, String loanId, double amountPaid, String date, double remainingBalance) {
        this.repaymentId = repaymentId;
        this.loanId = loanId;
        this.amountPaid = amountPaid;
        this.date = date;
        this.remainingBalance = remainingBalance;
    }

    public int getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(int repaymentId) {
        this.repaymentId = repaymentId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    @Override
    public String toString() {
        return "Repayment [repaymentId=" + repaymentId + ", loanId=" + loanId + ", amountPaid=" + amountPaid + ", date="
                + date + ", remainingBalance=" + remainingBalance + "]";
    }

    public void processPayment(double paymentAmount) {
        this.remainingBalance -= paymentAmount;
    }
}

