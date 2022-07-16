# %%
class AVLTree:
    class AVLNode:
        def __init__(self, n) -> None:
            self.value = n
            self.left = None
            self.right = None
            self.height = 0
            self.balance_factor = 0

        def __str__(self) -> str:
            return str(self.value)

    def __init__(self) -> None:
        self.root = None

    def height(self):
        pass

    def insert(self, n):
        self.root = self.__insert(self.root, n)

    def __insert(self, root, n):
        if root == None:
            return self.AVLNode(n)

        if n > root.value:
            root.right = self.__insert(root.right, n)
        else:
            root.left = self.__insert(root.left, n)

        root = self.__set_node_height(root)

        root = self.__balance(root)

        return root

    def __balance(self, node):
        if self.__is_left_heavy(node):
            if self.__balance_factor(node.left) < 0:
                print(f"Left rotate {node.left.value}")
                node.left = self.__left_rotate(node.left)
            print(f"Right rotate {node.value}")
            node = self.__right_rotate(node)
        elif self.__is_right_heavy(node):
            if self.__balance_factor(node.right) > 0:
                print(f"Right rotate {node.right.value}")
                node.right = self.__right_rotate(node.right)
            print(f"Left rotate {node.value}")
            node = self.__left_rotate(node)
        return node

    def __node_height(self, node):
        return -1 if node is None else node.height

    def __set_node_height(self, node):
        node.height = max(self.__node_height(node.right), self.__node_height(node.left)) + 1
        return node

    def __is_left_heavy(self, node):
        return self.__balance_factor(node) > 1

    def __is_right_heavy(self, node):
        return self.__balance_factor(node) < -1

    def __balance_factor(self, node):
        return self.__node_height(node.left) - self.__node_height(node.right)

    def __left_rotate(self, root):
        new_root = root.right
        root.right = root.right.left
        new_root.left = root
        root = self.__set_node_height(root)
        new_root = self.__set_node_height(new_root)
        return new_root

    def __right_rotate(self, root):
        new_root = root.left
        root.left = root.left.right
        new_root.right = root
        root = self.__set_node_height(root)
        new_root = self.__set_node_height(new_root)
        return new_root


# %%
t = AVLTree()


t.insert(10)
t.insert(30)
t.insert(20)

pass
# %%
