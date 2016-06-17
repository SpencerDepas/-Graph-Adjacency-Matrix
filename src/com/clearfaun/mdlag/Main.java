package com.clearfaun.mdlag;

import sun.security.provider.certpath.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int  edge, count = 1, to = 0, from = 0, weight = 1;


    public static void main(String[] args) {
	// write your code here

        AdjacencyMatrixGraph graph;
        edge = 20;

        Vertex[] placesVertex = createVertexes();



        graph = new AdjacencyMatrixGraph(placesVertex.length);

        createEdges(graph, placesVertex.length);


        printMatrix(placesVertex, graph);



        //sample output as data is random
        //I did not complete the hashmap implementation for faster retreval times


        //output
        //Alabama is connected to:      0 0 0 0 1 0 0 1 0 0 0 1 0 1 0 0 1 1 0 0 0 0
        //Alaska is connected to:       0 0 0 1 0 1 0 1 1 0 0 0 0 0 1 1 0 1 0 0 0 0
        //Arizona is connected to:      0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 1 1 0 0 0
        //Arkansas is connected to:     0 1 0 0 0 0 0 1 0 0 1 0 1 0 1 0 0 0 0 0 0 0
        //California is connected to:   1 0 1 0 1 1 0 0 0 1 0 1 0 0 0 1 1 1 1 1 0 1
        //Colorado is connected to:     0 1 0 0 1 1 0 0 1 0 0 0 1 0 1 0 0 0 1 1 0 0
        //Connecticut is connected to:  0 0 0 0 0 0 0 1 1 0 1 0 0 1 0 0 1 0 0 0 0 1
        //Delaware is connected to:     1 1 0 1 0 0 1 0 1 0 1 0 0 0 0 0 0 0 1 1 1 1
        //Florida is connected to:      0 1 0 0 0 1 1 1 0 1 1 0 0 0 0 1 0 0 1 0 0 0
        //Georgia is connected to:      0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 1 1 0 0
        //Hawaii is connected to:       0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 0 1 0 0 0 0 0
        //Idaho is connected to:        1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 1 0 1
        //Illinois is connected to:     0 0 1 1 0 1 0 0 0 0 1 0 0 0 1 1 0 0 0 1 1 0
        //Indiana is connected to:      1 0 0 0 0 0 1 0 0 1 0 0 0 0 0 1 1 0 1 0 0 0
        //Iowa is connected to:         0 1 0 1 0 1 0 0 0 0 0 0 1 0 1 1 1 0 0 0 1 0
        //Kansas is connected to:       0 1 0 0 1 0 0 0 1 0 0 1 1 1 1 0 0 0 0 1 0 0
        //Kentucky is connected to:     1 0 0 0 1 0 1 0 0 0 1 0 0 1 1 0 0 0 1 0 0 0
        //Louisiana is connected to:    1 1 1 0 1 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0
        //Maine is connected to:        0 0 1 0 1 1 0 1 1 1 0 1 0 1 0 0 1 0 0 1 0 1
        //Maryland is connected to:     0 0 0 0 1 1 0 1 0 1 0 1 1 0 0 1 0 0 1 0 0 0
        //Cheyenne is connected to:     0 0 0 0 0 0 0 1 0 0 0 0 1 0 1 0 0 0 0 0 0 0

        //Alabama also know as 0 is connected to California, Delaware, Idaho, Indiana, Kentucky, Louisiana,
        //graph.getEdge(1, 1):  0



        System.out.println();
        System.out.println();


        BFS bfs = new BFS();
        bfs.bfs(graph.getMatric(), 0, placesVertex);

        //sample linear print
        //Alabama is connected to:    0 0 0 1 1 0 0
        //Alaska is connected to:     0 0 1 0 1 0 0
        //Arizona is connected to:    0 1 0 0 0 0 1
        //Arkansas is connected to:   1 0 0 0 0 0 0
        //California is connected to: 1 1 0 0 0 1 1
        //Colorado is connected to:   0 0 0 0 1 0 0


        //BFS OUTPUT
        //0	  3	  4  	5   	6


    }


    private static void createEdges(AdjacencyMatrixGraph graph, int length){

        while (count <= edge) {

            int randConnection =  (int)(Math.random() * ((length) + 1));
            int randConnectionTwo =  (int)(Math.random() * ((length) + 1));

            to = randConnection;
            from = randConnectionTwo;


            graph.makeUndirectedEdge(to, from, weight );
            count++;
        }


    }



    private static Vertex[] createVertexes(){
//
//        String[] statesAndCapitols = {
//                "Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho",
//                        "Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Cheyenne"};

        String[] statesAndCapitols = {
                "Alabama","Alaska","Arizona","Arkansas","California"};



        Vertex[] vertex = new Vertex[statesAndCapitols.length];
        for(int i = 0; i < statesAndCapitols.length; i ++){

            //System.out.println( "createVertexes" + i  + " i  " );
            //System.out.println( "createVertexes" + statesAndCapitols[i]  + " statesAndCapitols[i]  " );

            System.out.println( "createVertexes"   + " statesAndCapitols[i]  "  +  statesAndCapitols[i]);

            Vertex vertexTemp = new Vertex(statesAndCapitols[i] + "", i);
            vertex[i] = vertexTemp;
        }


        return vertex;
    }




    private static void printMatrix(Vertex[] vertex ,AdjacencyMatrixGraph graph){

        //System.out.print(vertex.length  + " vertex.length  " );


        for (int i = 0; i < vertex.length ; i++) {
            System.out.print(vertex[i].getName()  + " is connected to:  ");
            for (int j = 0; j < vertex.length; j++)
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
