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
## @deftypefn {} {@var{retval} =} inversaGaussJordan (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: PC <PC@ALI>
## Created: 2024-01-11

function Inv= inversaGaussJordan(A)
  [n n]=size(A);
  I=eye(n);
  Ab=[A';I]';
  for k=1:n
    [bb ll]=max(abs(Ab(k:n,k)));
    if bb==0
      error('la matiz es singular')
     endif
   m=k+ll-1;
   Ab=intercambio_filas(Ab,k,m);
   for j=k+1:n
   Ab=combinar_filas(Ab,k,j,-Ab(j,k)/Ab(k,k));
   endfor
endfor
#para triangular inferiorr
for k=n:-1:2
   for j=k-1:-1:1
   Ab=combinar_filas(Ab,k,j,-Ab(j,k)/Ab(k,k));
   endfor
endfor
#diagonal de unos
for k=1:n
Ab(k,:)=Ab(k,:)/Ab(k,k);
endfor
disp('Diagonal de Unos')
Ab
Ain=Ab(:,n+1:2*n);
endfunction
