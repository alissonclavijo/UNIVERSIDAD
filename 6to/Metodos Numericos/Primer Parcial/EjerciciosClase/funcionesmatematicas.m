% La función univariable puede ingresar, con el formato
fx = @(x) (exp(x).*cos(x));

% La función de dos variables ingresa con el formato
fxy = @(x, y) (x.^2 + y.^2);

% En caso las funciones matemáticas son operables y calculamos R1 Y R2
R1 = fx(pi) - fx(2*pi);
R2 = fxy(3, 5) - 3 * fxy(2, 7);

% Imprimir resultados
disp(['El valor de R1 = ' num2str(R1)]);
disp(['El valor de R2 = ' num2str(R2)]);

