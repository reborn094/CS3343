package testInfo;

import java.util.Arrays;

public class StatData {
	
	private double lq;
	private double median;
	private double uq;
	
	public StatData(double lq, double median, double uq)
	{
		this.lq = lq;
		this.median = median;
		this.uq = uq;
	}
	
	public StatData(double [] rawData)
	{
		Arrays.sort(rawData);
		this.lq = rawData[(int) (rawData.length * 0.25)];
		this.median = rawData[(int) (rawData.length * 0.5)];
		this.uq = rawData[(int) (rawData.length * 0.75)];
	}
	
	public double getLQ()
	{
		return this.lq;
	}
	
	public double getMedian()
	{
		return this.median;
	}
	
	public double getUQ()
	{
		return this.uq;
	}
	
}
