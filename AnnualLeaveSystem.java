package testInfo;

public class AnnualLeaveSystem {
	private static final double alCap = 35.0;
	private static final double alPerMonth = 2.0;
	private EmployeeWelfare welfareInfo;
	private static AnnualLeaveSystem instance = new AnnualLeaveSystem();
	private AnnualLeaveSystem(){}
	
	public static AnnualLeaveSystem getInstance(){
		return instance;
	}
	
	public void addAnnualLeavePerMonthAndFromOT(Employee employee)
	{
		this.welfareInfo = employee.getWelfareInfo();
		if (routineALAdd())
			addALByOTHrs();
		else
			this.welfareInfo.setOtHour(0.0); // though no additional AL, OT hours must reset
	}
	
	private boolean routineALAdd()
	{
		// add 2 AL per Month
		double currAL = this.welfareInfo.getAnnualLeave();
		if (currAL+alPerMonth <= alCap){
			this.welfareInfo.setAnnualLeave(currAL+alPerMonth);
			return true; // return true for need to calculate the AL gain due to OT
		}else{
			this.welfareInfo.setAnnualLeave(35.0);
			return false; // return false, due to AL count already reached cap, not eligible for AL from OT 
		}
	}
	
	private void addALByOTHrs()
	{
		// add 0.5 AL per 4 OT Hours
		double currOT = this.welfareInfo.getOtHour();
		double ALadd = currOT/4 * 0.5; // Count 4 hours as half a day;
		double newAL = ALadd+this.welfareInfo.getAnnualLeave();
		if (newAL <= alCap){
			this.welfareInfo.setAnnualLeave(newAL);	
		}else{
			this.welfareInfo.setAnnualLeave(35.0);
		}
		
		this.welfareInfo.setOtHour(0.0); // clean up the OT Hours;
	}
	
	public boolean takeAnnualLeave(double daysApplied) // if apply successfully, return true
	{	
		double currAL = this.welfareInfo.getAnnualLeave();
		if (currAL - daysApplied >= 0){
			this.welfareInfo.setAnnualLeave(currAL - daysApplied);
			return true;
		}
			
		return false;
	}
	
}
