package movie_project;

import java.util.HashMap;

public class MovieHashMap {
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
