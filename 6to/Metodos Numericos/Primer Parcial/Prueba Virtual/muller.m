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
## @deftypefn {} {@var{retval} =} muller (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2023-12-08

% Define la función de Muller
function [root, iterations] = muller(f, x0, x1, x2, tol, max_iter)
    f = inline(f);
    iterations = 0;

    while iterations < max_iter
        h1 = x1 - x0;
        h2 = x2 - x1;

        f0 = f(x0);
        f1 = f(x1);
        f2 = f(x2);

        delta1 = (f1 - f0) / h1;
        delta2 = (f2 - f1) / h2;

        a = (delta2 - delta1) / (h2 + h1);
        b = delta2 + h2 * a;
        c = f2;

        radicando = b^2 - 4*a*c;

        if abs(b + sqrt(radicando)) > abs(b - sqrt(radicando))
            den = b + sqrt(radicando);
        else
            den = b - sqrt(radicando);
        end

        dxr = -2 * c / den;
        x = x2 + dxr;

        if abs(dxr) < tol
            root = x;
            return;
        end

        x0 = x1;
        x1 = x2;
        x2 = x;
        iterations = iterations + 1;
    end

    error('El método de Müller no convergió después de %d iteraciones.', max_iter);
end

% Llama a muller con la función y valores iniciales
[x, iter] = muller(@(x) exp(x) - 1.5 - atan(x), -15, -14, -13, 1e-6, 100);

% Muestra el resultado
fprintf('La raíz aproximada es %.6f después de %d iteraciones.\n', x, iter);


