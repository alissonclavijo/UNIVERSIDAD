h = 0.1;
x0 = 0;
y0 = 0;
xf = 3;

% Crear vectores para almacenar los valores de x e y
x_values = x0:h:xf;
y_values = zeros(size(x_values));

% Inicialización
x_values(1) = x0;
y_values(1) = y0;

% Iteración vectorizada
for i = 1:(length(x_values)-1)
    y_values(i+1) = y_values(i) + h * (-1 - y_values(i)^2) / (1 + x_values(i)^2);
end

% Resultado
disp(['Resultado usando el método de Euler: y(', num2str(xf), ') ≈ ', num2str(y_values(end))]);

% Gráfico
plot(x_values, y_values, 'r-', 'LineWidth', 2);
xlabel('x');
ylabel('y');
title('Método de Euler en Octave');
grid on;

