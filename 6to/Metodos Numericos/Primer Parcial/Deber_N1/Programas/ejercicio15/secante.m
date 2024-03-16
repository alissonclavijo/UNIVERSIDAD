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

## Author: Alisson Clavijo <Alisson Clavijo@ALI>
## Created: 2023-12-09

function [x2] = secante(f, xo, x1)
    format long; % Ajusta el formato de salida para mostrar más decimales

    % Define la función en línea a partir de la cadena de caracteres
    fx = inline(f);

    % Calcula la primera iteración usando el método de la secante
    x2 = x1 - ((fx(x1) * (x1 - xo)) / (fx(x1) - fx(xo)));

    % Bucle para iteraciones adicionales hasta convergencia
    while abs(x2 - x1) > 0.00001
        x3 = x2 - ((fx(x2) * (x2 - x1)) / (fx(x2) - fx(x1)));

        % Actualiza las variables para la siguiente iteración
        x1 = x2;
        x2 = x3;
    end

    % Muestra el resultado
    disp(['El cero de f es: ', num2str(x2)]);
end

