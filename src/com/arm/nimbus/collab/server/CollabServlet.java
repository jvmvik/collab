package com.arm.nimbus.collab.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CollabServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		TaskService.initDB();
		//out.println("[{title:\"hello\", author:\"vicben01\"}]");
		out.println(TaskService.list());
		out.flush();
	}
}
