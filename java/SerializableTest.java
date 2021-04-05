import java.util.ArrayList;
import java.util.List;

public class SerializableTest {

    public static void main(String[] args)  throws Exception{
//        FileOutputStream fos = new FileOutputStream("work.out");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        Student student = new Student();
//        student.setId(1);
//        student.setName("williams");
//
//        oos.writeObject(student);
//
//        oos.flush();
//        oos.close();

//        FileInputStream fio = new FileInputStream("work.out");
//        ObjectInputStream ois = new ObjectInputStream(fio);
//        Student  student = (Student) ois.readObject();
//        System.out.println(student.getName());
//        ois.close();


        List<String> list = new ArrayList<>();
        for(int i = 0; i < 11 ; i++) {
            list.add(""+i);
        }
        System.out.println(list);
    }
}
