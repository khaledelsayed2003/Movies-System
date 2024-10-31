package khaled_elsayed;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LinkedListNode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/// my code start from here :

	 private Cinema cinema;
	    private LinkedListNode next;

	    public LinkedListNode(Cinema cinema) {
	        this.cinema = cinema;
	        this.next = null;
	    }

	    public Cinema getCinema() {
	        return cinema;
	    }

	    public void setCinema(Cinema cinema) {
	        this.cinema = cinema;
	    }

	    public LinkedListNode getNext() {
	        return next;
	    }

	    public void setNext(LinkedListNode next) {
	        this.next = next;
	    }
	
	
}
