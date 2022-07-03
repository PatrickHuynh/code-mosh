from multiprocessing.sharedctypes import Value


class Product:
    def __init__(self, price):
        self.price = price

    @property
    def price(self, ):
        return self.price

    @price.setter  # if you dont create this, then price will be readonly after initialisation
    def price(self, value):
        if value < 0:
            raise ValueError("Price can't be less than zero")
        self.price = value
