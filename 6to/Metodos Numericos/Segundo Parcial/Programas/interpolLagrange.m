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
## @deftypefn {} {@var{retval} =} interpolLagrange (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-01-23


## INGRESO AL COMANDO:     cont = interpolLagrange ([1 2 3 4], [5 9 15 14])

function cont = interpolLagrange (x, fx)
  s1=length(x);
  s2=length(fx);
  cont=0;
  for k=1:s1
    cont=cont+fx(k)*lagrange(x,k);
  endfor

% x1=x(1):0.1:x(s1);
% y1=polyval(cont,x1);
% plot(x1,y1)

% hold on
% plot(x,fx,'ro')
% hold off

endfunction
