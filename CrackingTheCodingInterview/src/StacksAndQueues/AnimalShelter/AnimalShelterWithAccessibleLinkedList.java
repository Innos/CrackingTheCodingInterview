package StacksAndQueues.AnimalShelter;

import LinkedLists.DoublyLinkedList.DoublyLinkedList;
import LinkedLists.DoublyLinkedList.Node;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class AnimalShelterWithAccessibleLinkedList {
    private Queue<Node<Animal>> dogs;
    private Queue<Node<Animal>> cats;
    private DoublyLinkedList<Animal> animals;

    public AnimalShelterWithAccessibleLinkedList(){
        this.dogs = new ArrayBlockingQueue<>(16);
        this.cats = new ArrayBlockingQueue<>(16);
        this.animals = new DoublyLinkedList<>();
    }

    public void enqueue(Animal animal){
        this.animals.add(animal);
        if(animal instanceof Dog){
            this.dogs.offer(this.animals.end);
        }else if(animal instanceof Cat){
            this.cats.offer(this.animals.end);
        }
    }

    public Animal dequeueAny(){
        if(this.animals.length() == 0){
            throw new IllegalStateException("Animal shelter is empty");
        }
        Animal animal = this.animals.start.getValue();
        if(animal instanceof Dog){
            this.dogs.poll();
        }

        this.animals.delete(this.animals.start);
        return animal;
    }

    public Dog dequeueDog(){
        if(this.dogs.isEmpty()){
            throw new IllegalStateException("There are no dogs in the Animal shelter");
        }

        Node<Animal> animalNode = this.dogs.poll();
        this.animals.delete(animalNode);
        return (Dog)animalNode.getValue();
    }

    public Cat dequeueCat(){
        if(this.cats.isEmpty()){
            throw new IllegalStateException("There are no cats in the Animal shelter");
        }

        Node<Animal> animalNode = this.cats.poll();
        this.animals.delete(animalNode);
        return (Cat)animalNode.getValue();
    }
}
