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
## @deftypefn {} {@var{retval} =} Met_PuntoMedio (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-02-27
%M�todo del punto medio

function PuntoMedio=Met_PuntoMedio(f,a,b)
format long
fx=inline(f);
n=250;
h=(b-a)/n;

%evaluando las abscisas xi
for i=1:n+1
    x(i)=a+(i-1)*h;
end

%integral
R=fx(x(1))+fx(x(n+1));
cont=0;
for i=2:n
    cont=cont+2*fx(x(i));
end

PuntoMedio=(R+cont)*(h/2);

end

