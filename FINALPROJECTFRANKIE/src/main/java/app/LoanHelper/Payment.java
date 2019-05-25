package app.LoanHelper;

import java.util.Date;

import org.apache.poi.ss.formula.functions.Finance;

public class Payment {
	
	private int PaymentID;
	private Date DueDate;
	private double IPMT;
	private double PPMT;
	private double TotalPrinciple;
	private Loan L;
	private double Balance;
	private double AdditionalPayment;
	
	
	public Payment(int paymentID, Date dueDate, double balance, Loan l) {
		super();
		this.L = l;
		PaymentID = paymentID;
		DueDate = dueDate;
		IPMT  = balance * (L.getInterestRate() / 12);
		PPMT = Math.abs(getPPMT());
		TotalPrinciple = PPMT + Loan.getExtraPayment();
		Balance = balance - TotalPrinciple;	
	}

	
	
	//get ppmt 
	
	public int getPaymentID() {
		return PaymentID;
	}

	public Date getDueDate() {
		return DueDate;
	}

	public double getIPMT() {
		return IPMT;
	}

	public double getTotalPrinciple() {
		return TotalPrinciple;
	}

	public double getBalance() {
		return Balance;
	}
	
	public Loan getL() {
		return L;
	}

	public double getAdditionalPayment() {
		return AdditionalPayment;
	}

	public double getPPMT() {
		return Finance.ppmt(this.L.getInterestRate()/12, this.PaymentID, (int) (this.L.getTerm()*12), this.L.getLoanAmount());
	}
	
	public void setPPMT(double pPMT) {
		PPMT = pPMT;
	}



	public void setBalance(int i) {
		
	}




}