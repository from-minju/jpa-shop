package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("lombok");

        String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
        //helloLombok = HelloLombok(name=lombok, age=0)
        //@ToString 적용안했을 때 출력 : helloLombok = hello.core.HelloLombok@396a51ab
    }
}
