package models;

import java.util.ArrayList;

public class Squad {
    String name;
    String cause;
    int maxSize;
    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name,String cause,int maxSize){
        this.name=name;
        this.cause=cause;
        this.maxSize=maxSize;
        this.id=instances.size();
        instances.add(this);
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public int getMaxSize() {
        return maxSize;
    }
    public static ArrayList<Squad> getAllSquads(){
        return  instances;
    }
    public  static  void clearAll(){
        instances.clear();
    }
    public static Squad getSquadById(int id){
        return instances.get(id-1);
    }
    public static Squad deleteSquadById(int id){
        return instances.remove(id-1);
    }
    public String updateSquadById(String name ,String cause,int maxSize){
        this.name = name;
        this.cause=cause;
        this.maxSize=maxSize;
        return name;
    }
    public int getId(){
        return this.id;
    }

}
