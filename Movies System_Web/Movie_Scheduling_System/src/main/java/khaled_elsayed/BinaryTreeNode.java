package khaled_elsayed;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BinaryTreeNode extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	/// my code start from here :
	  private Showing showing;
	    private BinaryTreeNode left;
	    private BinaryTreeNode right;

	    public BinaryTreeNode(Showing showing) {
	        this.showing = showing;
	        this.left = null;
	        this.right = null;
	    }

	    public Showing getShowing() {
	        return showing;
	    }

	    public void setShowing(Showing showing) {
	        this.showing = showing;
	    }

	    public BinaryTreeNode getLeft() {
	        return left;
	    }

	    public void setLeft(BinaryTreeNode left) {
	        this.left = left;
	    }

	    public BinaryTreeNode getRight() {
	        return right;
	    }

	    public void setRight(BinaryTreeNode right) {
	        this.right = right;
	    }
	
}
