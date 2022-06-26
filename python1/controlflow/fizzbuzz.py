def fizz_buzz(input):
    is_divisible_by_three = input % 3 == 0
    is_divisible_by_five = input % 5 == 0
    if is_divisible_by_three and is_divisible_by_five:
        return "fizzbuzz"
    elif is_divisible_by_three:
        return "fizz"
    elif is_divisible_by_five:
        return "buzz"
    else:
        return str(input)


test = [1, 3, 5, 15, 17]

for i in test:
    print(fizz_buzz(i))
