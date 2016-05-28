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
import javax.websocket.Session;

import org.apache.catalina.User;
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
					userPath = "admin.jsp";
					returnCars(request, response);
					break;
				case "returnCarsReturn":
					userPath = "admin.jsp";
					returnCarsRerturn(request, response);
					break;
				case "returnUsers":
					userPath = "admin.jsp";
					returnUsers(request, response);
					break;
				case "returnSpecificCar":
					userPath = "Index.jsp";
					returnSpecificCar(request, response);
				break;
				case "createCar":
					userPath = "admin.jsp";
					createCar(request, response);
				break;
				case "updateCar":
					userPath = "admin.jsp";
					updateCar(request, response);
				break;
				case "deleteCar":
					userPath = "admin.jsp";
					deleteCar(request, response);
				break;
				case "updateUser":
					userPath = "admin.jsp";
					updateUser(request, response);
				break;
				case "deleteUser":
					userPath = "admin.jsp";
					deleteUser(request, response);
				break;
				case "logout":
					userPath = "Index.jsp";
					logout(request, response);
				break;
					
			}
		}
		
		url = base + userPath;
		System.out.println("rd to " + url);
		rd = context.getRequestDispatcher(url);
		rd.include(request, response);
	}
	
	

	

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		DAO myDao = new DAOimpl();
		if(myDao.deleteUser(userId))
		{
			System.out.println("success");
		}else
		{
			System.out.println("Error");
		}
		
		
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String level = request.getParameter("level");
		String deleted = request.getParameter("deleted");
		
		DAO myDao = new DAOimpl();
		if(myDao.updateUser(userId, username, password, firstName, lastName, phone, level, deleted, email))
		{
			System.out.println("success");
		}else
		{
			System.out.println("Error");
		}
	}

	private void deleteCar(HttpServletRequest request, HttpServletResponse response) {
		String carId = request.getParameter("carId");
		DAO myDao = new DAOimpl();
		if(myDao.deleteCar(carId))
		{
			System.out.println("success");
		}else
		{
			System.out.println("Error");
		}
		
	}

	private void updateCar(HttpServletRequest request, HttpServletResponse response) {
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String aircon = request.getParameter("aircon");
		String seats = request.getParameter("seats");
		String gear = request.getParameter("gear");
		String doors = request.getParameter("doors");
		String luggage = request.getParameter("luggage");
		String age = request.getParameter("age");
		String carId = request.getParameter("carId");
		String owner = request.getParameter("owner");
		String status = request.getParameter("status");
		String deleted = request.getParameter("deleted");
		
		DAO myDao = new DAOimpl();
		if(myDao.updateCar(model, brand, price, aircon, seats, gear, doors, luggage, age, owner, status, deleted, carId))
		{
			System.out.println("success");
		}else
		{
			System.out.println("Error");
		}
		
		
	}

	private void createCar(HttpServletRequest request, HttpServletResponse response) {
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String aircon = request.getParameter("aircon");
		String seats = request.getParameter("seats");
		String gear = request.getParameter("gear");
		String doors = request.getParameter("doors");
		String luggage = request.getParameter("luggage");
		String age = request.getParameter("age");
		
		DAO myDao = new DAOimpl();
		if(myDao.createCar(model, brand, price, aircon, seats, gear, doors, luggage, age)){
			System.out.println("Success");
		}
		else{
			System.out.println("Error");
		}
		
		
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
		
	private void returnCarsRerturn(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
			{
				try
				{	
					
					DAO myDao = new DAOimpl(); 
					List<Cars> cars = myDao.getCars();
					request.setAttribute("carslistAdminReturn", cars);

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
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		
		 if (username == null || username.length() == 0 ||password == null || password.length() == 0) {
	            url = "/index.jsp";
	            request.setAttribute("logInResponse", "Username & Password must not be empty.");
	        }
		 else{
				DAO myDao = new DAOimpl(); 
				Boolean loggedIn = myDao.createUser(username, password,email,firstName,lastName,phone);
				if(loggedIn){
					request.setAttribute("logInResponse", "Success! Please log in!");
				}
		 }
		
	}

	private void returnUsers(HttpServletRequest request, HttpServletResponse response) {
		DAO myDao = new DAOimpl();
		List<Test> users = myDao.getUsernames();
		request.setAttribute("userlist", users);
		
	}
	
	private void getAllUsernames(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		try
		{		
			DAO myDao = new DAOimpl();
			List<Test> usernames = myDao.getUsernames();
			request.setAttribute("usernamelist", usernames);
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
					Test loggedIn = myDao.logIn(username, password);
					if(loggedIn != null){
						// setting session
						request.setAttribute("logInResponse", "Success!");
						HttpSession session = request.getSession();
						session.setAttribute("user", loggedIn);
						
						// check for admin
						if(loggedIn.getLevel() == 1)
						{
							response.sendRedirect("/javaScratch55/admin.jsp");
							// redirect admin
							
						}else
						{ 
							PrintWriter writer2 = response.getWriter();
							setCookie(response, username, loggedIn.getID());
						}
						
						
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
				int carId = Integer.parseInt(request.getParameter("carId"));
				System.out.println(carId);
				HttpSession session = request.getSession();
				if(session.getAttribute("user") == null)
				{
					System.out.println("Session not set");
				}else
				{
					System.out.println("session set!");
					Test user = (model.Test) session.getAttribute("user");
					int userId = user.getID();
					System.out.println(userId);
					
					// DAO
					
					DAO myDao = new DAOimpl();
					myDao.buyCar(carId, userId);
					getAllCars(request, response);
				}
			}
			
			private void logout(HttpServletRequest request, HttpServletResponse response) {
				HttpSession session = request.getSession();
				session.invalidate();
			}

}
