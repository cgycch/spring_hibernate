package com.cch.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(
		description = "init test", 
		loadOnStartup = 9,
		urlPatterns = { "/InitServlet" }, 
		initParams = { 
				@WebInitParam(name = "arg0", value = "123", description = "arg one test"), 
				@WebInitParam(name = "arg1", value = "asd", description = "arg two test")
		})
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InitServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String env = System.getenv("env");
		String pro = System.getProperty("envp");
		String pro2 = System.getProperty("FAW.ServiceFor");
		System.out.println("env= "+ env);
		System.out.println("pro2= "+ pro2);
		System.out.println("pro= "+ pro);
	}

}
