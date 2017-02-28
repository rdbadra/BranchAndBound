/**
 * Created by roberto on 27/02/17.
 */
public class Edge {

    private Vertex destination;
    private int weight;

    public Edge(Vertex next, int weight) {
        this.destination = next;
        this.weight = weight;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
