package testInfo;

public class PromotionSystem {
	
	private static final int RESET = 0;
	private Employee employee;
	private EmployeePerformance performanceInfo;
	private static PromotionSystem instance = new PromotionSystem();
	private PromotionSystem() {}
	
	public static PromotionSystem getInstance()
	{
		return instance;
	}
	
	public void decidePromotion(Employee employee)
	{
		this.employee = employee;
		this.performanceInfo = employee.getPerformanceInfo();
		DataStorage dsInstance = DataStorage.getInstance();
		StatData appraisalStat = dsInstance.getAppraisalStat();
		if (performanceInfo.getYrsExperienceOnThisGrade() > getMaxYearPermittedPerGrade(employee.getGrade()) && employee.getAppraisal() > appraisalStat.getUQ())
			this.adjustGrade();
	}
	
	private void adjustGrade()
	{
		int newGrade = employee.getGrade();
		while (!AdjustStipendSystem.stipendValidation(employee))
			newGrade++;
		performanceInfo.setYrsExperienceOnThisGrade(RESET);
		employee.setGrade(newGrade);
	}
	
	public static int getMaxYearPermittedPerGrade(int grade)
	{
		if (grade < 8)
			return ++grade;
		else
			return 999;
	}
	
}
