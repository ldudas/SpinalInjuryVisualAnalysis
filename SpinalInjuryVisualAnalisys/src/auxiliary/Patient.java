package auxiliary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ringChart.PatientOnChart;

public class Patient implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private Sex sex;
	private double weight;
	private double height;
	private InjuryLevel injuryLevel;
	private double strength;
	private double wnm;
	private String pesel;
	
	private PatientOnChart patientOnChart;
	
	
	public Patient(String pesel,String firstName, String lastName, Sex sex, double weight, double height, InjuryLevel injuryLevel,double strength, double wnm) 
	{
		this.pesel = pesel;
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

	public String getPesel()
	{
		return pesel;
	}

	public void setPesel(String pesel)
	{
		this.pesel = pesel;
	}

	@Override
	public String toString()
	{
		return firstName + " " + lastName;
	}
	
	public void serializeToFile(String path)
	{
		try
	      {
	         FileOutputStream fileOut =new FileOutputStream(path+pesel);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	
}
