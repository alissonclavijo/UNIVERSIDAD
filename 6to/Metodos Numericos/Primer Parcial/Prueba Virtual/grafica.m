x0 = 2
x1 = 3
x2 = 4
y0 = exp(x0) - 1.5 - atan(x0)
y1 = exp(x1) - 1.5 - atan(x1)
y2 = exp(x2) - 1.5 - atan(x2)

plot(x0, y0, 'o', x1, y1, 'o', x2, y2, 'o')
x = linspace(-5, 5, 100)
y = exp(x) - 1.5 - atan(x)

plot(x, y)
xlabel("x")
ylabel("f(x)")
