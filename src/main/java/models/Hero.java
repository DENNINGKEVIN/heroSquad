package models;

import java.util.ArrayList;

public class Hero {
    String name;
    int age;
    String specialPower;
    String weakness;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();


    public Hero(String name,int age,String specialPower,String weakness){
        this.name=name;
        this.age=age;
        this.specialPower=specialPower;
        this.weakness=weakness;
        this.id=instances.size();
        instances.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Hero> getAll() {
        return instances;
    }
    public static void clearAll(){
        instances.clear();
    }
    public static Hero getHeroById(int id){
        return instances.get(id-1);
    }
    public static Hero deleteHeroById(int id){
        return instances.remove(id-1);
    }
    public String updateHeroById(String name,int age,String specialPower,String weakness){
        this.name =name;
        this.age=age;
        this.specialPower=specialPower;
        this.weakness=weakness;

        return name;
    }
}
