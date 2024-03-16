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
## Created: 2023-12-10

function x = ejercicio19 (n)
  format long
  x0=0;
  x1=n;
  fx=@(x)x^2-n;
  x2=x1-((fx(x1)*(x1-x0)) / (fx(x1)-fx(x0)));
    while abs (x2-x1)>0.00001
       x=x2-((fx(x2)*(x2-x1)) / (fx(x2)-fx(x1)));
       x1=x2;
       x2=x;
    endwhile
  disp ('La raiz es: ')
endfunction
