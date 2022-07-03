class Point:
    default_colour = "red"  # class attribute

    def __init__(self, x, y):  # constructor, magic method
        self.x = x
        self.y = y

    @ classmethod  # class method decorator
    def zero(cls):  # class reference, self refers to instance
        return cls(0, 0)  # this is same as calling Point(0,0)

    # https://rszalski.github.io/magicmethods/
    def __str__(self) -> str:   # overrides the __str__ magic function
        return f"({self.x}, {self.y})"

    def __eq__(self, other):
        return self.x == other.x and self.y == other.y

    def draw(self):
        print(f"Point {self.x}, {self.y}")


point = Point(1, 2)
point.z = 10
point.draw()
print(type(point))
isinstance(point, Point)
print(point.x)
print(point.default_colour)  # instance reference
print(Point.default_colour)  # class reference
# if you set Point.default_color = yellow, it will change all instance attributes
other = Point.zero()
other.draw()
print(other)
print(point == other)
