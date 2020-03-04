package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation2")
public class Reservation2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String room = request.getParameter("room");
		String date = request.getParameter("date");
		if(room != null) {
		
			String[] dates_openspace_theo = { "lundi", "mardi"};
			String[] dates_others = { "mercredi", "jeudi", "vendredi" };
			if(room.equals("openspace") || room.equals("theo"))
				request.setAttribute("datetime", dates_openspace_theo);
			else
				request.setAttribute("datetime", dates_others);
					
			this.getServletContext().getRequestDispatcher("/view JSP/reservation2DateTime.jsp").forward(request, response);
					
		}
		else if (date != null) {
							
			ArrayList<Integer> times = new ArrayList<Integer>();
			int n = 10;
			if(date.equals("lundi") || date.equals("mardi"))
				n = 5;
			for (int i = 0; i < n; i++) {
				times.add(i + 8);
			}
			request.setAttribute("datetime", times);			
			this.getServletContext().getRequestDispatcher("/view JSP/reservation2DateTime.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	public static void main(String[] args) {
		int[] arr = new int[11];
		for (int i = 0; i < 11; i++) {
			arr[i] = i + 8;
		}

		for (int item : arr) {
			System.out.print(item + " ");
		}
	}

}
