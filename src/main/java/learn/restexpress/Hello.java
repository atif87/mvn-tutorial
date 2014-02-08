package learn.restexpress;

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
        server.uri("/hello", controller)
        .action("sayHello", HttpMethod.GET);
        server.bind();

    }
}

