def greet(name):
    print(f"Hi there {name}")
    print("welcome aboard")


def get_greeting(name):
    return f"Hi {name}"


message = get_greeting("hi")

# arbitary list of args


def multiply(*numbers):
    total = 1
    for number in numbers:
        total *= number
    return total


k = multiply(2, 3, 4, 5)
print(k)


# keyword args
def save_user(**user):
    print(user)
    print(user['id'])
    print(user['name'])


save_user(id=1, name="John", age=22)
