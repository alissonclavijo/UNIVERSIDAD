#Funcion del Triangular superior
#A, matriz
#B, vector de terminos independientes

function x=Sistem_T_sup(A,B)
[n n]=size(A);
x(n)=B(n)/A(n,n);
    for i=n-1:-1:1
    x(i)=(B(i)-A(i,i+1:n)*x(i+1:n)')/A(i,i);
  end

end


#Sistem_T_sup([6 2 1; 0 -4 1; 0 0 7], [-1 7 6])

