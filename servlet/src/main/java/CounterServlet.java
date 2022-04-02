import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.eclipse.jetty.http.HttpStatus;

public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer = response.getWriter();
        response.setStatus(HttpStatus.OK_200);
        writer.print(ServletApplication.counter);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        ServletApplication.counter++;
        response.setStatus(HttpStatus.OK_200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response){
        Integer SubstrVal = Integer.parseInt(request.getHeader("Subtraction-Value"));
        ServletApplication.counter = ServletApplication.counter - SubstrVal;
        response.setStatus(HttpStatus.OK_200);
    }

}


