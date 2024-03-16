#Prueba Virtual
#Nombre: Alisson Clavijo
#Metodo de HEUN

function H = Heun(f, a, b, ya, M)
    fx = @(T, Y) f(T, Y);
    h = (b-a)/M;
    T = a:h:b;
    Y = [];
    Y(1) = ya;
    for j = 1:M
        k1 = fx(T(j),Y(j));
        k2 = fx(T(j)+h, Y(j)+h*k1);
        Y(end+1) = Y(j) + (h/2)*(k1+k2);
    end
    H = [T' Y'];
    plot(T, Y)
end
