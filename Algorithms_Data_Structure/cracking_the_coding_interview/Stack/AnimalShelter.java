import java.util.LinkedList;

abstract  class Animal{
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    private  int order;
    protected  String name;
    public Animal(String n){
        name=n;
    }
    /*
    compare orders of animals to return the older item
     */
    public boolean isOlderThan(Animal a){
        return this.order<a.getOrder();
    }

}
public class AnimalShelter {
    LinkedList<Dog> dogs=new LinkedList<>();
    LinkedList<Cat> cats=new LinkedList<>();
    private int order=0;//acts as timestamp
    public void enqueue(Animal a){
        /*
        order is a like a timestamp ,which can be used as insertion order of elemenet
         */
        a.setOrder(order);
        order++;
        if(a instanceof Dog) dogs.add((Dog)a);
        else if(a instanceof Cat)cats.add((Cat) a);
    }
    public Animal dequeueAny(){
        /*
        check the oldest and return the oldest
         */
        if(dogs.size()==0){
            return dequeueCat();
        }
        if(cats.size()==0){
            return dequeueDog();
        }
        Dog dog=dogs.peek();
        Cat cat=cats.peek();
        if(dog.isOlderThan(cat)){
            return dequeueDog();
        }
        else{
            return dequeueCat();
        }
    }
    public Dog dequeueDog(){
        return dogs.poll();
    }
    public Cat dequeueCat(){
        return cats.poll();
    }
}
class Dog extends Animal{
    public Dog(String n) {
        super(n);
    }
}
class  Cat extends  Animal{
    public Cat(String n){
        super(n);
    }
}
