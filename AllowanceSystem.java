package testInfo;

public class AllowanceSystem {
	private static final double housingAllowance = 10000;
	private Employee employee;
	private EmployeeFinance financeInfo;
	private EmployeeWelfare welfareInfo;
	private static AllowanceSystem instance = new AllowanceSystem();
	private AllowanceSystem(){}
	
	public static AllowanceSystem getInstance(){
		return instance;
	}
	
	public void setHousingAllowance(Employee employee, boolean demotion){
		this.employee = employee;
		this.financeInfo = employee.getFinanceInfo();
		this.welfareInfo = employee.getWelfareInfo();
		//DataStorage dsInstance = DataStorage.getInstance();
		if (this.employee.getGrade()>7)
		{
			this.welfareInfo.setHousingAllowance(true); // When output salary, if allowance = true then add $amount  
			this.financeInfo.setStipend(financeInfo.getStipend()+housingAllowance);
		}
		else if (this.employee.getGrade()<=7 && demotion)
		{
			this.welfareInfo.setHousingAllowance(false); // When output salary, if allowance = true then add $amount  
			this.financeInfo.setStipend(financeInfo.getStipend()-housingAllowance);
		}
	}
	
	// HOWEVER, THERE SHOULD STILL BE A DISCUSSION ABOUT THE MANNER OF GRANTING HOUSINGG ALLOWANCE
	
	
	
}
