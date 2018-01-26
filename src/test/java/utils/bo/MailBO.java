package utils.bo;

import static utils.data.TestData.ADDRESS;
import static utils.data.TestData.SUBJECT;

/**
 * Created by Katsiaryna_Skarzhyns on 1/24/2018.
 */
public class MailBO {

	private String address;
	private String subject;
	private String description;

	public MailBO(String address, String subject) {
		this.address = address;
		this.subject = subject;
	}

	public MailBO(String address, String subject, String description) {
		this.address = address;
		this.subject = subject;
		this.description = description;
	}

	public MailBO() {
		address = ADDRESS.getValue();
		subject = SUBJECT.getValue();
		description = SUBJECT.getValue();
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