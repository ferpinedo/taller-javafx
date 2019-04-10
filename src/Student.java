public class Student {

  private String name;
  private String career;
  private String password;
  private String sex;
  private String controlNumber;

  public Student() {
  }

  public Student(String name, String career, String password, String sex,
      String controlNumber) {
    this.name = name;
    this.career = career;
    this.password = password;
    this.sex = sex;
    this.controlNumber = controlNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(String controlNumber) {
    this.controlNumber = controlNumber;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", career='" + career + '\'' +
        ", password='" + password + '\'' +
        ", sex='" + sex + '\'' +
        ", controlNumber='" + controlNumber + '\'' +
        '}';
  }
}
