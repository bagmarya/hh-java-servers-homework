import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Path("counter")
public class Counter{
    private static Integer counter = 0;


    @GET
    @Produces("application/json")
    public Response getCounter() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(new CounterInfo(counter));
        return Response.ok(jsonString).build();
    }

    @POST
    public Response post() {
        Counter.counter ++;
        return Response.ok().build();
    }

    @DELETE
    public Response delete(@HeaderParam("Subtraction-Value") String header) {
        counter -= Integer.parseInt(header);
        return Response.ok().build();
    }

    @POST
    @Path(value = "clear")
    public Response clear(@CookieParam("hh-auth") String cookie) {
        if (cookie != null && cookie.length() > 10) {
            Counter.counter = 0;
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    class CounterInfo{
        public String date;
        public Integer value;

        CounterInfo(Integer value){
            this.date = LocalDateTime.now().toString();
            this.value = value;
        }
    }




}
