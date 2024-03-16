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
## @deftypefn {} {@var{retval} =} Met_trapecio (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-02-22

function Int = Met_trapecio(f,a,b,n)
format long
fx=inline(f);
h=(b-a)./n;
for i=1:n+1
    x(i)=a+(i-1).*h;
end
R=fx(x(1))+fx(x(n+1));
cont=0;
for i=2:n
    cont=cont+2*fx(x(i));
end
Int=(R+cont).*h/2;
end

