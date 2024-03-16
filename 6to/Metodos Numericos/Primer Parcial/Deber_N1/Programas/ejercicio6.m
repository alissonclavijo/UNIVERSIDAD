## Copyright (C) 2023 Alisson Clavijo
##
## This program is free software: you can redistribute it and/or modify
## it under the terms of the GNU General Public License as published by
## the Free Software Foundation, either version 3 of the License, or
## (at your option) any later version.
##
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
##
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see <https://www.gnu.org/licenses/>.

## -*- texinfo -*-
## @deftypefn {} {@var{retval} =} a (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn
## ejercicio6(10); para ejecutar

## Author: Alisson Clavijo <Alisson Clavijo@ALI>
## Created: 2023-12-08

function retval = ejercicio6(n)
    var = '';

    while ~isequal(var, 'S')
        disp('Ingrese la letra segun lo que requiera:');
        disp('K -> kelvin');
        disp('F -> fahrenheit');
        disp('R -> reamur');
        disp('S -> salir');

        var = upper(input('Ingrese una opcion: ', 's'));

        switch var
            case 'F'
                Temp = 1.8 * n + 32;
                disp(['La temperatura en Fahrenheit es: ' num2str(Temp)]);
            case 'K'
                Temp = n + 273.15;
                disp(['La temperatura en Kelvin es: ' num2str(Temp)]);
            case 'R'
                Temp = 1.6 * n;
                disp(['La temperatura en Reamur es: ' num2str(Temp)]);
            case 'S'
                disp('Saliendo del programa.');
            otherwise
                disp('Opción no válida. Inténtalo de nuevo.');
        end
    end
end

