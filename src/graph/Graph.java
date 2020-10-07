package graph;

import java.util.*;

public class Graph<T> {
        protected Map<T, List<T>> adjacencyMap;
        private T header;

        public Graph(){
                this.adjacencyMap = new HashMap<T, List<T>>();
        }

        public void addVertex(T value, List<T> adjacencies){
                //  Precondition --> adjacency list is valid
                this.adjacencyMap.put(value, adjacencies);
                this.header = value;
        }
        public void addVertex(T value){
                addVertex(value, new ArrayList<T>());
        }

        public void addAdjacencies(T value, T[] adjacencies){


                for (int i = 0; i < adjacencies.length; i++){
                        addAdjacency(value, adjacencies[i]);
                }

                //addAdjacency(value, adjacencies[0]);
        }
        public void addAdjacency(T value, T adjacency){
                if (hasAdjacency(value, adjacency)) return;
                if (adjacencyMap.containsKey(value) && adjacencyMap.containsKey(adjacency)) {
                        adjacencyMap.get(value).add(adjacency);
                        adjacencyMap.get(adjacency).add(value);
                }
        }


        public boolean hasAdjacency(T value, T adjacency){
                return adjacencyMap.get(value).contains(adjacency);
        }

        public List<T> getAdjacencies(T value){
                if (adjacencyMap.containsKey(value)) {
                        return adjacencyMap.get(value);
                } else return null;
        }

        public Set<T> getVertices(){
                return adjacencyMap.keySet();
        }

        public int size(){
                return adjacencyMap.size();
        }

        public String toString(){
                String str = "";
                for (T item: adjacencyMap.keySet()) {
                        str += "\n" + item + " " + adjacencyMap.get(item);
                }
                return str;
        }

        public void iBFTraversal(T value){
                Queue<T> nodesToProcess = new ArrayDeque<>();
                Set<T> visitedNodes = new HashSet<>();
                nodesToProcess.add(value);
                while (!nodesToProcess.isEmpty()){
                        T node = nodesToProcess.poll();
                        if (visitedNodes.contains(node)) continue;
                        visitedNodes.add(node);
                        System.out.println(node);
                        nodesToProcess.addAll(adjacencyMap.get(node));
                }
        }

}