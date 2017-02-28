/**
 * Created by roberto on 27/02/17.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private List<Vertex> nodes;
    private final HashMap<Integer, Vertex> dictionary;
    private int finalNode;

    public Graph() {

        this.dictionary = new HashMap(10);
        nodes = new ArrayList<>();
    }

    public int size(){
        return nodes.size();
    }

    public int getFinalNode(){
        return finalNode;
    }

    public void setFinalNode(int id){
        finalNode = id;
    }

    public List<Vertex> getNodes() {
        return nodes;
    }

    public HashMap<Integer, Vertex> getDictionary() {
        return dictionary;
    }

    public Vertex getRoot(){
        return nodes.get(0);
    }

    public void addVertex(int nodeId) {
        Vertex n = new Vertex(nodeId);
        this.nodes.add(n);
        this.dictionary.put(nodeId, n);
    }

    public void addEdge(int aVertexId, int bVertexId, int weight) {
        Vertex a = dictionary.get(aVertexId);
        Vertex b = dictionary.get(bVertexId);

        a.addEdge(b, weight);
        b.addEdge(a, weight);
    }

    public int getEdgeWeight(int aVertexId, int bVertexId) {
        Vertex a = dictionary.get(aVertexId);
        Vertex b = dictionary.get(bVertexId);

        return a.getEdgeByDestination(b).getWeight();
    }

    public void setEdgeWeight(int aVertexId, int bVertexId, int weight) {
        Vertex a = dictionary.get(aVertexId);
        Vertex b = dictionary.get(bVertexId);

        a.getEdgeByDestination(b).setWeight(weight);
    }

    public boolean isAdjacent(int aVertexId, int bVertexId) {
        Vertex a = dictionary.get(aVertexId);
        Vertex b = dictionary.get(bVertexId);

        return a.getEdgeByDestination(b) != null;
    }

    public List<Vertex> getNeighbors(int vertexId) {
        List<Vertex> ll = new LinkedList();
        Vertex v = dictionary.get(vertexId);
        List<Edge> le = v.getEdges();

        le.forEach((e) -> {
            if(e.getDestination().getId() != v.getId()){
                ll.add(e.getDestination());
            }
        });

        return ll;
    }
}
