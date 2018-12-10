package StacksAndQueues.CustomCollections;

import java.util.EmptyStackException;

public class ArrayStack<T> {
        private T[] array;
        private int start;
        private int end;
        private int capacity;

        public ArrayStack(T[] array, int startIndex){
            this.array = array;
            this.start = startIndex;
            this.capacity = array.length / 3;
            this.end = startIndex;
        }


        public int length(){
            return this.end - this.start;
        }

        public void push(T element){
            if(length() == this.capacity){
                throw new IllegalStateException("The stack capacity is full");
            }
            this.array[this.end] = element;
            this.end = this.end + 1;
        }

        public T pop(){
            if(length() <= 0){
                throw new EmptyStackException();
            }

            this.end--;
            return this.array[this.end];

        }

        public T peek(){
            if(length() <= 0){
                throw new EmptyStackException();
            }

            return this.array[this.end - 1];
        }
}
