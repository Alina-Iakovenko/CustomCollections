package collections;

public class MyTestClass implements Comparable<MyTestClass>{
    String object;

    public MyTestClass() {
        this.object = "testClassObject";
    }

    public MyTestClass(String object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return object;
    }

    @Override
    public int compareTo(MyTestClass other) {
        if (other == null) {
            return 1;
        }
        return this.object.compareTo(other.object);
    }
}
