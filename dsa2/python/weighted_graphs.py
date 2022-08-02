from queue import PriorityQueue
import sys


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

    def get_node(self, label):
        if label not in self.nodes:
            raise Exception(f"Node {label} does not exist")
        return self.nodes[label]

    def get_shortest_path(self, from_node, to_node):
        q = PriorityQueue()
        dists = {}
        prevs = {}
        node_ids = {}
        for n in self.nodes.values():
            dists[n] = sys.float_info.max
            prevs[n] = None
            node_ids[id(n)] = n
        visited = set()
        f = self.get_node(from_node)
        t = self.get_node(to_node)
        dists[f] = 0
        q.put((-1, id(f), f))

        while q.qsize():
            _, current_node_id, current_node = q.get()
            #current_node = node_ids[current_node_id]
            if current_node is t:
                continue
            visited.add(current_node)
            current_dist = dists[current_node]
            for edge in current_node.edges.values():
                next_node = edge.to_node
                if next_node not in visited:
                    weight = edge.weight
                    next_node_dist = current_dist + weight
                    if next_node_dist < dists[next_node]:
                        dists[next_node] = next_node_dist
                        prevs[next_node] = current_node
                        q.put((dists[next_node], id(next_node), next_node))

        shortest_path = []
        path_node = t
        while path_node is not f:
            shortest_path.append(path_node.label)
            path_node = prevs[path_node]
        shortest_path.append(f.label)

        return dists[t], list(reversed(shortest_path))


if __name__ == "__main__":
    wg = WeightedGraph()
    wg.add_node("A")
    wg.add_node("B")
    wg.add_node("C")
    wg.add_edge("A", "B", 3)
    wg.add_edge("A", "C", 2)
    print(wg)

    dja = WeightedGraph()
    for n in "ABCDE":
        dja.add_node(n)
    dja.add_edge("A", "B", 1)
    dja.add_edge("A", "C", 4)
    dja.add_edge("A", "D", 2)
    dja.add_edge("C", "D", 1)
    dja.add_edge("B", "D", 6)
    dja.add_edge("B", "E", 1)
    dja.add_edge("D", "E", 10)
    assert dja.get_shortest_path("A", "E") == (2, ['A', 'B', 'E'])
    assert dja.get_shortest_path("C", "E") == (5, ['C', 'D', 'A', 'B', 'E'])
    pass
