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
## @deftypefn {} {@var{retval} =} graficaCirculoEcuacionesParametricas (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2023-11-21


% Construir un archivo de funciones que devuelva la gráfica de un círculo de centro (0,0)
% y radio r (Usar las ecuaciones paramétricas del círculo).

function retval = graficaCirculoEcuacionesParametricas(radio)
    t = linspace(0, 2 * pi, 100);  % Genera 50 puntos desde 0 hasta 2*pi
    x = radio * cos(t);  % Ecuación paramétrica para x
    y = radio * sin(t);  % Ecuación paramétrica para y

    plot(x, y);  % Graficar el círculo
    axis equal;  % Hace que los ejes tengan la misma escala
    title(['Círculo de radio ' num2str(radio)]);
    xlabel('Eje X');
    ylabel('Eje Y');
end

