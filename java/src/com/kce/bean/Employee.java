package com.kce.bean;

public class Employee {
	private int eid;
	private String ename;
	private String egender;
	private String pnum;
	private String email;
	private String edesignation;
	private String esalary;
	
	public Employee(int eid, String ename, String egender, String pnum, String email, String edesignation,
			String esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.egender = egender;
		this.pnum = pnum;
		this.email = email;
		this.edesignation = edesignation;
		this.esalary = esalary;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEgender() {
		return egender;
	}

	public void setEgender(String egender) {
		this.egender = egender;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEdesignation() {
		return edesignation;
	}

	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		return "Employee [ Employee ID = " + eid + ", Employee Name = " + ename + ", Gender = " + egender + ", Phone Number = "
	+ pnum + ", Email ID = " + email + ", Designation = " + edesignation + ", Salary = " + esalary + " ]";
	}
	
}
