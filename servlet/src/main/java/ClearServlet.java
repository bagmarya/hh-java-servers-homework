import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String cookie = null;
        for (Cookie c : request.getCookies()) {
            if (c.getName().equals("hh-auth")) cookie = c.getValue();
        }
        if (cookie != null && cookie.length() > 10) {
            ServletApplication.counter = 0;
            response.setStatus(HttpStatus.OK_200);}
        else {
            response.setStatus(HttpStatus.UNAUTHORIZED_401);
        }

    }
}
