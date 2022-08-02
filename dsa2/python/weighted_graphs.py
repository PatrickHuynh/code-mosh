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

    def has_cycle(self):
        visited = set()

        def cycle_step(current_node, parent):
            visited.add(current_node)
            for node in current_node.edges.values():
                if node.to_node is not parent:
                    if node.to_node in visited:
                        return True
                    return cycle_step(node.to_node, current_node)
            return False

        for node in self.nodes.values():
            if node not in visited:
                if cycle_step(node, None):
                    return True
        return False

    def get_min_spanning_tree(self, root_label):  # prims algo
        root = self.get_node(root_label)
        current_tree = [root]
        visited_nodes = set(current_tree)
        while True:
            min_edge = None
            min_edge_weight = sys.float_info.max
            for n in current_tree:
                for edge in n.edges.values():
                    if edge.to_node not in visited_nodes:
                        if edge.weight < min_edge_weight:
                            min_edge = edge
                            min_edge_weight = edge.weight
            if min_edge:
                visited_nodes.add(min_edge.to_node)
                current_tree.append(min_edge.to_node)
            else:
                break
        return [n.label for n in current_tree]


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

    no_cycle = WeightedGraph()
    no_cycle.add_node("A")
    no_cycle.add_node("B")
    no_cycle.add_node("C")
    no_cycle.add_node("D")
    no_cycle.add_edge("A", "B", 1)
    no_cycle.add_edge("B", "C", 1)
    no_cycle.add_edge("C", "D", 1)
    assert no_cycle.has_cycle() == False

    a_cycle = WeightedGraph()
    a_cycle.add_node("A")
    a_cycle.add_node("B")
    a_cycle.add_node("C")
    a_cycle.add_node("D")
    a_cycle.add_edge("A", "B", 1)
    a_cycle.add_edge("B", "C", 1)
    a_cycle.add_edge("C", "D", 1)
    a_cycle.add_edge("D", "A", 1)
    assert a_cycle.has_cycle() == True

    min_tree = WeightedGraph()
    for n in "ABCD":
        min_tree.add_node(n)
    min_tree.add_edge("A", "B", 2)
    min_tree.add_edge("A", "C", 1)
    min_tree.add_edge("C", "B", 1)
    min_tree.add_edge("B", "D", 4)
    min_tree.add_edge("C", "D", 5)
    assert min_tree.get_min_spanning_tree("A") == ['A', 'C', 'B', 'D']
    pass
