x = "This is a common interview question"
y = {k: x.count(k) for k in x}
z = list(y.items())
z.sort(key=lambda item: item[1], reverse=True)

print(f"{z[0][0]} is the most common occurence with {z[0][1]} occurences")
