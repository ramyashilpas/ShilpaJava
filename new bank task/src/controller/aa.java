package controller;

public class aa {
	private int C_Id;
	private String Cname;
	private String Address;
	private String  PhoneNo;
	private String email;
	private int A_Id;
	private String  Acc_Type;
	private String   branch;
	private int t_Id;
	private String   Amount;
	private String Tr_Type;
	
	
	public int getC_Id() {
		return C_Id;
	}
	public void setC_Id(int c_Id) {
		C_Id = c_Id;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getA_Id() {
		return A_Id;
	}
	public void setA_Id(int a_Id) {
		A_Id = a_Id;
	}
	public String getAcc_Type() {
		return Acc_Type;
	}
	public void setAcc_Type(String acc_Type) {
		Acc_Type = acc_Type;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getT_Id() {
		return t_Id;
	}
	public void setT_Id(int t_Id) {
		this.t_Id = t_Id;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getTr_Type() {
		return Tr_Type;
	}
	public void setTr_Type(String tr_Type) {
		Tr_Type = tr_Type;
	}
	
	
	private String damount;
	private String wamount;


	public String getDamount() {
		return damount;
	}
	public void setDamount(String damount) {
		this.damount = damount;
	}
	public String getWamount() {
		return wamount;
	}
	public void setWamount(String wamount) {
		this.wamount = wamount;
	}
	@Override
	public String toString() {
		return "aa [C_Id=" + C_Id + ", Cname=" + Cname + ", Address=" + Address + ", PhoneNo=" + PhoneNo + ", email="
				+ email + ", A_Id=" + A_Id + ", Acc_Type=" + Acc_Type + ", branch=" + branch + ", t_Id=" + t_Id
				+ ", Amount=" + Amount + ", Tr_Type=" + Tr_Type + ", damount=" + damount + ", wamount=" + wamount + "]";
	}
	
}
