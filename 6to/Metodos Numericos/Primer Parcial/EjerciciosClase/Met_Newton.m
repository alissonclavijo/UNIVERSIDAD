## Author: PC <PC@ALI>
## Created: 2023-12-05

function x1 = Met_Newton(f,g,xo)
fx=inline(f);
gx=inline(g);
x1=xo-fx(xo)/gx(xo);
while abs (x1-xo)> 0,00001
    x2=x1-fx(x1)/gx(x1);
    xo=x1;
    x1=x2;
endwhile
    disp('el cero de f es')

endfunction
