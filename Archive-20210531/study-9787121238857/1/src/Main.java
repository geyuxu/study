import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Person p = new Person();
        p.setName("xiao qiang");
        p.setAge(22);

        byte[] text = null;
        try {
            text = objectToByte(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0;i<text.length;i++){
            System.out.print(text[i]);
        }


    }

    private static byte[] objectToByte(Object o) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(os);

        out.writeObject(o);
        byte[] result = os.toByteArray();

        return result;
    }
}

