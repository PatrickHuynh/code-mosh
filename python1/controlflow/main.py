# control flow exercise

even_count = 0
for i in range(1, 10):
    if i % 2 == 0:
        print(i)
        even_count += 1
print(f"We have {even_count} numbers")
