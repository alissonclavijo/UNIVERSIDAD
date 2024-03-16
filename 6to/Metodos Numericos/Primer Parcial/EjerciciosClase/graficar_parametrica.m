## Copyright (C) 2023 PC
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
## @deftypefn {} {@var{retval} =} graficaParametrica (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2023-11-23

function graficar_parametrica(a, b, num_puntos)
    % Generar valores de t en el intervalo [a, b]
    t = linspace(a, b, num_puntos);

    % Calcular las coordenadas x e y de la función paramétrica
    x = 5 * cos(t/5) + cos(2*t);
    y = 5 * sin(t/5) + sin(3*t);

    % Graficar la función
    plot(x, y, '-o');
    title('Gráfica de la función paramétrica');
    xlabel('x');
    ylabel('y');
    grid on;

endfunction
