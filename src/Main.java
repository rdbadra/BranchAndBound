public class Main {
    public static void main(String[] args) {
        ExampleGraphs graph = new ExampleGraphs();
        BranchAndBound branch = new BranchAndBound(graph.getSimpleGraph2());
        branch.run();
    }
}
