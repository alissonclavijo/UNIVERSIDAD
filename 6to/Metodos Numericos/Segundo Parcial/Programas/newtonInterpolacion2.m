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
## @deftypefn {} {@var{retval} =} newtonInterpolacion2 (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-01-24

function C = newtonInterpolacion2(x, f)
    m = length(x);
    A = zeros(m, m);
    A(:, 1) = f';

    for j = 2:m
        for k = j:m
            A(k, j) = (A(k, j - 1) - A(k - 1, j - 1)) / (x(k) - x(k - j + 1));
        end
    end

    C = A(m, m);

    for k = m - 1:-1:1
        C = conv(C, [1, -x(k)]);
        mm = length(C);
        C(mm) = C(mm) + A(k, k);
    end


    % x1 = x(1):0.1:x(m);
    % y1 = polyval(C, x1);
    % plot(x1, y1);


    % hold on
    % plot(x, f, 'ro')
    % hold off
end

