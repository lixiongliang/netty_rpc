package design.model.build;

public class Client {
    public static void main(String[] args) {

        Student student1 =  StudentBuild.buildA("zhanshang",20);
        Student student2 =  StudentBuild.buildB("lisi",30,
                new Address());

        System.out.println("="+student1.toString());
        System.out.println("="+student2.toString());

    }
}
