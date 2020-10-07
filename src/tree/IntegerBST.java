package tree;

public class IntegerBST extends BinarySearchTree<Integer>{

    // AA Question
    public boolean hasSum(int target){
        return recHasSum(this.root, target, 0);
    }
    private boolean recHasSum(Node<Integer> node, int target, int currSum){
        if (node == null) return false;
        if (node.getChildCount() == 0 ) return currSum+node.getInfo() == target;
        else {
            currSum = node.getInfo() + currSum;
            boolean leftSum = recHasSum(node.getLeft(), target, currSum);
            boolean rightSum = recHasSum(node.getRight(), target, currSum);
            if (rightSum || leftSum) {return true;} else return false;
        }
    }

}

