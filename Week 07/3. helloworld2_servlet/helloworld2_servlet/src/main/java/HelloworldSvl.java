import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "First HelloWorld Servlet", urlPatterns = {"/hello2"})
public class HelloworldSvl extends HttpServlet {
    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalDateTime now = LocalDateTime.now();

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("    <meta charset=\"UTF-8\">\n")
                .append("    <title>Hello World Servlet</title>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("    <h1>Hello World Servlet</h1>\n")
                .append("    <p>현재 날짜와 시간: " + now.format(DATE_TIME_FORMAT) + "</p>\n")
                .append("</body>\n")
                .append("</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
