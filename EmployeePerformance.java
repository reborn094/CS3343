package testInfo;

public class EmployeePerformance {
	private int yrsExperienceOnThisGrade; // performance
	private int warningLetterReceived; // performance
	private double totalWorkingHour; // performance
	
	public int getYrsExperienceOnThisGrade() 
	{
		return yrsExperienceOnThisGrade;
	}
	
	public void setYrsExperienceOnThisGrade(int yrsExperienceOnThisGrade) 
	{
		this.yrsExperienceOnThisGrade = yrsExperienceOnThisGrade;
	}
	
	public int getWarningLetterReceived() 
	{
		return warningLetterReceived;
	}
	
	public void setWarningLetterReceived(int warningLetterReceived) 
	{
		this.warningLetterReceived = warningLetterReceived;
	}
	
	public double getTotalWorkingHour() 
	{
		return totalWorkingHour;
	}
	
	public void setTotalWorkingHour(double totalWorkingHour) 
	{
		this.totalWorkingHour = totalWorkingHour;
	}
}
