/**
 * Created by roberto on 27/02/17.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex {

    private final int id;
    private List<Edge> edges = new ArrayList<>();

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean hasId(int id) {
        return this.id == id;
    }

    public void addEdge(Vertex dest, int weight) {
        edges.add(new Edge(dest, weight));
    }

    public Edge getEdgeByDestination(Vertex dest) {
        Edge a = null;
        Edge e;
        Iterator ite = edges.iterator();
        while (a == null && ite.hasNext()) {
            e = (Edge) ite.next();

            if (e.getDestination() == dest) {
                a = e;
            }
        }

        return a;
    }
}
