package khaled_elsayed;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


public class Showing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/// my code start from here :

	  private LocalDateTime dateTime;
	    private Cinema cinema;

	    public Showing(LocalDateTime dateTime, Cinema cinema) {
	        this.dateTime = dateTime;
	        this.cinema = cinema;
	    }

	    public LocalDateTime getDateTime() {
	        return dateTime;
	    }

	    public void setDateTime(LocalDateTime dateTime) {
	        this.dateTime = dateTime;
	    }

	    public Cinema getCinema() {
	        return cinema;
	    }

	    public void setCinema(Cinema cinema) {
	        this.cinema = cinema;
	    }
}
