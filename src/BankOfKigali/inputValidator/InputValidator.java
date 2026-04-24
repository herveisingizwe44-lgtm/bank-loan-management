package BankOfKigali.inputValidator;

public class InputValidator {
    public static boolean isValidLoanId(String loanId) {
        return loanId != null && loanId.matches("\\d+");
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidDuration(int months) {
        return months > 0 && months <= 360;
    }

    public static boolean isValidNationalId(String nationalId) {
        return nationalId != null && nationalId.length() == 16 && nationalId.matches("\\d+");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.startsWith("07") && phoneNumber.length() == 10;
    }

}

