package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CookieServlet", urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = request.getCookies();
        int contador = 0;
        if (cookies !=null) {
            for (Cookie c:cookies) {
                if (c.getName().equals("CookieServlet")) {
                    contador = Integer.parseInt(c.getValue());
                    break;
                    
                }
                
            }
            
        }
        contador++;
        contador oookie = new Cookie("CookieServlet",Integer.toString(contador));
        Cookie.setMaxAge(120);
        response.addCookie(Cookie);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> contador de visitas</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p> el numero de visitas es:"+ contador);
        out.println("</body>");
        out.println("</html>");
        
        
        
        
    }

}
