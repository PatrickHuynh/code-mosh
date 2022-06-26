import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    final static int MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {
        double principal = (double) requestInputNumber("Principal", 1000, 1_000_000);
        double annualInterestRate = (double) requestInputNumber("Annual Interest Rate (%)", 0, 30)/100.0;
        int loanPeriodYears = (int) requestInputNumber("Period (Years)", 1, 30);

        // monthly mortgage
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        double monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR;
        int loanPeriodMonths = loanPeriodYears * MONTHS_IN_YEAR;
        double mortgageRepayment = calculateMortgageRepayment(principal, monthlyInterestRate, loanPeriodMonths);
        double[] paymentSchedule = calculatePaymentSchedule(principal, monthlyInterestRate, loanPeriodMonths);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("_________");
        System.out.println("Monthly Payments: " + numberFormatter.format(mortgageRepayment));
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("__________________");
        for (double paymentBalance: paymentSchedule) {
            System.out.println(numberFormatter.format(paymentBalance));
        }
    }

    // request and validate input
    public static double requestInputNumber(String prompt, double min, double max){
        Scanner lineInput = new Scanner(System.in);
        double numberInput;
        while (true) {
            System.out.print(prompt + ": ");
            numberInput = lineInput.nextDouble();
            if ((numberInput >= min) && (numberInput <= max))
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return numberInput;
    }

    // calculate the mortgage repayment
    public static double calculateMortgageRepayment(double principal, double monthlyInterestRate, int loanPeriodMonths) {
        double mortgageRepayment = principal * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), loanPeriodMonths)) / (Math.pow((1+monthlyInterestRate),loanPeriodMonths)-1);
        return mortgageRepayment;
    }

    // calculate the payment schedule
    public static double[] calculatePaymentSchedule(double principal, double monthlyInterestRate, int loanPeriodMonths){
        double[] paymentSchedule = new double[loanPeriodMonths];
        double unityMonthlyInterestRate = (1+monthlyInterestRate);
        for (int p = 0; p < loanPeriodMonths; p++)
        {
            paymentSchedule[p] = principal*((Math.pow(unityMonthlyInterestRate,loanPeriodMonths)-Math.pow(unityMonthlyInterestRate,p+1))/(Math.pow(unityMonthlyInterestRate,loanPeriodMonths)-1));
        }
        return paymentSchedule;
    }

}
