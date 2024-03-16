% Definir la ecuación diferencial
ode = @(x, y) [y(2); (2*x+1)*y(2) - (x+1)*y(1) + (x^2+x-1)*exp(2*x)];

% Definir las condiciones iniciales y el rango de x
x_span = linspace(0, 2, 50);  % Rango de x
y0 = [0; 1];  % Condiciones iniciales y(0) = 0, y'(0) = 1

% Resolver la ecuación diferencial
[x, y] = ode45(ode, x_span, y0);

% Mostrar la solución en la consola
disp('Solución de la ecuación diferencial:');
disp([x, y(:, 1)]);

% Graficar la solución
figure;
plot(x, y(:, 1), '-o', 'LineWidth', 2);
title('Solución de la Ecuación Diferencial');
xlabel('x');
ylabel('y(x)');
grid on;

