package learn.restexpress;

import com.strategicgains.restexpress.RestExpress;
import org.jboss.netty.handler.codec.http.HttpMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by atif on 08/02/14.
 */
public class Hello {
    public static void main(String[] args) {
        RestExpress server = new RestExpress()
                .setName("Hello")
                .setPort(4444)
                .setExecutorThreadCount(10)
                .setIoThreadCount(10);



        HelloController controller = new HelloController();
        server.uri("/hello", controller).action("sayHello", HttpMethod.GET);
        server.uri("/test", controller).action("sayHello", HttpMethod.GET);
        server.uri("/create-user", controller).action("createUser", HttpMethod.GET);
        server.uri("/file-upload", controller).action("fileUploader", HttpMethod.POST);
        server.bind();


    }
}

