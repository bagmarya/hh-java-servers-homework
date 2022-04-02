import javax.ws.rs.core.Application;
import java.util.Set;

public class CounterApp extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        return Set.of(Counter.class);
    }
}
