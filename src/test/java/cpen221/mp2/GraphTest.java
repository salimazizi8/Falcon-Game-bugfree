package cpen221.mp2;

import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.Vertex;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testCreateGraph() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);

        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);

        assertEquals(e2, g.getEdge(v2, v3));
        assertEquals(21, g.pathLength(g.shortestPath(v3, v4)));    }

    @Test
    public void addVertex() {
        Vertex v1 = new Vertex(5, "K");
        Vertex v2 = new Vertex(10, "G");
        //  Graph<V extends Vertex, E extends Edge<V>>
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        assertEquals(true, g.addVertex(v1));
        assertEquals(true, g.addVertex(v2));
        assertEquals(false, g.addVertex(v1));
        assertEquals(false, g.addVertex(v2));
        // No two vertices in the same graph should have the same ID
        Vertex v3 = new Vertex(10, "GB");
        Vertex v4 = new Vertex(6, "k");
        assertEquals(true, g.addVertex(v3)); // same ID but different name, hence true
        assertEquals(true, g.addVertex(v4)); // same name but different ID.

        Vertex v6 = new Vertex(5, "K"); // same ID and same Name
        assertEquals(false, g.addVertex(v6));
    }

    @Test
    public void vertex() {
        Vertex v1 = new Vertex(5, "tp");
        Vertex v2 = new Vertex(90, "b");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>(); // an instance of Graph ADT
        g.addVertex(v1);
        assertEquals(true, g.vertex(v1));
        assertEquals(false, g.vertex(v2));
    }

    @Test
    public void addEdge() {
        Vertex v1 = new Vertex(5, "v");
        Vertex v2 = new Vertex(10, "n");
        Vertex v3 = new Vertex(1, "b");
        Vertex v4 = new Vertex(4, "c");

        Edge<Vertex> e1 = new Edge<>(v4, v2, 3);

        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);

        // If only one of the Vertices of the added Edge exists in the Graph, return false;
        // Both vertices of the added Edge should exist in the Graph.
        assertEquals(false, g.addEdge(e1));

        // If the two vertices of the added Edge do not exist in the Graph
        Vertex v10 = new Vertex(16, "v");
        Vertex v11 = new Vertex(11, "c");
        Edge<Vertex> e2 = new Edge<>(v10, v11);
        assertEquals(false, g.addEdge(e2));


        Vertex v6 = new Vertex(78, "cx");
        Vertex v7 = new Vertex(88, "a");
        g.addVertex(v6);
        g.addVertex(v7);

        // If both Vertices of the added Edge already exist in the Graph:
        Edge<Vertex> e3 = new Edge<>(v6, v7, 10);
        assertEquals(true, g.addEdge(e3));

        // adding an already existing edge with a different length:
        Edge<Vertex> e10 = new Edge<>(v6, v7, 11);
        assertEquals(false, g.addEdge(e10));
    }

    @Test
    public void edge1() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 7);

        Edge<Vertex> e5 = new Edge<>(v2, v3, 8);
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(e1);


        assertEquals(false, g.edge(e2));
        assertEquals(true, g.edge(e1));
    }

    @Test
    // public boolean edge(V v1, V v2);
    public void edge2() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 7);

        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        // first add v1 and v2 into the Graph:
        g.addVertex(v1);
        g.addVertex(v2);
        // Now add the connection between v1 and v2:
        g.addEdge(e1);

        assertEquals(true, g.edge(v1, v2));
        assertEquals(true, g.edge(v2, v1)); // still should be true

        g.addVertex(v3);
        assertEquals(false, g.edge(v2, v3));
        // V2 and V3 exist in the graph but they are not connected.
        g.addVertex(v2);
        assertEquals(false, g.edge(v2, v3));
    }

    @Ignore
    public void edge3() {
        Vertex v1 = new Vertex(1, "F");
        Vertex v2 = new Vertex(2, "C");
        Vertex v3 = new Vertex(3, "B");
        Vertex v4 = new Vertex(4, "D");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 3);
        Edge<Vertex> e2 = new Edge<>(v3, v4);

        Graph<Vertex, Edge<Vertex>> g = new Graph<>();

    }


    @Test
    //public E getEdge(V v1, V v2);
    public void getEdge() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v1);
        Edge<Vertex> e1 = new Edge<>(v3, v4, 3);
        g.addEdge(e1);

        assertEquals(e1, g.getEdge(v3, v4));
        assertEquals(null, g.getEdge(v1, v4));
        assertEquals(null, g.getEdge(v2, v3));
    }

    @Test
    //public int edgeLength(V v1, V v2);
    public void edgeLength() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        g.addEdge(e1);

        // Vertices exist and are connected:
        assertEquals(5, g.edgeLength(v1, v2));

        // Vertices exist but since no connection, return length 0.
        assertEquals(0, g.edgeLength(v2, v3));

        // Vertices do not exist:
        assertEquals(0, g.edgeLength(v4, v3));

        Edge<Vertex> e2 = new Edge<>(v3, v2, 15);
        g.addEdge(e2);
        assertEquals(15, g.edgeLength(v2, v3));

        // Edge with length 1 which is the default:
        g.addVertex(v4);
        Edge<Vertex> e3 = new Edge<>(v3, v4);
        g.addEdge(e3);
        assertEquals(1, g.edgeLength(v3, v4));
    }

    @Test
    public void edgeLengthSum1() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 10);
        Edge<Vertex> e3 = new Edge<>(v1, v3, 50);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);

        assertEquals(5 + 10 + 50, g.edgeLengthSum());
    }

    // Tests if there is no Edge:
    @Test
    public void edgeLengthSum2() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 10);
        Edge<Vertex> e3 = new Edge<>(v1, v3, 50);

        assertEquals(0, g.edgeLengthSum());

        g.addEdge(e3);
        assertEquals(50, g.edgeLengthSum());
    }

    @Test
    // Remove an Edge from the Graph:
    public void remove1() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Vertex v5 = new Vertex(5, "E");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 10);
        Edge<Vertex> e3 = new Edge<>(v3, v4, 50);
        Edge<Vertex> e4 = new Edge<>(v4, v5, 60);
        Edge<Vertex> e5 = new Edge<>(v1, v5, 70);
        Edge<Vertex> e6 = new Edge<>(v2, v5, 80 );
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);

        assertEquals(true, g.remove(e4));
        // Edge e6 does not exist in the graph:
        assertEquals(false, g.remove(e6));

        g.addEdge(e6);
        assertEquals(true, g.remove(e6));
    }

    @Test
    // Remove a Vertex from the Graph:
    public void remove2() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        Edge<Vertex> e1 = new Edge<>(A, C);
        Edge<Vertex> e2 = new Edge<>(A, B);
        Edge<Vertex> e3 = new Edge<>(B, C);
        Edge<Vertex> e4 = new Edge<>(C, D);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        assertEquals(true, g.remove(C));
        assertEquals(true, g.remove(D)); // Currently, D is not connected to anyting
        // C should already have been removed, hence false:
        assertEquals(false, g.remove(C));
    }

    @Test
    public void allVertices() {
        Set<Vertex> all = new HashSet<>();
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        Edge<Vertex> e1 = new Edge<>(A, C);
        Edge<Vertex> e2 = new Edge<>(A, B);
        Edge<Vertex> e3 = new Edge<>(B, C);
        Edge<Vertex> e4 = new Edge<>(C, D);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        all.add(A);
        all.add(B);
        all.add(C);
        all.add(D);
      //  Vertex[] allArray = (Vertex[]) all.toArray();
        assertEquals(all, g.allVertices());

        // Empty Graph:
        Graph<Vertex, Edge<Vertex>> emptyGraph = new Graph<>();
        assertEquals(new HashSet<>(), emptyGraph.allVertices());

        // One Element Graph:
        Graph<Vertex, Edge<Vertex>> oneElementGraph = new Graph<>();
        oneElementGraph.addVertex(D);
        Set<Vertex> oneElementSet = new HashSet<>();
        oneElementSet.add(D);
        assertEquals(oneElementSet, oneElementGraph.allVertices());
    }

    @Test
    //  * Obtain a set of all vertices incident on v.
    public void allEdges1() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Vertex K = new Vertex(5, "K");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        Edge<Vertex> e1 = new Edge<>(A, C);
        Edge<Vertex> e2 = new Edge<>(A, B);
        Edge<Vertex> e3 = new Edge<>(B, C);
        Edge<Vertex> e4 = new Edge<>(C, D);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        Set<Edge> set_B = new HashSet<>();
        set_B.add(e2);
        set_B.add(e3);
        assertEquals(set_B, g.allEdges(B));

        Set<Edge> set_A = new HashSet<>();
        set_A.add(e1);
        set_A.add(e2);
        assertEquals(set_A, g.allEdges(A));

        // Vertex K is not part of the Graph:
        assertEquals(new HashSet<>(), g.allEdges(K));
    }

    @Test
    // Obtain a set of all edges in the graph.
    // public Set<E> allEdges();
    public void allEdges2() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Vertex K = new Vertex(5, "K");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        Edge<Vertex> e1 = new Edge<>(A, C);
        Edge<Vertex> e2 = new Edge<>(A, B);
        Edge<Vertex> e3 = new Edge<>(B, C);
        Edge<Vertex> e4 = new Edge<>(C, D);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        Set<Edge> setOfAll = new HashSet<>();
        setOfAll.add(e1);
        setOfAll.add(e2);
        setOfAll.add(e3);
        setOfAll.add(e4);

        assertEquals(setOfAll, g.allEdges());
        // Empty Graph:
        Graph<Vertex, Edge<Vertex>> emptyGraph = new Graph<>();
        assertEquals(new HashSet<>(), emptyGraph.allEdges());
    }

    @Test
    public void getNeighbours() {
        Map<Vertex, Edge<Vertex>> map1 = new HashMap<>();
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Vertex K = new Vertex(5, "K");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        Edge<Vertex> e1 = new Edge<>(A, C);
        Edge<Vertex> e2 = new Edge<>(A, B);
        Edge<Vertex> e3 = new Edge<>(B, C);
        Edge<Vertex> e4 = new Edge<>(C, D);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        map1.put(A, e2);
        map1.put(C, e3);
        assertEquals(map1, g.getNeighbours(B));


        Map<Vertex, Edge<Vertex>> map2 = new HashMap<>();
        map2.put(C, e4);
        assertEquals(map2, g.getNeighbours(D));

        Map<Vertex, Edge<Vertex>> emptyMap = new HashMap<>();
        assertEquals(new HashMap<>(), g.getNeighbours(K));

        Map<Vertex, Edge<Vertex>> map3 = new HashMap<>();
        map3.put(B, e2);
        map3.put(C, e1);
        assertEquals(map3, g.getNeighbours(A));
    }

    @Test
    public void shortestPath1() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, C, 7);
        Edge<Vertex> e2 = new Edge<>(A, B, 3);
        Edge<Vertex> e3 = new Edge<>(B, C, 5);
        Edge<Vertex> e4 = new Edge<>(C, D, 8);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        // Source: A    Sink: D
        List<Vertex> result = new ArrayList<>();
        result.add(A);
        result.add(C);
        result.add(D);
        assertEquals(result, g.shortestPath(A, D));

        // Source: A   Sink: C
        List<Vertex> result2 = new ArrayList<>();
        result2.add(A);
        result2.add(C);
        assertEquals(result2, g.shortestPath(A, C));
    }

    @Test
    public void shortestPath4() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();

        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, B, 5);
        Edge<Vertex> e2 = new Edge<>(C, D, 7);

        g.addEdge(e1);
        g.addEdge(e2);

        // Source: A     Sink: D
        List<Vertex> expectedList = new ArrayList<>();

        assertEquals(expectedList, g.shortestPath(A, D));
    }

    // public List<V> shortestPath(V source, V sink) {
    @Test
    public void shortestPath3() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();

        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        // Disconnected Graph:
        List<Vertex> expected = new ArrayList<>();
        assertEquals(expected, g.shortestPath(A , D));
    }

    @Test
    public void shortestPath2() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, C, 3);
        Edge<Vertex> e2 = new Edge<>(A, B, 1);
        Edge<Vertex> e3 = new Edge<>(B, C, 1);
        Edge<Vertex> e4 = new Edge<>(C, D, 3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        // Source: A    Sink: C
        List<Vertex> result = new ArrayList<>();
        result.add(A);
        result.add(B);
        result.add(C);
        assertEquals(result, g.shortestPath(A, C));

        // Source: B   Sink: D
        List<Vertex> result2 = new ArrayList<>();
        result2.add(B);
        result2.add(C);
        result2.add(D);
        assertEquals(result2, g.shortestPath(B, D));
    }

    @Test
    public void minimumSpanningTree1() {
        // Vertices:
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Vertex E = new Vertex(5, "E");
        Vertex F = new Vertex(6, "F");
        Vertex G = new Vertex(7, "G");
        // create the Graph:
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();

        // Add the Vertices into the Graph:
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        g.addVertex(E);
        g.addVertex(F);
        g.addVertex(G);

        // Edges:
        Edge<Vertex> e1 = new Edge<>(A, F, 1);
        Edge<Vertex> e2 = new Edge<>(A, B, 4);
        Edge<Vertex> e3 = new Edge<>(B, D, 3);
        Edge<Vertex> e4 = new Edge<>(D, G, 2);
        Edge<Vertex> e5 = new Edge<>(C, G, 5);
        Edge<Vertex> e6 = new Edge<>(C, F, 5);
        Edge<Vertex> e7 = new Edge<>(C, E, 6);
        Edge<Vertex> e8 = new Edge<>(B, C, 1);


        // add the Edges into the Graph:
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);
        g.addEdge(e8);

        Set<Edge<Vertex>> minSpanTreeExpectedResult = new HashSet<>();
        minSpanTreeExpectedResult.add(e1);
        minSpanTreeExpectedResult.add(e2);
        minSpanTreeExpectedResult.add(e8);
        minSpanTreeExpectedResult.add(e3);
        minSpanTreeExpectedResult.add(e4);
        minSpanTreeExpectedResult.add(e7);

        assertEquals(false, g.edge(F, B));

        List<Edge<Vertex>> actualResult = g.minimumSpanningTree();

        // converting the List into a set because we are not concerned with the order
        // of the elements in the list returned by MST:
        Set<Edge<Vertex>> actualResultSet = new HashSet<>();

        for (Edge<Vertex> element: actualResult) {
            actualResultSet.add(element);
        }

        assertEquals(minSpanTreeExpectedResult, actualResultSet);
    }

    @Test
    public void minimumSpanningTree2() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, C, 7);
        Edge<Vertex> e2 = new Edge<>(A, B, 3);
        Edge<Vertex> e3 = new Edge<>(B, C, 5);
        Edge<Vertex> e4 = new Edge<>(C, D, 8);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        // Expected:
        Set<Edge<Vertex>> MSTexpectedResult = new HashSet<>();
        MSTexpectedResult.add(e2);
        MSTexpectedResult.add(e3);
        MSTexpectedResult.add(e4);

        // Actual:
        List<Edge<Vertex>> MSTactual = g.minimumSpanningTree();

        Set<Edge<Vertex>> actualResultSet = new HashSet<>();
             // Converting from list to Set:
        for (Edge<Vertex> element: MSTactual) {
            actualResultSet.add(element);
        }

        // Now compare the two sets:
        assertEquals(MSTexpectedResult, actualResultSet);
    }

    @Test
    public void pathLength() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, C, 7);
        Edge<Vertex> e2 = new Edge<>(A, B, 3);
        Edge<Vertex> e3 = new Edge<>(B, C, 5);
        Edge<Vertex> e4 = new Edge<>(C, D, 8);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        List<Vertex> path1 = new ArrayList<>();
        path1.add(B);
        path1.add(C);
        path1.add(D);

        assertEquals(5 + 8 , g.pathLength(path1));

        List<Vertex> path2 = new ArrayList<>();
        path2.add(D);
        path2.add(C);
        path2.add(B);
        path2.add(A);
        path2.add(C);

        assertEquals(8 + 5 + 3 + 7, g.pathLength(path2));
    }

    @Test
    public void search() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, C, 7);
        Edge<Vertex> e2 = new Edge<>(A, B, 3);
        Edge<Vertex> e3 = new Edge<>(B, C, 5);
        Edge<Vertex> e4 = new Edge<>(C, D, 8);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        // Testing with range = 4
        int range1 = 4;  // Vertex = A
        Set<Vertex> set1 = new HashSet<>();
        set1.add(B);
        assertEquals(set1, g.search(A, range1));

        // Testing with range = 7
        int range2 = 7; // Vertex = A
        Set<Vertex> set2 = new HashSet<>();
        set2.add(C);
        set2.add(B);
        assertEquals(set2, g.search(A, range2));

        // Testing with range = 16
        int range3 = 16; // Vertex = A
        Set<Vertex> set3 = new HashSet<>();
        set3.add(B);
        set3.add(C);
        set3.add(D);
        assertEquals(set3, g.search(A, range3));

        // Testing with not possible range in path distance; return an empty set
        int range4 = 2;
        assertEquals(new HashSet<>(), g.search(A, range4));


        // empty graph:
        Graph<Vertex, Edge<Vertex>> g1 = new Graph<>();
        g1.addVertex(A);
        g1.addVertex(B);
        g1.addVertex(C);
        g1.addVertex(D);
        assertEquals(new HashSet<>(), g1.search(A, 5));
    }

    /**
     * Compute the diameter of the graph.
     * <ul>
     * <li>The diameter of a graph is the length of the longest shortest path in the graph.</li>
     * <li>If a graph has multiple components then we will define the diameter
     * as the diameter of the largest component.</li>
     * </ul>
     *
     * @return the diameter of the graph.
     */
   // int diameter();
    @Test
    public void diameter1() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, C, 7);
        Edge<Vertex> e2 = new Edge<>(A, B, 3);
        Edge<Vertex> e3 = new Edge<>(B, C, 5);
        Edge<Vertex> e4 = new Edge<>(C, D, 8);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        assertEquals(15, g.diameter());
    }

    @Test
    public void diameter2() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Vertex E = new Vertex(5, "E");
        Vertex F = new Vertex(6, "F");
        Vertex G = new Vertex(7, "G");
        // create the Graph:
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();

        // Add the Vertices into the Graph:
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        g.addVertex(E);
        g.addVertex(F);
        g.addVertex(G);

        // Edges:
        Edge<Vertex> e1 = new Edge<>(A, F, 1);
        Edge<Vertex> e2 = new Edge<>(A, B, 4);
        Edge<Vertex> e3 = new Edge<>(B, D, 3);
        Edge<Vertex> e4 = new Edge<>(D, G, 2);
        Edge<Vertex> e5 = new Edge<>(C, G, 5);
        Edge<Vertex> e6 = new Edge<>(C, F, 5);
        Edge<Vertex> e7 = new Edge<>(C, E, 6);
        Edge<Vertex> e8 = new Edge<>(B, C, 1);


        // add the Edges into the Graph:
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);
        g.addEdge(e8);

        assertEquals(11, g.diameter());
    }

    @Test
    public void diameter3() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        // Disconnected Graph:
        assertEquals(0, g.diameter());
    }

    @Test
    public void diameter4() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        // Only one edge connection:
        Edge<Vertex> e1 = new Edge<>(A, C, 7);
        g.addEdge(e1);
        assertEquals(7, g.diameter());

        // two edge connection:
        Edge<Vertex> e2 = new Edge<>(B, C, 5);
        g.addEdge(e2);
        assertEquals(12, g.diameter());
    }

    @Test
    public void diameter5() {
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex C = new Vertex(3, "C");
        Vertex D = new Vertex(4, "D");
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);

        Edge<Vertex> e1 = new Edge<>(A, C, 7);
        Edge<Vertex> e2 = new Edge<>(B, C, 5);
        Edge<Vertex> e3 = new Edge<>(B, D, 1);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);

        assertEquals(13, g.diameter());

    }
}
