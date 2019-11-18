package models;

import java.util.ArrayList;
import java.util.Objects;

public class Squad {
    String name;
    String cause;
    int maxSize;
    private int id;
    private ArrayList<Hero>  squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name,String cause,int maxSize){
        this.name=name;
        this.cause=cause;
        this.maxSize=maxSize;
        this.id=instances.size();
        this.squadMembers = new ArrayList<>();
        instances.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return maxSize == squad.maxSize &&
                id == squad.id &&
                Objects.equals(name, squad.name) &&
                Objects.equals(cause, squad.cause) &&
                Objects.equals(squadMembers, squad.squadMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cause, maxSize, id, squadMembers);
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
    public ArrayList<Hero> getSquadMembers(){
        return squadMembers;
    }
    public void setSquadMembers(Hero newMember) {
        squadMembers.add(newMember);
    }
    public void clearAllSquadMembers(){ getSquadMembers().clear(); }
}
