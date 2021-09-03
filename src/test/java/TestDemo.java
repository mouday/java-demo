import com.mouday.Person;
import org.junit.Test;

import java.io.*;

public class TestDemo {
    @Test
    public void serialize() throws IOException {
        Person person = new Person();
        person.setAge(23);
        person.setName("Tom");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(
                        new File("person.txt")
                )
        );

        objectOutputStream.writeObject(person);
        objectOutputStream.close();
    }

    @Test
    public void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(
                        new File("person.txt")
                )
        );

        Person person = (Person)objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(person);
    //    Person{name='Tom', age=23}
    }
}
