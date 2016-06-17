package com.clearfaun.mdlag;

import sun.security.provider.certpath.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int  edge, count = 1, to = 0, from = 0, weight = 1;
        AdjacencyMatrixGraph graph;


        edge = 100;

        Vertex[] placesVertex = createVertexes();
        System.out.println("placesVertex size :  " + placesVertex.length);



        graph = new AdjacencyMatrixGraph(placesVertex.length);

         while (count <= edge) {

            int randConnection =  (int)(Math.random() * ((placesVertex.length) + 1));
            int randConnectionTwo =  (int)(Math.random() * ((placesVertex.length) + 1));

            to = randConnection;
            from = randConnectionTwo;


            graph.makeUndirectedEdge(to, from, weight );
            count++;
         }


         printMatrix(placesVertex, graph);

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



    private static Vertex[] createVertexes(){

        String[] statesAndCapitols = {
                "Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho",
                        "Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Cheyenne"};


        System.out.println("statesAndCapitols size :  " + statesAndCapitols.length);

        Vertex[] vertex = new Vertex[statesAndCapitols.length];
        for(int i = 0; i < statesAndCapitols.length; i ++){

            Vertex vertexTemp = new Vertex(statesAndCapitols[i] + "", i);
            vertex[i] = vertexTemp;
        }


        return vertex;
    }

    private static void printMatrix(Vertex[] vertex ,AdjacencyMatrixGraph graph){

        for (int i = 0; i < vertex.length ; i++) {
            System.out.print(vertex[i].getName()  + " is connected to:  ");
            for (int j = 0; j <= vertex.length; j++)
                System.out.print(graph.getEdge(i, j) + " ");
            System.out.println();
        }


        System.out.println();
        System.out.println();


        System.out.print(vertex[0].getName()  + " also know as 0 is connected to " );


        for (int j = 0 ; j < vertex.length; j++){


            if(graph.getEdge(0, j) == 1){

                System.out.print(vertex[j].getName() + ", ");



            }
        }

         System.out.println();


    }
}
