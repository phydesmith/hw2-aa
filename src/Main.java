    import graph.Graph;
    import tree.*;

    public class Main {


    public static void main(String[] args){
        IntegerBST bst = new IntegerBST();
        bst.insert(12);
        bst.insert(3);
        bst.insert(15);
        bst.insert(1);
        bst.insert(4);
        bst.insert(14);
        bst.insert(16);
        System.out.println("\nQ1. Tree Leaf Sums");
        System.out.println(bst.toString());
        System.out.println("\nShould test true: ");
        System.out.println("Has Sum 43: " + bst.hasSum(43));
        System.out.println("Has Sum 41: " + bst.hasSum(41));
        System.out.println("Has Sum 19: " + bst.hasSum(19));
        System.out.println("Has Sum 15: " + bst.hasSum(16));

        System.out.println("\nShould test false: ");
        System.out.println("Has Sum 86: " + bst.hasSum(86));
        System.out.println("Has Sum -1: " + bst.hasSum(-1));
        System.out.println("Has Sum 0: " + bst.hasSum(0));
        System.out.println("Has Sum -43: " + bst.hasSum(-43));

        System.out.println("\nQ2. Graph Breadth First Traversal");
        Graph<String> graph = setupGraph();
        System.out.println("\nStart node: New York");
        graph.iBFTraversal("New York");

        System.out.println("\nStart node: Miami");
        graph.iBFTraversal("Miami");

    }

    public static Graph<String> setupGraph(){
        Graph<String> graph = new Graph<>();

        String[] cities = {"Dallas", "Phoenix", "New York", "Chicago", "Atlanta", "Miami", "Los Angeles"};
        for (int i = 0; i < cities.length; i++){
            graph.addVertex(cities[i]);
        }

        String[] adj1 = {"Dallas", "New York", "Chicago"};
        String[] adj2 = {"Phoenix", "Miami"};
        String[] adj3 = {"Chicago", "Phoenix"};
        String[] adj4 = {"New York"};
        String[] adj5 = {"Atlanta", "Miami"};
        String[] adj6 = {"Dallas"};
        String[] adj7 = {"Los Angeles"};

        graph.addAdjacencies(cities[0], adj2);
        graph.addAdjacencies(cities[1], adj1);
        graph.addAdjacencies(cities[2], adj3);
        graph.addAdjacencies(cities[3], adj4);
        graph.addAdjacencies(cities[4], adj6);
        graph.addAdjacencies(cities[5], adj7);
        graph.addAdjacencies(cities[6], adj5);


        return graph;
    }
}
