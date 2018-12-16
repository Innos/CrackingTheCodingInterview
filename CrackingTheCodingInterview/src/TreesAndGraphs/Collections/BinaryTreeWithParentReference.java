package TreesAndGraphs.Collections;


import java.util.Random;

public class BinaryTreeWithParentReference<T> {
    private TreeNodeWithParent<T> root;
    private Random random = new Random();

    public void setRoot(TreeNodeWithParent<T> root){
        this.root = root;
    }

    public TreeNodeWithParent<T> getRoot(){
        return this.root;
    }

    /**
     * Randomly chooses left or right subtree until it finds an empty leaf node to insert the new value
     * @param value The new element to be added
     */
    public void add(T value){
        if(this.root == null){
            this.root = new TreeNodeWithParent<>(value);
        } else {
            TreeNodeWithParent<T> current = this.root;
            boolean isAdded = false;

            while(!isAdded){
                int rnd = random.nextInt(2);

                if(rnd == 0 && current.getLeft() != null){
                    current = current.getLeft();
                } else if (rnd == 0 && current.getLeft() == null){
                    current.setLeft(new TreeNodeWithParent<T>(value));
                    isAdded = true;
                }else if (rnd == 1 && current.getRight() != null){
                    current = current.getRight();
                } else if(rnd == 1 && current.getRight() == null){
                    current.setRight(new TreeNodeWithParent<T>(value));
                    isAdded = true;
                }
            }
        }
    }
}
