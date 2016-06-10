package com.clearfaun.mdlag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int vertex, edge, count = 1, to = 0, from = 0;
        AdjacencyMatrixGraph graph;

        vertex = 10;
        edge = 28;

        graph = new AdjacencyMatrixGraph(vertex);

         while (count <= edge) {

            int randConnection =  (int)(Math.random() * ((vertex) + 1));
            int randConnectionTwo =  (int)(Math.random() * ((vertex) + 1));

            to = randConnection;
            from = randConnectionTwo;

            graph.makeUndirectedEdge(to, from, 1);
            count++;
         }


         printMatrix(vertex, graph);

         System.out.print("graph.getEdge(1, 1):  " + graph.getEdge(1, 1));


        //sample output as data is random
        //I did not complete the hashmap implementation for faster retreval times


        //output
        //Node 1 is connected to:  1 1 1 1 1 0 0 0 0 0
        //Node 2 is connected to:  1 0 0 0 0 0 1 0 0 0
        //Node 3 is connected to:  1 0 1 0 1 0 1 0 0 1
        //Node 4 is connected to:  1 0 0 1 0 0 0 1 0 0
        //Node 5 is connected to:  1 0 1 0 0 1 1 1 0 0
        //Node 6 is connected to:  0 0 0 0 1 0 0 0 0 0
        //Node 7 is connected to:  0 1 1 0 1 0 0 1 0 1
        //Node 8 is connected to:  0 0 0 1 1 0 1 0 1 1
        //Node 9 is connected to:  0 0 0 0 0 0 0 1 0 1
        //Node 10 is connected to:  0 0 1 0 0 0 1 1 1 0

        //graph.getEdge(1, 1):  1
    }

    private static void printMatrix( int vertex,AdjacencyMatrixGraph graph){

        for (int i = 1; i <= vertex; i++) {
            System.out.print("Node " + i + " is connected to:  ");
            for (int j = 1; j <= vertex; j++)
                System.out.print(graph.getEdge(i, j) + " ");
            System.out.println();
        }
    }
}
