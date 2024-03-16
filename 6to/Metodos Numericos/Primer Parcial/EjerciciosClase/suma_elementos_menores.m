%% Vector dado
v = [60 80 95 38 90 96 48 102];

% Calcular la suma de los elementos menores a 90
suma_menores_90 = sum(v(v < 90));

% Contar el número de elementos mayores o iguales a 90
conteo_mayores_igual_90 = sum(v >= 90);

% Mostrar los resultados
fprintf('Vector dado: %s\n', mat2str(v));
fprintf('Suma de elementos menores a 90: %d\n', suma_menores_90);
fprintf('Número de elementos mayores o iguales a 90: %d\n', conteo_mayores_igual_90);


