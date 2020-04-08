package interfaceandextend;

public class TeacherPojo extends CommonPojo {
private String firstName;
private String lastName;
private String phNumber;

public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhNumber() {
	return phNumber;
}
public void setPhNumber(String phNumber) {
	this.phNumber = phNumber;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

}
