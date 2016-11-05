package testInfo;

public class DismissalSystem {

	private static DismissalSystem instance = new DismissalSystem();
	private Employee employee;
	private EmployeePerformance performanceInfo;
	private DismissalSystem () {}
	
	public static DismissalSystem getInstance()
	{
		return instance;
	}
	
	public boolean determineDismissal(Employee employee)
	{
		this.employee = employee;
		this.performanceInfo = employee.getPerformanceInfo();
		if (maxYearExperience(employee.getGrade()) > performanceInfo.getYrsExperienceOnThisGrade())
		{
			if (getDismissalFactor() < 30 && warningLetterFactor())
				return true;
		}
		return false;
	}
	
	private boolean warningLetterFactor()
	{
		if (performanceInfo.getWarningLetterReceived() > 2)
			return true;
		else 
			return false;
	}
	
	private double getDismissalFactor()
	{
		return this.getAppraisalPortion() + this.getWorkingHourPortion();
	}
	
	private double getAppraisalPortion()
	{
		DataStorage dsInstance = DataStorage.getInstance();
		StatData appraisalStat = dsInstance.getAppraisalStat();
		if (employee.getAppraisal() < appraisalStat.getLQ())
			return 17.5; // 70 * .25
		else if (employee.getAppraisal() < appraisalStat.getMedian())
			return 35; // 70 * .5
		else if (employee.getAppraisal() < appraisalStat.getUQ())
			return 52.5; // 70 * .75
		else
			return 70; // 70 * 1
	}
	
	private double getWorkingHourPortion()
	{
		DataStorage dsInstance = DataStorage.getInstance();
		StatData workingHourStat = dsInstance.getWorkingHourStat();
		if (employee.getAppraisal() < workingHourStat.getLQ())
			return 7.5; // 30 * .25
		else if (employee.getAppraisal() < workingHourStat.getMedian())
			return 15; // 30 * .5
		else if (employee.getAppraisal() < workingHourStat.getUQ())
			return 22.5; // 30 * .75
		else
			return 30; // 30 * 1
	}
	
	public static int maxYearExperience(int grade)
	{
		switch(grade)
		{
		case 1:
			return 5;
		case 2: case 3: case 4:
			return 4;
		case 5: case 6: case 7:
			return 3;
		case 8: case 9: case 10:
			return 2;
		default: 
			return 0;
		}
	}
	
}
