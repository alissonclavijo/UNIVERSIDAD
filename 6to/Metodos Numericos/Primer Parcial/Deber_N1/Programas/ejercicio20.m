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


function E = ejercicio20 (A)
    h = 300;
    C = 1200;
    F = 0.8;
    D = 14;

    E = (pi * (h/cos(A))^2 * F) - (0.5 * pi * D^2 * (1 + sin(A) - 0.5 * cos(A))) - C;
endfunction

initial_guess = 0;  % Valor inicial para A
A = fsolve(@calculate_equation, initial_guess);



