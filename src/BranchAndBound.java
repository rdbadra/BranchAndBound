import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by roberto on 27/02/17.
 */
public class BranchAndBound {
    private Graph graph;
    private OpenedList openedList;
    private ArrayList<Integer> visitedNodes = new ArrayList<>();
    private boolean end = false;
    private ArrayList<Vertex> trayectory = new ArrayList<>();

    public BranchAndBound(Graph graph) {
        this.graph = graph;
        this.openedList = new OpenedList();
        openedList.add(graph.getRoot(), 0, trayectory);
    }

    public ArrayList<Vertex> run() {
        while (end != true && openedList.size()!=0) {
            expandNextNode();
        }
        printTrayectory(trayectory);
        return trayectory;
    }

    private void expandNextNode() {
        VertexWithCost newVertexWithCost = openedList.remove();
        if (!isNodeFinal(newVertexWithCost.getVertex())) {
            visitedNodes.add(newVertexWithCost.getVertex().getId());
            List<Vertex> list = graph.getNeighbors(newVertexWithCost.getVertex().getId());
            for (int i = 0; i < list.size(); i++) {
                if (!isNodeVisited(list.get(i))) {
                    openedList.add(list.get(i), newVertexWithCost.getCost() +
                            graph.getEdgeWeight(newVertexWithCost.getVertex().getId(),
                                    list.get(i).getId()), newVertexWithCost.getTrayectory());
                }
            }
        } else {
            this.trayectory = newVertexWithCost.getTrayectory();
        }
    }

    private void printTrayectory(ArrayList<Vertex> tray) {
        System.out.println("ANSWER");
        int size = tray.size();
        for (int i = 0; i < size; i++) {
            System.out.println(tray.get(i).getId());
        }
    }

    //Funcion para comprobar si el nodo es objetivo
    private boolean isNodeFinal(Vertex vertex) {
        if (vertex.getId() == graph.getFinalNode()) {
            this.end = true;
            return true;
        }
        return false;
    }

    private boolean isNodeVisited(Vertex vertex) {
        int size = visitedNodes.size();
        for (int i = 0; i < size; i++) {
            if (visitedNodes.get(i) == vertex.getId()) return true;
        }
        return false;
    }
}
