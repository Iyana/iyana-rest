package uk.co.iyana.rest.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import uk.co.iyana.commons.usererror.UserErrorException;

@Provider
public class UserErrorsMapper implements ExceptionMapper<UserErrorException> {
    
    @Override 
    public Response toResponse(UserErrorException uee) {
 
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(uee.getUserErrors())
                //.type(MediaType.APPLICATION_JSON)
                .build();    
    }
 
}