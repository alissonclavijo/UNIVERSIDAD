% Datos
x = [2, 4, 6, 8, 10];
y = [8, 15, 12, 24, 21];

% Cargar el paquete optim
pkg load optim

% Ajuste no lineal
fun = @(b, x) exp(exp(b(1) + b(2) * x)) - 2;
initialGuess = [0, 0];  % Puedes ajustar el valor inicial según sea necesario
options = optimset('Display','off');
coefficients = lsqcurvefit(fun, initialGuess, x, y, [], [], options);

% Coeficientes
b_0 = coefficients(1);
b_1 = coefficients(2);

% Evaluación de la función
y_eval = exp(exp(b_0 + b_1 * x)) - 2;

% Graficar
figure;
hold on;
plot(x, y, 'ro', 'DisplayName', 'Datos');
plot(x, y_eval, 'b-', 'DisplayName', 'y = e^{e^{b_0 + b_1x}} - 2');
hold off;
legend;
xlabel('x');
ylabel('y');
title('Ajuste de la función y = e^{e^{b_0 + b_1x}} - 2 a los datos');

