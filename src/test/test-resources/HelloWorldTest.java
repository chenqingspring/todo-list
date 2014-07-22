import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

public class HelloWorldTest {

    HelloWorld servlet;
    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter out;

    @Before
    public void setUp()throws Exception{
        servlet =new HelloWorld();
        out=mock(PrintWriter.class);
        request=mock(HttpServletRequest.class);
        when(request.getMethod()).thenReturn("GET");
        response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(out);


    }

   @Test
    public void doGetTest() throws Exception{
       servlet.service(request, response);
//       assertEquals("HelloWorld!", response.getOutputStream());
       verify(out, times(1)).println("<html>");
    }
}