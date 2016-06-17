package com.clearfaun.mdlag;

import java.util.HashMap;

/**
 * Created by SpencerDepas on 6/9/16.
 */
public class AdjacencyMatrixGraph {


    private HashMap<String, Vertex> hmap = new HashMap<String, Vertex>();
    private Vertex vertex;
    private int vertexSize;
    private int[][] adjacencyMatrix;

    public AdjacencyMatrixGraph(int v) {

         vertexSize = v;
         adjacencyMatrix = new int[vertexSize + 1][vertexSize + 1];
     }

    public void makeUndirectedEdge(int to, int from, int weight) {
        try {
            //vertex = new Vertex(Integer.toString(edge));
            adjacencyMatrix[to][from] = weight;
            adjacencyMatrix[from][to] = weight;
            //hmap.put(from, vertex);

        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    //could be a string
    public void getVertexByName(int name){

        hmap.get(name);

    }


    public void makeDirectedEdge(int to, int from, int edge) {
        try {
            adjacencyMatrix[to][from] = edge;
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    public int getEdge(int to, int from) {
        try {
            return adjacencyMatrix[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

}