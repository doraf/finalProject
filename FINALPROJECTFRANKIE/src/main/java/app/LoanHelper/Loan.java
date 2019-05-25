package app.LoanHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import java.text.ParseException;


public class Loan {

	private double LoanAmount;
	private double InterestRate;
	private int Term;
	private double ExtraPayment;
	private boolean Compounds;
	private double FV;
	private Date StartDate;
	
	private LinkedList<Payment> LoanPayments = new LinkedList<Payment>();
	
	
	
	public Loan(double loanAmount, double interestRate, 
			int term, double extraPayment, 
			boolean compounds, double fV) {
		super();
	//	
		try {
			StartDate = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2019-06-01" );
		} catch (ParseException e) {
		}
		
		
		int PaymentNbr = 0;
		double dRollingBalance = this.LoanAmount;
		
				
		
		
		
		do 
		{
			Payment p = new Payment(++PaymentNbr, StartDate, dRollingBalance, this);
			this.LoanPayments.add(p);
			dRollingBalance = p.getBalance();
			
			if (dRollingBalance <= 0)
			{
				this.LoanPayments.getLast().setBalance(0);	
				break;
			}
			
		} while (true);
		
	}		
		
		



	public int getInterestRate() {
		
		return 0;
	}





	public static double getExtraPayment() {
		
		return 0;
	}
}