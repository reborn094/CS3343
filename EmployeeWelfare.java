package testInfo;

public class EmployeeWelfare {

	private boolean housingAllowance; // welfare
	private double annualLeave; // welfare
	private double otHour; // welfare
	
	public boolean isHousingAllowance() 
	{
		return housingAllowance;
	}
	
	public void setHousingAllowance(boolean housingAllowance) 
	{
		this.housingAllowance = housingAllowance;
	}
	
	public double getAnnualLeave() 
	{
		return annualLeave;
	}
	
	public void setAnnualLeave(double annualLeave) 
	{
		this.annualLeave = annualLeave;
	}
	
	public double getOtHour() 
	{
		return otHour;
	}
	
	public void setOtHour(double otHour) 
	{
		this.otHour = otHour;
	}
	
}
