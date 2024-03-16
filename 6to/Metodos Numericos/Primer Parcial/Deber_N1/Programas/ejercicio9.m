## Author: Alisson Clavijo <Alisson Clavijo@ALI>
## Created: 2023-12-08
## Una calificación debe ser menor a 7.5 para aprobar. El programa lee el
## dato e indica si el individuo está aprobado o reprobado. Para el caso de
## que el usuario da una letra en lugar de un número, entonces
## el programa no ejecuta ninguna acción.

dato = input("Ingresa la calificación: ", "s");

if isstrprop(dato, 'digit')
    calificacion = str2double(dato);
    if calificacion < 7.5
        disp("Reprobado");
    else
        disp("Aprobado");
    end
else
    disp("Error: Ingresa un número válido.");
end

