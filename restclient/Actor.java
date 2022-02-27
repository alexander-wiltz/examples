package itanalyst.restclient;

public class Actor {
    public String name;
    public String height;
    public String gender;

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
