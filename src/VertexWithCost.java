import java.util.ArrayList;

/**
 * Created by roberto on 27/02/17.
 */
public class VertexWithCost {
    private Vertex vertex;
    private int cost;
    private ArrayList<Vertex> trayectory;

    public VertexWithCost(Vertex vertex, int cost, ArrayList<Vertex> trayectory){
        this.trayectory = new ArrayList<>();
        this.vertex = vertex;
        this.cost = cost;
        fuseTrayectories(this.trayectory, trayectory);
        this.trayectory.add(vertex);
        print();
    }

    private void fuseTrayectories(ArrayList<Vertex> trayectory, ArrayList<Vertex> trayectory1) {
        int size = trayectory1.size();
        for (int i = 0; i < size ; i++){
            trayectory.add(trayectory1.get(i));
        }
    }

    private void print(){
        System.out.println("This is vertex "+vertex.getId()+" with cost: "+this.cost);
        System.out.println("TRAYECTORY");
        for (int i = 0; i < trayectory.size(); i++){
            System.out.println(trayectory.get(i).getId());
        }
    }

    public Vertex getVertex(){
        return vertex;
    }

    public int getCost(){
        return cost;
    }

    public void increaseCost(int additionalCost){
        this.cost += additionalCost;
    }

    public ArrayList<Vertex> getTrayectory(){
        return trayectory;
    }
}
