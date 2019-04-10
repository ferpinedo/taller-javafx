public class Student {

  private String name;
  private String controlNumber;
  private String password;
  private String sex;
  private String career;


  public Student() {
  }

  public Student(String name, String controlNumber, String password, String sex,
      String career) {
    this.name = name;
    this.controlNumber = controlNumber;
    this.password = password;
    this.sex = sex;
    this.career = career;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(String controlNumber) {
    this.controlNumber = controlNumber;
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

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }


  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", controlNumber='" + controlNumber + '\'' +
        ", password='" + password + '\'' +
        ", sex='" + sex + '\'' +
        ", career='" + career + '\'' +
        '}';
  }
}
