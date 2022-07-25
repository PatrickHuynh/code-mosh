from inspect import ismemberdescriptor
from multiprocessing import set_forkserver_preload
from tempfile import tempdir


class Heap:
    def __init__(self) -> None:
        self.items = []

    def insert(self, n):
        self.items.append(n)
        self.__bubble_up(len(self.items)-1)

    def __bubble_up(self, idx):
        if idx == 0:
            return
        parent_idx = self.__parent_index(idx)
        if self.items[parent_idx] < self.items[idx]:
            self.__swap(parent_idx, idx)
            self.__bubble_up(parent_idx)

    def remove(self):
        if len(self.items) == 0:
            raise Exception("Cannot remove items from an empty heap")
        if len(self.items) == 1:
            self.items = []
        self.items[0] = self.items.pop()
        self.__bubble_down(0)

    def max(self):
        if not self.items:
            raise Exception("Cannot find max of empty heap")
        return self.items[0]

    def __bubble_down(self, idx):
        if idx >= len(self.items)-1:
            return
        lchild_idx = self.__left_child_index(idx)
        rchild_idx = self.__right_child_index(idx)
        if lchild_idx < len(self.items) <= rchild_idx:
            if self.items[lchild_idx] > self.items[idx]:
                self.__swap(lchild_idx, idx)
                self.__bubble_down(lchild_idx)
                return
        if lchild_idx < rchild_idx < len(self.items):
            if self.items[lchild_idx] > self.items[idx]:
                self.__swap(lchild_idx, idx)
                self.__bubble_down(lchild_idx)
                return
            if self.items[rchild_idx] > self.items[idx]:
                self.__swap(rchild_idx, idx)
                self.__bubble_down(rchild_idx)
                return

    def __swap(self, idx1, idx2):
        temp = self.items[idx1]
        self.items[idx1] = self.items[idx2]
        self.items[idx2] = temp

    def __left_child_index(self, parent_index):
        return parent_index * 2 + 1

    def __right_child_index(self, parent_index):
        return parent_index * 2 + 2

    def __parent_index(self, child_index):
        return (child_index - 1) // 2


# %% heap exercise
h = Heap()

h.insert(10)
h.insert(5)
h.insert(17)
h.insert(4)
h.insert(22)
h.remove()
pass

h = Heap()
nums = [5, 3, 8, 4, 1, 2]
for n in nums:
    h.insert(n)
pass


# %% heapify exercise


class Heapify:
    def __init__(self, nums) -> None:
        self.nums = nums
        last_parent = len(self.nums)//2
        for i in reversed(range(last_parent)):
            self.heapify(i)

    def heapify(self, n):
        while True:
            lchild_idx = self.__lchild_index(n)
            rchild_idx = self.__rchild_index(n)

            if lchild_idx < len(self.nums):
                if self.nums[n] < self.nums[lchild_idx]:
                    self.__swap(n, lchild_idx)
                    n = lchild_idx
                    continue

            if rchild_idx < len(self.nums):
                if self.nums[n] < self.nums[rchild_idx]:
                    self.__swap(n, rchild_idx)
                    n = rchild_idx
                    continue

            n = self.__get_parent_index(n)

            if n == -1:
                return

    def __swap(self, idx1, idx2):
        self.nums[idx2], self.nums[idx1] = self.nums[idx1], self.nums[idx2]

    def __lchild_index(self, parent_index):
        return parent_index * 2 + 1

    def __rchild_index(self, parent_index):
        return parent_index * 2 + 2

    def __get_parent_index(self, child_index):
        return (child_index - 1) // 2


nums = [5, 3, 8, 4, 1, 2]
c = Heapify(nums)

# %% get kth largest item


def get_kth_largest_item(nums, k):
    temp_heap = Heap()
    for n in nums:
        temp_heap.insert(n)
    for i in range(k-1):
        temp_heap.remove()
    return temp_heap.max()


print(get_kth_largest_item([5, 3, 8, 4, 1, 2], 2))
# TODO: need to fix code to swap two nodes if left is larger than right -- moving on now
# TODO: handle when k <= 0 or k > tree node count
