package StacksAndQueues.AnimalShelter;

import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<ShelterAnimal> dogs;
    private LinkedList<ShelterAnimal> cats;
    private int order;

    public AnimalShelter(){
        //If its a doubly linked list and we had access to its nodes we could have 1 LinkedList with the combined animals, after adding an animal
        // we would get the Node and enqueue it into a corresponding queue/linked list for dogs/cats which would hold Node<Animal> instead of just
        // the animal. DequeueAny can be implemented by polling the combined list checking the type and polling the dogs/cats collection
        // DequeueCat/DequeueDog by polling the dog/cat collection and then deleting the node from the linked list in O(1) time because we have the
        // Node reference. Such an implementation can allow us to avoid having an extra property for order/time stamping
        this.dogs = new LinkedList<>();
        this.cats = new LinkedList<>();
        this.order = 0;
    }

    public void enqueue(Animal animal){
        ShelterAnimal shelterAnimal = new ShelterAnimal(animal, order++);
        if(animal instanceof Dog){
            dogs.offer(shelterAnimal);
        }
        else if(animal instanceof Cat){
            cats.offer(shelterAnimal);
        }
    }

    public Animal dequeueAny(){
        if(dogs.isEmpty() && cats.isEmpty()){
            throw new IllegalStateException("Animal shelter is empty");
        } else if (cats.isEmpty()){
            return dogs.poll().animal;
        } else if(dogs.isEmpty()){
            return cats.poll().animal;
        }

        return dogs.peek().order < cats.peek().order? dogs.poll().animal : cats.poll().animal;


    }

    public Dog dequeueDog(){
        if(dogs.isEmpty()){
            throw new IllegalStateException("There are no dogs in the animal shelter");
        }

        return (Dog)dogs.poll().animal;
    }

    public Cat dequeueCat(){
        if(cats.isEmpty()){
            throw new IllegalStateException("There are no cats in the animal shelter");
        }

        return (Cat)cats.poll().animal;
    }
}
