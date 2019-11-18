package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    String name;
    int age;
    String specialPower;
    String weakness;
    private int squadId;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();


    public Hero(String name,int age,String specialPower,String weakness, int squadId){
        this.name=name;
        this.age=age;
        this.specialPower=specialPower;
        this.weakness=weakness;
        this.squadId = squadId;
        this.id=instances.size();
        instances.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                Objects.equals(name, hero.name) &&
                Objects.equals(specialPower, hero.specialPower) &&
                Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, specialPower, weakness, id);
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

    public static void addHero(Hero hero){
        instances.add(hero);
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
