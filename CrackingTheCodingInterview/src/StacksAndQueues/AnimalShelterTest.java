package StacksAndQueues;


import StacksAndQueues.AnimalShelter.*;

public class AnimalShelterTest {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Dog dog1 = new Dog("Sharo");
        Cat cat1 = new Cat("Poki");
        Animal dog2 = new Dog("Dufus");

        shelter.enqueue(dog1);
        shelter.enqueue(cat1);
        shelter.enqueue(dog2);

        Animal firstAdopted = shelter.dequeueAny();
        System.out.println(firstAdopted.name);

        Dog adoptedDog = shelter.dequeueDog();
        System.out.println(adoptedDog.name);

        Animal adoptedCat = shelter.dequeueAny();
        System.out.println(adoptedCat.name);

        System.out.println("----------------");
        AnimalShelterWithAccessibleLinkedList shelter2 = new AnimalShelterWithAccessibleLinkedList();

        shelter.enqueue(dog1);
        shelter.enqueue(cat1);
        shelter.enqueue(dog2);

        Animal firstAdopted2 = shelter.dequeueAny();
        System.out.println(firstAdopted.name);

        Dog adoptedDog2 = shelter.dequeueDog();
        System.out.println(adoptedDog2.name);

        Animal adoptedCat2 = shelter.dequeueAny();
        System.out.println(adoptedCat2.name);
    }
}
