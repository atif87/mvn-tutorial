package learn.restexpress;

/**
 * Created by atif on 08/02/14.
 */
public class HelloController {
    public void sayHello(Request request, Response response) throws IOException {
        response.setBody("Hello "+request.getHeader("name"));
        response.setResponseStatus(HttpResponseStatus.OK);
    }
}

