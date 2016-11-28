package uk.co.iyana.rest.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import uk.co.iyana.commons.usererror.UserErrorMessage;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {
    
    @Override 
    public Response toResponse(Throwable t) {
 
        // print it out
        System.out.println("-----------------------");
        t.printStackTrace();
        System.out.println("-----------------------");
        
        UserErrorMessage m = UserErrorMessage.getUnhandledExceptionMessage(t);
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(m)
            //.type(MediaType.APPLICATION_JSON)
            .build();    
    }
 
}