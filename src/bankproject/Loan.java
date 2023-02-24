package bankproject;

public class Loan {

    private double loan;
    private int years;
    private double rate = 1.99;
    private double interest;
    private double totalPayable;
    private double monthlyPayable;
    private double remainingAmount;
    private boolean isLoan = false;

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest() {
        this.interest = this.loan * (this.rate / 100);

    }

    public double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable() {
        this.totalPayable = this.loan + this.interest;
    }

    public double getMonthlyPayable() {
        return monthlyPayable;
    }

    public void setMonthlyPayable() {
        this.monthlyPayable = this.totalPayable / (this.years * 12);
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount() {
        this.remainingAmount = this.getTotalPayable();
    }

    public void editRemainingAmount(double MonthlyPayable) {
        if (isLoan) {

        }
        this.remainingAmount -= MonthlyPayable;
        if (this.remainingAmount <= 0) {
            this.destroyLoan();
        }
    }

    public void destroyLoan() {
        this.loan = 0;
        this.interest = 0;
        this.monthlyPayable = 0;
        this.totalPayable = 0;
        this.years = 0;
        this.rate = 0;
        this.remainingAmount = 0;
        this.isLoan = false;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public void setIsLoan(boolean isLoan) {
        this.isLoan = isLoan;
    }

    @Override
    public String toString() {
        return "Loan{" + "loan=" + loan + ", years=" + years + ", rate=" + rate + ", interest=" + interest + ", totalPayable=" + totalPayable + ", monthlyPayable=" + monthlyPayable + ", remainingAmount=" + remainingAmount + ", isLoan=" + isLoan + '}';
    }

}
