package homework;

public class MemberDto {
	private int custno;
	private String custname;
	private String custphone;
	private String address;
	private String joindate;
	private String grade;
	private String city;
	private int salenol;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private String sdate;
	public MemberDto() {}
	public MemberDto(int custno, String custname, String custphone, String address, String joindate, String grade,
			String city, int salenol, int pcost, int amount, int price, String pcode, String sdate) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.custphone = custphone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
		this.salenol = salenol;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}
	
	@Override
	public String toString() {
		return "MemberDto [custno=" + custno + ", custname=" + custname + ", custphone=" + custphone + ", address="
				+ address + ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + ", salenol=" + salenol
				+ ", pcost=" + pcost + ", amount=" + amount + ", price=" + price + ", pcode=" + pcode + ", sdate="
				+ sdate + "]";
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustphone() {
		return custphone;
	}
	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalenol() {
		return salenol;
	}
	public void setSalenol(int salenol) {
		this.salenol = salenol;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
}
