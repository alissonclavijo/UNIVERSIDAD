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
## @deftypefn {} {@var{retval} =} funcionMatematica (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2023-11-23


% [R1, R2] = funcionMatematica ('exp(x).*cos(x)','x.^2 + y.^2')

function [R1, R2] = funcionMatematica(f, w)
  % Les hacemos operables a las funciones con funciones anónimas
  fx = @(x) eval(f);
  fxy = @(x, y) eval(w);

  % Podemos realizar los cálculos
  R1 = fx(pi) - fx(2*pi);
  R2 = fxy(3, 5) - 3 * fxy(2, 7);

  % Mostramos un mensaje con los valores de R1 y R2
  fprintf('Los valores de R1 y R2 son: %f, %f\n', R1, R2);
end

