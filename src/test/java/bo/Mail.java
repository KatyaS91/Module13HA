package bo;

/**
 * Created by Katsiaryna_Skarzhyns on 1/24/2018.
 */
public class Mail {

	private String address;
	private String subject;
	private String description;

	public Mail(String address, String subject) {
		this.address = address;
		this.subject = subject;
	}

	public Mail(String address, String subject, String description) {
		this.address = address;
		this.subject = subject;
		this.description = description;
	}

	public Mail() {
		address = "KatyaS91@mail.ru";
		subject = "test";
		description = "test";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}