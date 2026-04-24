package BankOfKigali.customer;

public class Customer {

    private int customerId;
    private String customerName;
    private String nationalId;
    private String phoneNumber;

    public Customer(int customerId, String customerName, String nationalId, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.nationalId = nationalId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", nationalId=" + nationalId
                + ", phoneNumber=" + phoneNumber + "]";
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
