package BankOfKigali.agricultureLoan;

import BankOfKigali.loanManager.LoanManager;

public class AgricultureLoan extends LoanManager {
        private String farmType;

        public AgricultureLoan() {
            super();
            this.setLoanType("Agriculture");
            this.setInterestRate(0.08);
        }

        public AgricultureLoan(String loanId, double loanAmount, int loanDuration, String officerName,
                               String branchLocation,
                               String farmType) {
            super(loanId, "Agriculture", loanAmount, 0.08, loanDuration, officerName, branchLocation);

            this.farmType = farmType;
        }

        public String getFarmType() {
            return farmType;
        }

        public void setFarmType(String farmType) {
            this.farmType = farmType;
        }


        @Override
        public double calculateInterest() {
            return getLoanAmount() * getInterestRate() * (getLoanDuration() / 12.0);
        }

        @Override
        public boolean checkEligibility() {
            return getLoanAmount() < 100000000;
        }

        @Override
        public double calculateTotalRepayment() {
            return getLoanAmount() + calculateInterest();
        }

        @Override
        public String toString() {
            return super.toString() + "\nFarm Type: " + farmType;
        }

    }


