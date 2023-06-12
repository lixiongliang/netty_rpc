package design.model.build;

import lombok.Builder;
import lombok.Data;

@Data
public class Student {

    private String name;
    private int age;

    private Address address;
    private Classs classs;
    private Like like;

}
