package itanalyst.jsontest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int alter;
    private List<Person> gehasstePersonen;

    public Person(String name, int alter, List<Person> gehasstePersonen) {
        this.name = name;
        this.alter = alter;
        this.gehasstePersonen = gehasstePersonen;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", gehasstePersonen=" + gehasstePersonen +
                '}';
    }
}
