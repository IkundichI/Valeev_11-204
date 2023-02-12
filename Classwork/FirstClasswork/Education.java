package FirstClasswork;

public class Education {
	int year;
	String state;
	String type;
	String length;
	String expense;
	String value;

	public Education(int year, String state, String type, String length, String expense, String value) {
		this.year = year;
		this.state = state;
		this.type = type;
		this.length = length;
		this.expense = expense;
		this.value = value;
	}

	@Override
	public String toString() {
		return year + " " + state + " " + type + " " + length + " " + expense + " " + value;

	}
}
