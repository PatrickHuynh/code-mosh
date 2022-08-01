class WeightedGraph:
    class Node:
        def __init__(self, label) -> None:
            self.label = label
            self.edges = {}

        def __str__(self) -> str:
            return f"{self.label}, {[str(edge) for edge in self.edges.values()]}"

        def add_edge(self, graph, to_node, weight):
            self.edges[to_node] = graph.Edge(self, to_node, weight)

    class Edge:
        def __init__(self, from_node, to_node, weight) -> None:
            self.from_node = from_node
            self.to_node = to_node
            self.weight = weight

        def __str__(self):
            return f"{self.from_node.label}-({self.weight})->{self.to_node.label}"

    def __init__(self) -> None:
        self.nodes = {}

    def add_node(self, label):
        n = self.Node(label)
        if label in self.nodes:
            raise Exception(f"Node {label} already exists")
        self.nodes[label] = n

    def add_edge(self, from_node, to_node, weight):
        if from_node not in self.nodes:
            raise Exception(f"Node {from_node} does not exist")
        if to_node not in self.nodes:
            raise Exception(f"Node {to_node} does not exist")
        f = self.nodes[from_node]
        t = self.nodes[to_node]
        f.add_edge(self, t, weight)
        t.add_edge(self, f, weight)

    def __str__(self) -> str:
        s = ""
        for n in self.nodes.values():
            s += str(n) + "\n"
        return s


if __name__ == "__main__":
    wg = WeightedGraph()
    wg.add_node("A")
    wg.add_node("B")
    wg.add_node("C")
    wg.add_edge("A", "B", 3)
    wg.add_edge("A", "C", 2)
    print(wg)
    pass
