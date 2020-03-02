package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/mult")
public class rServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Integer tmp;
        try {
            String tmp0 = request.getParameter("value");

            if(tmp0 == null) {
                throw new Exception();
            }

            if(tmp0.isEmpty()){
                throw new Exception();
            }

            String tmp00 = tmp0.trim();
            tmp = Integer.parseInt(tmp00);

            Integer intFromReturn = (tmp * 2);
            String intFromReturnS = Integer.toString(intFromReturn);
            String htmlResponse = intFromReturnS;
            PrintWriter writer = response.getWriter();
            try {
                writer.println(htmlResponse);
            }
            finally {
                writer.close();
            }

            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        }
        catch (Exception e) {
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            PrintWriter writer = response.getWriter();
            try {
                writer.println(0);
            }
            finally {
                writer.close();
            }
        }
    }
}
