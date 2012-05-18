package com.arm.nimbus.collab.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * TODO description
 *
 * @creator victor
 */
public class AuthServlet extends HttpServlet {

    Logger log = Logger.getLogger(AuthServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        log.info("session.username = " + session.getAttribute("username"));
        if(request.getRequestURI().equals("/auth/login")){
            session.setAttribute("username", request.getParameter("username"));
            success(response, "{status:0, data:{username="+session.getAttribute("username")+"}}");
        }
        else if(request.getRequestURI().equals("/auth/logout"))
        {
            session.invalidate();
            success(response, "{status:0, message:'bye bye..'}");
        }else{
            fail(response);
        }
    }

    private void success(HttpServletResponse response, String json) throws IOException {
        // Send back response
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();

    }
    private void fail(HttpServletResponse response) throws IOException {
        response.setStatus(401);
        PrintWriter out = response.getWriter();
        out.print("{status:1, message:'unknow url, expected : /auth/login?username=value or /auth/logout'}");
        out.flush();
    }
}
