
class Trie:
    class Node:
        def __init__(self, c) -> None:
            self.val = c
            self.children = {}
            self.is_end_of_word = False

        def __str__(self):
            return self.val

        def has_child(self):
            return True if self.children else False

        def get_child(self, c):
            if c in self.children:
                return self.children[c]
            else:
                return None

    def __init__(self) -> None:
        self.root = self.Node("")

    def insert(self, word):
        n = self.root
        i = 0
        while i < len(word):
            c = n.get_child(word[i])
            if not c:
                c = self.__add_child(n, word[i])
            n = c
            i += 1
        c.is_end_of_word = True

    def remove(self, word):
        if not word:
            return

        def recursive_removal(current_node, word):
            if len(word) == 0:
                if current_node.has_child():
                    current_node.is_end_of_word = False
                    return False
                return True
            child = current_node.get_child(word[0])
            del_child = recursive_removal(child, word[1:])
            if del_child:
                del current_node.children[word[0]]
                if current_node.is_end_of_word:
                    return True
                else:
                    return False
        recursive_removal(self.root, word)

    def contains(self, word):
        if not word:
            return False
        n = self.root
        for c in word:
            n = n.get_child(c)
            if not n:
                return False
        else:
            return n.is_end_of_word

    def autocomplete(self, word):
        n = self.root
        for i in range(len(word)):
            c = word[i]
            n = n.get_child(c)
            if not n:
                return []

        def get_autocomplete(n, word, words):
            for c in n.children:
                if n.children[c].is_end_of_word:
                    words.append(word+c)
                words = get_autocomplete(n.children[c], word+c, words)
            return words

        return get_autocomplete(n, word, [])

    def __add_child(self, n, c):
        child = self.Node(c)
        n.children[c] = child
        return child


if __name__ == "__main__":

    # build test tree
    t = Trie()
    t.insert("cat")
    t.insert("catty")
    t.insert("car")
    t.insert("care")
    t.insert("bat")

    # tests
    assert t.contains("") == False
    assert t.contains(None) == False
    assert t.contains("bat") == True
    assert t.contains("cat") == True
    assert t.contains("catt") == False

    assert t.autocomplete("ca") == ['cat', 'catty', 'car', 'care']
    assert t.autocomplete("b") == ['bat']

    t.remove("car")
    assert t.contains("care") == True
    assert t.contains("car") == False
    t.remove("care")
    assert t.contains("care") == False

    print("Trie passed")
