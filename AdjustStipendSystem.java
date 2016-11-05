package testInfo;

public class AdjustStipendSystem {
	
	private Employee employee;
	private EmployeeFinance financeInfo;
	private static AdjustStipendSystem instance = new AdjustStipendSystem();
	private static final double STIPENDTHRESHOLD = 7500.0;
	private static final double BONUSCAP = 1.5;
	
	private AdjustStipendSystem() {}
	
	public static AdjustStipendSystem getInstance()
	{
		return instance;
	}
	
	public void adjustStipend(Employee employee)
	{
		this.employee = employee;
		this.financeInfo = employee.getFinanceInfo();
		this.alterBonusRate();
		financeInfo.setStipend(financeInfo.getStipend() * financeInfo.getBonus());
	}
	
	private double calculateBonusRate()
	{
		DataStorage dsInstance = DataStorage.getInstance(); 
		StatData appraisalStat = dsInstance.getAppraisalStat();
		if (employee.getAppraisal() < appraisalStat.getLQ())
			return 0.90;
		else if (employee.getAppraisal() < appraisalStat.getMedian())
			return 1.05;
		else if (employee.getAppraisal() < appraisalStat.getUQ())
			return 1.07;
		else
			return 1.10;
	}
	private void alterBonusRate()
	{
		double newBonusRate = this.calculateBonusRate();
		if (newBonusRate > BONUSCAP)
			financeInfo.setBonus(BONUSCAP);
		else
			financeInfo.setBonus(newBonusRate);
	}
	
	public static boolean stipendValidation(Employee employee)
	{
		if (employee.getFinanceInfo().getStipend() > getStipendCap(employee.getGrade()))
			return false;
		else
			return true;
	}
	
	public static double getStipendCap(int grade)
	{
		switch (grade)
		{
		case 1:
			return 10000.0;
		case 2:
			return 15000.0;
		case 3:
			return 21000.0;
		case 4:
			return 28000.0;
		case 5:
			return 36000.0;
		case 6:
			return 45000.0;
		case 7:
			return 55000.0;
		case 8:
			return 66000.0;
		case 9:
			return 78000.0;
		case 10:
			return 91000.0;
		default: 
			return 0.0;
		}
	}
	
	
}
