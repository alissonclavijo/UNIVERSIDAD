%Hacer un programa que calcule el logaritmo natural de un número positivo 𝑎,
%ingresado por pantalla; 10 ingresos en total (Usar comando break)

i=0;
while i<10
  a= input('Ingrese un numero positivo:')
  if a <=0
    disp('El numero ingresado no es positivo')

    break
  endif

  disp('El Logaritmo natural del numero ingresado es:')
  disp(log(a))

 i=i+1;
 endwhile
