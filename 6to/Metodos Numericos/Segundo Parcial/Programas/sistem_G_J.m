## Copyright (C) 2024 PC
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
## @deftypefn {} {@var{retval} =} sistem_G_J (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-03-06

function x = sistem_G_J(A, B)
    [n, ~] = size(A);
    Ab = [A'; B']';

    % Gaussian Elimination
    for k = 1:n
        [~, ll] = max(abs(Ab(k:n, k)));
        if Ab(k + ll - 1, k) == 0
            error('La matriz es singular');
        end
        m = k + ll - 1;
        Ab = intercambio_filas(Ab, k, m);
        for j = k + 1:n
            Ab = combinar_filas(Ab, k, j, -Ab(j, k) / Ab(k, k));
        end
    end

    % Back substitution
    for k = n:-1:2
        for j = k - 1:-1:1
            Ab = combinar_filas(Ab, k, j, -Ab(j, k) / Ab(k, k));
        end
    end

    % Normalize rows
    for k = 1:n
        Ab(k, :) = Ab(k, :) / Ab(k, k);
    end

    % Extract solution
    x = Ab(:, n + 1);
end

function Ab = intercambio_filas(Ab, i, j)
    temp = Ab(i, :);
    Ab(i, :) = Ab(j, :);
    Ab(j, :) = temp;
end

function Ab = combinar_filas(Ab, i, j, factor)
    Ab(j, :) = Ab(j, :) + factor * Ab(i, :);
end


