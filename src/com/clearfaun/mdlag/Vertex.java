package com.clearfaun.mdlag;

import java.util.HashSet;

/**
 * Created by SpencerDepas on 6/9/16.
 */
public class Vertex {

    private final String name;
    private int index;
    private String UniqueData;
    private boolean visited = false;



    public Vertex(String name, int index) {
        this.name = name;
        this.index = index;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUniqueData() {
        return UniqueData;
    }

    public void setUniqueData(String uniqueData) {
        UniqueData = uniqueData;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }




}
