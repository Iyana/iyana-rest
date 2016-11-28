package uk.co.iyana.rest.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ParamException.PathParamException;
import uk.co.iyana.commons.usererror.UserErrorMessage;

@Provider
public class PathParamExceptionMapper implements ExceptionMapper<PathParamException> {
    
    @Override 
    public Response toResponse(PathParamException t) {
 
//        // print it out
//        System.out.println("-----------------------");
//        t.printStackTrace();
//        System.out.println("-----------------------");
//        
        UserErrorMessage m = UserErrorMessage.getInvalidParameterMessage(t);
        
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(m)
            //.type(MediaType.APPLICATION_JSON)
            .build();    
    }
 
}