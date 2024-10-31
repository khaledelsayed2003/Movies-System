package khaled_elsayed;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public class MovieHashMap extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	/// my code start from here :
	
	 private HashMap<String, BinaryTreeNode> map;

	    public MovieHashMap() {
	        this.map = new HashMap<>();
	    }

	    public HashMap<String, BinaryTreeNode> getMap() {
	        return map;
	    }

	    public void setMap(HashMap<String, BinaryTreeNode> map) {
	        this.map = map;
	    }

	    public void addMovie(String movieName, BinaryTreeNode rootNode) {
	        map.put(movieName, rootNode);
	    }

	    public BinaryTreeNode getMovie(String movieName) {
	        return map.get(movieName);
	    }

	    public void removeMovie(String movieName) {
	        map.remove(movieName);
	    }
	
	
	
}
