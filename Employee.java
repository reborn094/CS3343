package testInfo;

public class Employee implements Comparable<Employee>{
	
	private String id; // public toilet
	private double appraisalScore;  // public toilet
	private int grade; // public toilet
	private EmployeeFinance financeInfo;
	private EmployeePerformance performanceInfo;
	private EmployeeWelfare welfareInfo;
	
	public Employee (String id, double appraisalScore, int grade, EmployeeFinance financeInfo, EmployeePerformance performanceInfo, EmployeeWelfare welfareInfo)
	{
		this.id = id;
		this.appraisalScore = appraisalScore;
		this.grade = grade;
		this.financeInfo = financeInfo;
		this.performanceInfo = performanceInfo;
		this.welfareInfo = welfareInfo;
	}
	
	@Override
	public int compareTo(Employee toBeCompared)
	{
		return this.id.compareTo(toBeCompared.getID());
	}
	
	public EmployeeFinance getFinanceInfo() 
	{
		return financeInfo;
	}

	public EmployeePerformance getPerformanceInfo() 
	{
		return performanceInfo;
	}

	public EmployeeWelfare getWelfareInfo() 
	{
		return welfareInfo;
	}
	
	public double getAppraisal()
	{
		return this.appraisalScore;
	}
	
	
	public void setGrade(int newGrade)
	{
		this.grade = newGrade;
	}
	
	
	public String getID()
	{
		return this.id;
	}

	
	public int getGrade()
	{
		return this.grade;
	}
	
	
	public boolean testFunction()
	{
		AdjustStipendSystem.getInstance().adjustStipend(this);
		return AdjustStipendSystem.stipendValidation(this);
	}
	
}
