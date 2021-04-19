import javax.naming.event.ObjectChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by geyuxu on 2017/7/11.
 */
public class Provider {
    public static void main(String[] args) {
        Map<String,Object> services = new HashMap<String, Object>();

        services.put("SayHelloService",new SayHelloServiceImpl());

        try {
            ServerSocket server = new ServerSocket(1234);

            while (true){
                Socket socket = server.accept();
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

                String interfacename = is.readUTF();
                String methodName = is.readUTF();
                Class<?>[] parameterTypes = (Class<?>[])is.readObject();
                Object[] arguments = (Object[])is.readObject();

                Class serviceinterfaceclass = Class.forName(interfacename);
                Object service = services.get(interfacename);
                Method method = serviceinterfaceclass.getMethod(methodName,parameterTypes);
                Object result = method.invoke(service,arguments);

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
