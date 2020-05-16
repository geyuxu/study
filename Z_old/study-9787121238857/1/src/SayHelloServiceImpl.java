/**
 * Created by geyuxu on 2017/7/11.
 */
public class SayHelloServiceImpl implements SayHelloService {
    public String sayHello(String helloArg) {
        if(helloArg.equals("hello")){
            return "hello";
        }else{
            return "bye bye";
        }
    }
}
