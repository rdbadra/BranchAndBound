public class ExampleGraphs {

    public Graph getSimpleGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 5; i++) {
            g.addVertex(i);
        }

        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 3, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 4, 5);
        g.setFinalNode(4);
        // Peso minimo: 8

        return g;
    }

    public Graph getSimpleGraph2() {
        Graph g = new Graph();
        for (int i = 0; i < 7; i++) {
            g.addVertex(i);
        }

        g.addEdge(0, 1, 1); //Etapa 1
        g.addEdge(0, 2, 3); //Etapa 1
        g.addEdge(0, 3, 3); //Etapa 1
        g.addEdge(1, 4, 4); //Etapa 2
        g.addEdge(2, 4, 3); //Etapa 2
        g.addEdge(3, 4, 1); //Etapa 2
        g.addEdge(4, 5, 2); //Etapa 3
        g.addEdge(4, 5, 3); //Etapa 3
        g.addEdge(5, 6, 1); //Etapa 4
        g.setFinalNode(6);
        // Peso minimo: 7

        return g;
    }

    public Graph getComplexGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 6; i++) {
            g.addVertex(i);
        }

        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 6; j++) {
                g.addEdge(i, j, i + j);
            }
        }
        g.setFinalNode(6);
        // Peso minimo: 5 (Creo)

        return g;
    }

    public Graph getMultiSolGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 5; i++) {
            g.addVertex(i);
        }

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 3, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 4, 5);
        g.setFinalNode(4);
        // Peso minimo: 8

        return g;
    }

    public Graph getUnconnectedGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 5; i++) {
            g.addVertex(i);
        }

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 3, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
        g.setFinalNode(3);
        // Peso minimo: NaN

        return g;
    }

    public Graph getEmptyGraph() {
        return new Graph(); // Peso minimo: NaN
    }

    public Graph getNullGraph() {
        return null; // Peso minimo: NaN
    }
}
