class Graph:
    class Node:
        def __init__(self, label) -> None:
            self.label = label
            self.edges = {}

        def __str__(self) -> str:
            return self.label

    def __init__(self) -> None:
        self.nodes = {}

    def add_node(self, label):
        if label not in self.nodes:
            self.nodes[label] = self.Node(label)
        else:
            print(f"Node {label} already exists")

    def remove_node(self, label):
        if label in self.nodes:
            for n in self.nodes:
                if label in self.nodes[n].edges:
                    del n.edges[label]
            del self.nodes[label]
        else:
            print(f"Node {label} not found")

    def add_edge(self, nfrom, nto):
        if nto not in self.nodes:
            print(f"Node {nto} not found")
            return
        if nfrom not in self.nodes:
            print(f"Node {nfrom} not found")
            return
        nf = self.nodes[nfrom]
        nt = self.nodes[nto]
        nf.edges[nto] = nt

    def remove_edge(self, nfrom, nto):
        if nto not in self.nodes:
            print(f"Node {nto} not found")
            return
        if nfrom not in self.nodes:
            print(f"Node {nfrom} not found")
            return
        nf = self.nodes[nfrom]
        del nf.edges[nto]

    def print(self):
        for n in self.nodes:
            if self.nodes[n].edges:
                print(f"{n} is connected to " + str(list(self.nodes[n].edges.keys())))

    def depth_traversal(self, label):
        if label not in self.nodes:
            print(f"{label} not in graph")
            return
        visited = set()
        n = self.nodes[label]
        output = []

        def traverse(node):
            if node in visited:
                return
            visited.add(node)
            output.append(node)
            for _, next_node in node.edges.items():
                traverse(next_node)
            return
        traverse(n)
        return output

    def breadth_traversal(self, label):
        if label not in self.nodes:
            print(f"{label} not in graph")
            return
        visited = set()
        q = [self.nodes[label]]
        visited.add(q[0])
        output = []
        while q:
            k = q.pop(0)
            output.append(k)
            for _, n in k.edges.items():
                if n not in visited:
                    visited.add(n)
                    q.append(n)
        return output

    def topological_sort(self):
        visited = set()
        stack = []

        def traverse(node):
            visited.add(node)
            for _, n in node.edges.items():
                if n not in visited:
                    traverse(n)
            stack.append(node)
            return

        for _, n in self.nodes.items():
            if n not in visited:
                traverse(n)

        sorted = []
        while stack:
            k = stack.pop().label
            sorted.append(k)

        return sorted

    def graph_has_cycle(self):
        def traverse(node):
            if node in status["visiting"]:
                return True
            status["all_nodes"].remove(node)
            status["visiting"].add(node)
            for m in node.edges.values():
                if m not in status["visited"]:
                    if traverse(m):
                        return True
            status["visiting"].remove(node)
            status["visited"].add(node)
            return False

        status = {
            "all_nodes": set(list(self.nodes.values())),
            "visiting": set(),
            "visited": set()
        }

        while status["all_nodes"]:
            node = list(status["all_nodes"])[0]
            if traverse(node):
                return True

        return False


if __name__ == "__main__":
    g = Graph()

    # implementation
    g.add_node("Hello")
    g.add_node("World")
    g.add_node("Hello")
    g.remove_node("Hello")
    g.remove_node("Hello")
    g.add_node("Hello")
    g.add_edge("Hello", "World")
    g.add_node("!")
    g.add_edge("Hello", "!")
    g.print()
    g.remove_edge("Hello", "World")

    # algorithms
    g = Graph()
    for c in "ABCDE":
        g.add_node(c)
    g.add_edge("A", "B")
    g.add_edge("A", "C")
    g.add_edge("B", "D")
    g.add_edge("D", "C")
    print("depth search starting at A")
    [print(i) for i in g.depth_traversal("A")]
    print("depth search starting at B")
    [print(i) for i in g.depth_traversal("B")]
    print("breadth search starting at A")
    [print(i) for i in g.breadth_traversal("A")]
    print("breadth search starting at B")
    [print(i) for i in g.breadth_traversal("B")]

    g = Graph()
    g.add_node("X")
    g.add_node("A")
    g.add_node("B")
    g.add_node("P")
    g.add_edge("X", "A")
    g.add_edge("X", "B")
    g.add_edge("B", "P")
    g.add_edge("A", "P")
    print("topological sort")
    print(g.topological_sort())

    # cycle detection
    g = Graph()
    for n in "ABCD":
        g.add_node(n)
    g.add_edge("A", "B")
    g.add_edge("B", "C")
    g.add_edge("A", "C")
    g.add_edge("D", "A")
    print(g.graph_has_cycle())

    g = Graph()
    for n in "ABCD":
        g.add_node(n)
    g.add_edge("A", "B")
    g.add_edge("B", "C")
    g.add_edge("C", "A")
    g.add_edge("D", "A")
    print(g.graph_has_cycle())
    pass
