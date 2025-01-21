package day03.task4;

public class WaitingDto {
	private int num;
	private String phone;
	private int people;
	
	public WaitingDto() {}

	public WaitingDto(int num, String phone, int people) {
		super();
		this.num = num;
		this.phone = phone;
		this.people = people;
	}

	@Override
	public String toString() {
		return "WaitingDto [num=" + num + ", phone=" + phone + ", people=" + people + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
