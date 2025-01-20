package day03.task2;

public class WaitingDto {
	private String phone;
	private int people;
	public WaitingDto() {}
	public WaitingDto(String phone, int people) {
		super();
		this.phone = phone;
		this.people = people;
	}
	@Override
	public String toString() {
		return "WaitingDto [phone=" + phone + ", people=" + people + "]";
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
}
