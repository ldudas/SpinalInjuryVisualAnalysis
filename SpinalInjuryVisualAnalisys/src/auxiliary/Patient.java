package auxiliary;

import ringChart.PatientOnChart;

public class Patient 
{

	private String firstName;
	private String lastName;
	private Sex sex;
	private double weight;
	private double height;
	private InjuryLevel injuryLevel;
	private double strength;
	private double wnm;
	
	private PatientOnChart patientOnChart;
	
	
	public Patient(String firstName, String lastName, Sex sex, double weight, double height, InjuryLevel injuryLevel,double strength, double wnm) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.weight = weight;
		this.height = height;
		this.injuryLevel = injuryLevel;
		this.strength = strength;
		this.wnm = wnm;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public Sex getSex()
	{
		return sex;
	}
	public void setSex(Sex sex) 
	{
		this.sex = sex;
	}
	public double getWeight() 
	{
		return weight;
	}
	public void setWeight(double weight) 
	{
		this.weight = weight;
	}
	public double getHeight() 
	{
		return height;
	}
	public void setHeight(double height)
	{
		this.height = height;
	}
	public InjuryLevel getInjuryLevel() 
	{
		return injuryLevel;
	}
	public void setInjuryLevel(InjuryLevel injuryLevel) 
	{
		this.injuryLevel = injuryLevel;
	}
	public double getStrength() 
	{
		return strength;
	}
	public void setStrength(double strength) 
	{
		this.strength = strength;
	}
	public double getWnm() 
	{
		return wnm;
	}
	public void setWnm(double wnm) 
	{
		this.wnm = wnm;
	}

	public PatientOnChart getPatientOnChart()
	{
		return patientOnChart;
	}

	public void setPatientOnChart(PatientOnChart patientOnChart)
	{
		this.patientOnChart = patientOnChart;
	}
	
	
}
