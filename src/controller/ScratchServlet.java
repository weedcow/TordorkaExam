package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.StringParser;

import dao.*;
import model.*;

/**
 * Servlet implementation class Controller
 */

@WebServlet("/Controller")
public class ScratchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	
	String base = "/";
	String userPath = "Index.jsp";
	String url = userPath;
	RequestDispatcher rd = null;
	
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScratchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// TODO Auto-generated method stub
		System.out.println("Do Get");
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Do Post");
		response.setContentType("text/html");
		// Retrieve the current session, or create a new session if no session exist.
		
		// Action should be null initially.
		String action = request.getParameter("action");
		System.out.println("Request for action " + action);
		
		if(action != null)
		{
			switch(action)
			{
				case "getUsernames":
				
					userPath = "Index.jsp";
					getAllUsernames(request, response);
					break;
				
				case "getCars":
					userPath = "Index.jsp";
					getAllCars(request, response);
					break;
				case "logIn":
					userPath = "Index.jsp";
					logIn(request, response);
					break;
				case "createUser":
					userPath = "Index.jsp";
					createUser(request, response);
					break;
				case "cookieSearch":
				userPath = "Index.jsp";
				cookieSearch(request, response);
				break;
				case "buyCar":
				userPath = "Index.jsp";
				buyCar(request, response);
				break;
				case "returnCars":
					userPath = "Index.jsp";
					returnCars(request, response);
					break;
				case "returnSpecificCar":
					userPath = "Index.jsp";
					returnSpecificCar(request, response);
				break;
					
			}
		}
		
		url = base + userPath;
		System.out.println("rd to " + url);
		rd = context.getRequestDispatcher(url);
		rd.include(request, response);
	}
	
	

	private void returnSpecificCar(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
		{
			try
			{	
			DAO myDao = new DAOimpl();
			String carIdString = request.getParameter("carId");
			int carId = Integer.parseInt(carIdString);
			int userId = cookieSearch(request, response);
			if(userId != 1){
				request.setAttribute("logInResponse", "You are not the admin! STOP CHEATING!");
			}else{
				
		        	myDao.returnSpecificCar(carId);
			}
		}
		catch(Exception e)
		{
			System.out.println(e+"SERVLET ERROR");
		}
		
	}

	private void returnCars(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
		{
			try
			{	
				
				DAO myDao = new DAOimpl(); 
				List<Cars> cars = myDao.getCars();
				request.setAttribute("carslistAdmin", cars);

				System.out.println("getAllCarsADMIN" + cars.toString());
			}
			catch(Exception e)
			{
				System.out.println(e+"SERVLET ERROR");
			}
		}
		
	

	private void createUser(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		 if (username == null || username.length() == 0 ||password == null || password.length() == 0) {
	            url = "/index.jsp";
	            request.setAttribute("logInResponse", "Username & Password must not be empty.");
	        }
		 else{
				DAO myDao = new DAOimpl(); 
				Boolean loggedIn = myDao.createUser(username, password);
				if(loggedIn){
					request.setAttribute("logInResponse", "Success! Please log in!");
				}
		 }
		
	}

	private void getAllUsernames(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		try
		{		
			DAO myDao = new DAOimpl();
			List<Test> usernames = myDao.getUsernames();
			request.setAttribute("usernamelist", usernames);
			System.out.println("getAllUsernames" + usernames.toString());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private void getAllCars(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
		{
			try
			{		
				DAO myDao = new DAOimpl(); 
				List<Cars> cars = myDao.getCars();
				request.setAttribute("carslist", cars);

				System.out.println("getAllCars" + cars.toString());
			}
			catch(Exception e)
			{
				System.out.println(e+"SERVLET ERROR");
			}
		}
	private void logIn(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		try
		{	
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			 if (username == null || username.length() == 0 ||password == null || password.length() == 0) {
		            url = "/index.jsp";
		            request.setAttribute("logInResponse", "Username & Password must not be empty.");
		        }
			 else{
					DAO myDao = new DAOimpl(); 
					int loggedIn = myDao.logIn(username, password);
					if(loggedIn != 0){
						request.setAttribute("logInResponse", "Success!");
						PrintWriter writer2 = response.getWriter();
						writer2.println("Success!");
						setCookie(response, username, loggedIn);
						
					}
					else{
						PrintWriter writer2 = response.getWriter();
						writer2.println("not succes :(!");
					}
						 	}
			
					}
					catch(Exception e)
					{
						System.out.println(e+"SERVLET ERROR");
					}
					
				}
			public void setCookie( HttpServletResponse response, String username, int userId){
				Cookie loggedInUsername = new Cookie("loggedInUsername", username);
				String userIdString = userId+"";
				Cookie loggedInUserId = new Cookie("loggedInUserId", userIdString);
				loggedInUsername.setMaxAge(24*60*60);
				loggedInUserId.setMaxAge(24*60*60);
				response.addCookie(loggedInUsername);
				response.addCookie(loggedInUserId);
				System.out.println("Cooooookies I LOOOOOVE COOOKIES");
}
			
			public int cookieSearch(HttpServletRequest request, HttpServletResponse response) throws IOException{
				Cookie[] cookies = request.getCookies();
				String user = null; 
				int userId = 0;
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("loggedInUsername"))
					{
						user = cookie.getValue();
						System.out.println("User " + user +" is logged in!");
						PrintWriter writer3 = response.getWriter();
						writer3.println("LALALALALLALALLALALLALALALALALLALALLLAAAALIIIINE(!");
						
					}
					if((cookie.getName().equals("loggedInUserId"))){
						userId = Integer.parseInt(cookie.getValue());
						System.out.println("UserID is " + userId);
						
					}
					else{
						System.out.println("Cookie searcher found nothing here!");
					}
				}
				return userId;
			
			}
			public int cookieSearchNoView(HttpServletRequest request, HttpServletResponse response) throws IOException{
				Cookie[] cookies = request.getCookies();
				String user = null; 
				int userId = 0;
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("loggedInUsername"))
					{
						user = cookie.getValue();
						System.out.println("User " + user +" is logged in!");
						
					}
					if((cookie.getName().equals("loggedInUserId"))){
						userId = Integer.parseInt(cookie.getValue());
						System.out.println("UserID is " + userId);
						
					}
					else{
						System.out.println("Cookie searcher found nothing here!");
					}
				}
				return userId;
			}
			
			private void buyCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				// TODO Auto-generated method stub
				DAO myDao = new DAOimpl();
				String carIdString = request.getParameter("carId");
				int carId = Integer.parseInt(carIdString);
				System.out.println("CarId is " + carId);
				int userId = cookieSearchNoView(request, response);
				//is he logged in ? 
				if(userId != 0 ){
					Boolean buyCarSuccess = myDao.buyCar(carId, userId);
					getAllCars(request, response);
					System.out.println("User is logged in");
				}
				
			}

}
