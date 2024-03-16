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
## @deftypefn {} {@var{retval} =} fac_LUP (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-01-17

function [L U P] = fac_LUP (A)
  if n ~= n1
    error('No se puede descomponer');
  end

  L = eye(n);
  U = A;
  P = eye(n);

  for k = 1:n-1
    [m1, m2] = max(abs(U(k:n, k)));

    if m1 == 0
      disp('La matriz ingresada es singular');
    end

    p = k + m2 - 1;

    % Intercambio de filas
    U = intercambio_filas(U, k, p);
    P = intercambio_filas(P, k, p);

    for k=1:n-1
    for j = k+1:n
      factor1 = U(j, k) / U(k, k);
      U(j, k:n) = U(j, k:n) - (factor1 * U(k, k:n));
      L(j, k) = factor1;

      endfor
      endfor

  endfor

endfunction
