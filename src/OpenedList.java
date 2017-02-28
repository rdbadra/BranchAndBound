import java.util.ArrayList;

/**
 * Created by roberto on 27/02/17.
 */
public class OpenedList {
    private ArrayList<VertexWithCost> openedList;
    private ArrayList<VertexWithCost> visitedNodes;

    public OpenedList() {
        openedList = new ArrayList<>();
        visitedNodes = new ArrayList<>();
    }

    public int size() {
        return openedList.size();
    }

    private boolean isAlreadyInList(Vertex vertex, int cost, ArrayList<Vertex> trayectory) {
        int size = this.size();
        for (int i = 0; i < size; i++) {
            if (openedList.get(i).getVertex().getId() == vertex.getId()) {
                if(isSameTrayectory(trayectory)){
                    if (openedList.get(i).getCost() == cost) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isSameTrayectory(ArrayList<Vertex> trayectory) {
        ArrayList<Vertex> listTrayectory;
        for (int i = 0; i < openedList.size(); i++) {
            listTrayectory = openedList.get(i).getTrayectory();
            if (checkTrayectories(listTrayectory, trayectory)) return true;
        }
        return false;
    }

    private boolean checkTrayectories(ArrayList<Vertex> listTrayectory, ArrayList<Vertex> trayectory) {
        if(listTrayectory.size() != trayectory.size()) return false;
        int count = trayectory.size();
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                if(listTrayectory.get(i).getId() == trayectory.get(j).getId()) count--;
                if(count == 0) return true;
            }
        }
        return false;
    }

    public boolean add(Vertex vertex, int cost, ArrayList<Vertex> trayectory) {
        if (!isAlreadyInList(vertex, cost, trayectory)) {
            int size = openedList.size();
            for (int i = 0; i < size; i++) {
                if (cost < openedList.get(i).getCost()) {
                    openedList.add(i, new VertexWithCost(vertex, cost, trayectory));
                    return true;
                }
            }
            openedList.add(new VertexWithCost(vertex, cost, trayectory));
            return true;
        }
        return false;
    }

    public VertexWithCost remove() {
        return openedList.remove(0);
    }

    public void print() {
        System.out.println("OPENED LIST");
        int size = openedList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(openedList.get(i).getCost());
        }
    }
}
