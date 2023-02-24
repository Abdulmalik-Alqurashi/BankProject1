package bankproject;

public class Account {

    private static long noAccount = 0;
    private long accountNumber;
    private double balance = 0;

    Loan loan = new Loan();

    Account() {
        this.setAccountNumber();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void Deposit(double balance) {
        this.balance += balance;
    }

    public void Withdrawal(double balance) {
        if (this.balance >= balance) {
            this.balance -= balance;
        } else {
            System.out.println("Balance is not enough ..!");
        }

    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber() {
        this.accountNumber = ++this.noAccount;
    }

    public String newLoan(double loan, int years, double rate) {
        if (this.loan.isLoan()) {
            return "The customer has a loan ..!";
        } else {
            this.loan.setLoan(loan);
            this.loan.setYears(years);
            this.loan.setRate(rate);
            this.loan.setInterest();
            this.loan.setTotalPayable();
            this.loan.setMonthlyPayable();
            this.loan.setRemainingAmount();
            this.loan.setIsLoan(true);
            this.Deposit(loan);
            return "The value of the loan was deposited in your account. Congratulations!";
        }
    }

    public String payMonthlyPayment() {
        if (loan.isLoan()) {
            if (this.getBalance() >= this.loan.getMonthlyPayable()) {
                if (this.loan.getRemainingAmount() >= this.loan.getMonthlyPayable()) {
                    this.Withdrawal(this.loan.getMonthlyPayable());
                    this.loan.editRemainingAmount(this.loan.getMonthlyPayable());
                }
                if (this.loan.getRemainingAmount() < this.loan.getMonthlyPayable()) {
                    this.Withdrawal(this.loan.getRemainingAmount());
                    this.loan.editRemainingAmount(this.loan.getRemainingAmount());
                }
                return "Congratulations, were paid a monthly payment of the loan.";

            } else {
                return "Balance is not enough .. !";
            }
        } else {
            return "The customer is not have a loan .. !";
        }
    }

    @Override
    public String toString() {
        return "Account{" + "Account number=" + accountNumber + ", balance=" + balance + '}';
    }

}
