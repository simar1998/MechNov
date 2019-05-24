package api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Application setup.
 */
@ApplicationPath("/api")
public class ApplicationSetup extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(CORSFilter.class);
        set.add(TestAPI.class);
        set.add(CommandAPI.class);
        set.add(CommunicationAPI.class);
        return set;
    }
}
