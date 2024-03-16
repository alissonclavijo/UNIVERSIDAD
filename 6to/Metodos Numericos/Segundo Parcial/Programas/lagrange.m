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
## @deftypefn {} {@var{retval} =} lagrange (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-01-23

function LG = lagrange (x, k)
  rr=1;
  ss=1;
  s=length(x);
  for j=1:s
    if j~=k
      rr=conv(rr,poly(x(j)));
      ss=ss*(x(k)-x(j));
    else
      poly(x(j))==1;
    endif
    LG=(1/ss)*rr;
  endfor

endfunction
