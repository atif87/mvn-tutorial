package learn.restexpress;

import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by atif on 08/02/14.
 */
public class HelloController {

    public void sayHello(Request request, Response response) throws IOException {
        response.setBody("Hello "+request.getHeader("name"));
        response.setResponseStatus(HttpResponseStatus.OK);
    }
    public void createUser(Request request, Response response) throws IOException
    {
        //response.setBody("Hello "+request.getHeader("name"));
        //response.setResponseStatus(HttpResponseStatus.OK);
        System.out.println("atif iqbal");
        try
        {
            String host = "jdbc:mysql://localhost:3306/java_testing";
            String uName = "root";
            String uPass= "";
            Connection conn = DriverManager.getConnection(host,uName, uPass);
            String username =  request.getHeader("uname");
            String password = request.getHeader("password");
            int token = (int)Math.random();
            Statement stmt;
            stmt = conn.createStatement();
            stmt.executeUpdate("insert into users (username,password,token) values('"+username+"','"+password+"','"+token+"')");
            response.setBody("Hello "+ username + "is created");
            response.setResponseStatus(HttpResponseStatus.OK);
        } catch(SQLException ex){
            System.out.println("atif iqbal");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
    public void fileUploader(Request request, Response response) throws IOException
    {

        //response.addHeader("X-Client-ID", "xyz345");
        //System.out.print(response.getHeaderNames());
        //System.out.print(request.getHeader("test"));

        System.out.print(request.getHeader("name"));
        System.out.print("\n");
        System.out.print(request.getHeader("filedata"));
        System.out.print("\n");
        //response.setBody("Hello " + request.getQueryStringMap());
        //System.out.print(response.getContentType());
        //response.setBody("Hello "+request.getHeader("name"));
        //response.setResponseStatus(HttpResponseStatus.OK);
        //System.out.println("atif iqbal");
    }
}

