#Metodo de la Biseccion

## Author: PC <PC@ALI>
## Created: 2023-12-05
function c = Met_biseccion(f, a, b)
  fx = inline(f);

  while abs(b - a) > 0.00001
    if fx(a) * fx(b) < 0
      c = (a + b) / 2;
      if fx(a) * fx(c) < 0
        b = c;
      else
        a = c;
      endif
    else
      disp('En este intervalo no existe un cero de f');
      return;
    endif
  endwhile

  disp(['El cero de f es: ' num2str(c)]);

endfunction
