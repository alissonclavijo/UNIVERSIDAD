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
## @deftypefn {} {@var{retval} =} sistema_LUP (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-01-16

function x = sistema_LUP (A, B)
  disp('Paso 1')
  [L U P]=fac_LUP(A)
  disp('Paso 2')
  B1=P*B'
  disp('Paso 3')
  y=Sistem_T_inferior(L, B1)
  disp('Paso 4')
  x=Sistem_T_sup(U,y)

endfunction
