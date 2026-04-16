import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String num1Param = request.getParameter("num1");
        String num2Param = request.getParameter("num2");
        String op = request.getParameter("op");

        String resultText = "";

        if (num1Param == null || num2Param == null || op == null
                || num1Param.trim().isEmpty() || num2Param.trim().isEmpty() || op.trim().isEmpty()) {
            resultText = "num1, num2, op 파라미터를 모두 입력하세요.";
        } else {
            try {
                int num1 = Integer.parseInt(num1Param);
                int num2 = Integer.parseInt(num2Param);
                int result = 0;
                boolean valid = true;

                switch (op) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            valid = false;
                            resultText = "0으로 나눌 수 없습니다.";
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        valid = false;
                        resultText = "지원하지 않는 연산자입니다: " + op;
                        break;
                }

                if (valid) {
                    resultText = num1 + " " + op + " " + num2 + " = " + result;
                }
            } catch (NumberFormatException e) {
                resultText = "num1과 num2는 정수여야 합니다.";
            }
        }

        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("    <meta charset=\"UTF-8\">\n")
                .append("    <title>Calc Servlet</title>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("    <h1>Calc Servlet</h1>\n")
                .append("    <p>계산 결과: " + resultText + "</p>\n")
                .append("</body>\n")
                .append("</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
