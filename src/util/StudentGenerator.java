package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Student;

public class StudentGenerator {

  public List<Student> getRandomStudents() {

    String[] nombres = {
        "Juan",
        "Pablo",
        "Carlos",
        "Roberto",
        "Josué",
        "Diego",
        "Sofía",
        "Víctor",
        "Eduardo",
        "Ana",
        "José",
        "Alejandro",
        "Fernando",
        "Helué",
        "Sergio",
        "María",
        "Elena",
    };

    String[] apellidos = {
        "Pérez",
        "Hernández",
        "Pinedo",
        "Vilchis",
        "Torres",
        "Santibañez",
        "Alvarado",
        "Becerra",
        "Escobedo",
        "Cruz",
        "Flores",
        "García",
        "Ramírez",
        "Salazar",
        "González",
        "Oyervides",
        "Iliná",
        "Cerda",
        "Orta",
        "Juárez",
        "Mandujano",
    };

    String[] carreras = {
        "Sistemas",
        "Mecatrónica",
        "Mecánica",
        "Gestión Empresarial",
        "Materiales",
        "Industrial",
        "Electrónica",
        "Eléctrica"
    };

    String[] sexos = {
        "Masculino",
        "Femenino",
    };



    Random rng = new Random();
    List<Student> students = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      Student student = new Student();
      student.setName(nombres[rng.nextInt(nombres.length)] + " " +
                      apellidos[rng.nextInt(apellidos.length)] + " " +
                      apellidos[rng.nextInt(apellidos.length)]
      );
      student.setPassword(i+rng.nextInt(922) + 1000 + "");
      student.setControlNumber(rng.nextInt(999) + 1805000 + "");
      student.setCareer(carreras[rng.nextInt(carreras.length)]);
      student.setSex(sexos[rng.nextInt(sexos.length)]);
      System.out.println(student);
      students.add(student);
    }

    return students;
  }

}
