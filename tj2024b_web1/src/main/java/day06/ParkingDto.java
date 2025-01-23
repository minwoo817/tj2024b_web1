package day06;


public class ParkingDto  {

	private int num;
	private String carnumber;
	private String carlocation;
	private String carin;
	private String carout;
	private String charge;
	
	
	public ParkingDto(int num, String carnumber, String carlocation, String carin, String carout, String charge) {
		super();
		this.num = num;
		this.carnumber = carnumber;
		this.carlocation = carlocation;
		this.carin = carin;
		this.carout = carout;
		this.charge = charge;
	}


	public ParkingDto() {
		
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getCarnumber() {
		return carnumber;
	}


	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}


	public String getCarlocation() {
		return carlocation;
	}


	public void setCarlocation(String carlocation) {
		this.carlocation = carlocation;
	}


	public String getCarin() {
		return carin;
	}


	public void setCarin(String carin) {
		this.carin = carin;
	}


	public String getCarout() {
		return carout;
	}


	public void setCarout(String carout) {
		this.carout = carout;
	}


	public String getCharge() {
		return charge;
	}


	public void setCharge(String charge) {
		this.charge = charge;
	}


	@Override
	public String toString() {
		return "ParkingDto [num=" + num + ", carnumber=" + carnumber + ", carlocation=" + carlocation + ", carin="
				+ carin + ", carout=" + carout + ", charge=" + charge + "]";
	}
	
	
	
}//c end
