#funcion triangular inferior
#A, matriz
#B, vector de terminos independientes

function x=Sistem_T_inferior(A,B)
[n n]=size(A);
x(1)=B(1)/A(1,1);
    for i=2:n
    x(i)=(B(i)-A(i,1:i-1)*x(1:i-1)')/A(i,i);
    end
end


#Sistem_T_inferior([6 2 1; 0 -4 1; 0 0 7], [-1 7 6])
