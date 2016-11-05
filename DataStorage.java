package testInfo;

import java.util.*;

public class DataStorage {
	
	private static DataStorage instance = new DataStorage();
	private ArrayList <Employee> employeeDepository;
	private StatData appraisalStat;
	private StatData workingHourStat;
	
	private DataStorage()
	{
		this.employeeDepository = this.getEmployeeFileIO();
		this.appraisalStat = this.getAppraisalData();
		this.workingHourStat = this.getWorkingHourData();
	}
	
	
	public StatData getAppraisalData()
	{
		double [] appraisalArray = new double[this.employeeDepository.size()];
		int arrayIterator = 0;
		for (Employee employee: employeeDepository)
			appraisalArray[arrayIterator++] = employee.getAppraisal();
		return new StatData(appraisalArray);
	}
	
	public StatData getWorkingHourData()
	{
		double [] workingHourArray = new double[this.employeeDepository.size()];
		int arrayIterator = 0;
		for (Employee employee: employeeDepository)
			workingHourArray[arrayIterator++] = employee.getPerformanceInfo().getTotalWorkingHour();
		return new StatData(workingHourArray);
	}
	
	public Employee searchEmployee(String id)
	{
		for (Employee employee: employeeDepository)
		{
			if (id.equals(employee.getID()))
				return employee;
		}
		return null;
	}
	
	public Employee searchEmployee(int index)
	{
		return this.employeeDepository.get(index);
	}
	
	public StatData getAppraisalStat()
	{
		return this.appraisalStat;
	}
	
	public StatData getWorkingHourStat()
	{
		return this.workingHourStat;
	}
	
	public static DataStorage getInstance()
	{
		return instance;
	}
	
	public ArrayList<Employee> getEmployeeFileIO() // DATA INITIALISER REQUIRING CONCRETE IMPLEMENTATION
	{
		ArrayList <Employee> listEmployee = new ArrayList<>();
		for (int i = 0; i < 10; i++)
		{
			;
		}
		return listEmployee;
	}
}
