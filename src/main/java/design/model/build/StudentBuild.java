package design.model.build;

public class StudentBuild {

    public static Student buildA(String name, int age) {
        Student student = new Student();
        Like like = new Like();
        student.setLike(like);

        student.setName(name);
        student.setAge(age);
        return student;
    }

    public static Student buildB(String name, int age,Address address) {
        Student student = new Student();
        student.setAddress(address);
        Like like = new Like();
        student.setLike(like);
        student.setName(name);
        student.setAge(age);
        return student;
    }
}
