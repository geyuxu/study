import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by geyuxu on 2017/7/11.
 */
public class Consumer {
    public static void main(String[] args) {
        String interfacename = SayHelloService.class.getName();

        try {
            Method method = SayHelloService.class.getMethod("sayHello", String.class);


            Object[] arguments = {"hello"};

            Socket socket = null;

            socket = new Socket("127.0.0.1", 1234);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeUTF(interfacename);
            output.writeUTF(method.getName());
            output.writeObject(method.getParameterTypes());
            output.writeObject(arguments);

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Object result = input.readObject();

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
