package utils.data;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public enum  TestData {

	URL("https://mail.google.com"),
	LOGIN("berezhkov.agm@gmail.com"),
	PASSWORD("berezhkovMm8"),
	ADDRESS("KatyaS91@mail.ru"),
	SUBJECT("test");

	private String value;

	TestData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}