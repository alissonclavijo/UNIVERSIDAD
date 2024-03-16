%Hacer un programa que permita elegir dos opciones. La primera es encontrar la suma
%de los números pares y la segunda es encontrar la suma de los números impares, del
%vector formado por los números del 1 al 500 (Usar el comando switch case)

disp('Para sumar Pares (1)')
disp('Para sumar Impares (2)')

N = input('Ingrese la opción: ');

switch N
    case 1
        sumaPares = 0;
        for i = 2:2:500
            sumaPares = sumaPares + i;
        end
        disp(['La suma de los pares es: ' num2str(sumaPares)])

    case 2
        sumaImpares = 0;
        for i = 1:2:499
            sumaImpares = sumaImpares + i;
        end
        disp(['La suma de los impares es: ' num2str(sumaImpares)])

    otherwise
        disp('Esta opción no existe')
end

