%datos
v=[60 80 95 38 90 96 48 102];
n=length(v); %longitud del vector
sum1=0; %inicializacion
sum2=0;  %inicializacion

%desarrollo

for i=1:n;
  if v(i)<90
    sum1 =sum1+v(i);
  else
    sum2 = sum2+1;
  endif
endfor

%resultado
disp('La suma de menores de 90 es:')
disp(sum1)
disp('el numero de mayores o iguales a 90es:')
disp(sum2)
