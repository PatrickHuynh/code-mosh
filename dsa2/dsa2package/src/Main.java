public class Main {
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        int[] numbers = new int[] {7,4,9,1,6,8,10};
        for (int num : numbers){
            bst.insert(num);
        }
        // pre-order traverse
        System.out.println("#pre order");
        bst.traverseTree(1);
        // in order traverse LR
        System.out.println("#in order");
        bst.traverseTree(2);
        // post-order traverse
        System.out.println("#post order");
        bst.traverseTree(3);

        // height
        System.out.println("#height");
        bst.height();

        // min
        System.out.println("#min");
        bst.min();

        // tree equality
        System.out.println("#equality");
        BinaryTree bst2 = new BinaryTree();
        for (int num : numbers){
            bst2.insert(num);
        }
        System.out.println(bst.equals(bst2));
        bst2.insert(2);
        System.out.println(bst.equals(bst2));

        // tree validation
        System.out.println("#validate");
        System.out.println(bst2.validateBinarySearchTree());;

        // print node at distance
        System.out.println("#print distance");
        System.out.println(bst2.getNodesAtDistance(2));;

        // breadth first traversal
        System.out.println("#breadth first traverse");
        bst2.breadthFirstTraversal();

        // tree size
        System.out.println("#size");
        System.out.println(bst2.size());

        // tree leaves
        System.out.println("#leaves");
        System.out.println(bst2.countLeaves());

        // tree max
        System.out.println("#max");
        // no challenge - opposite of the min function

        // tree contains
        System.out.println("#contains");
        System.out.println(bst2.contains(10));
        System.out.println(bst2.contains(2));
        System.out.println(bst2.contains(20));

        // tree siblings
        System.out.println("#siblings");
        System.out.println(bst2.areSiblings(1,6));
        System.out.println(bst2.areSiblings(1,7));

        // tree ancestors
        System.out.println("#ancestors");
        var k = bst2.getAncestors(2);
        System.out.println(k);
    }
}