%ALISSON CLAVIJO
function E = euler(f, a, b, ya, M)
    fx = inline(f, 'x', 'y'); % Change 'T' to 'x'

    h = (b - a) / M;
    T = zeros(1, M + 1);
    Y = zeros(1, M + 1);
    T = a:h:b;
    Y(1) = ya;

    for j = 1:M
        Y(j + 1) = Y(j) + h * fx(T(j), Y(j));
    end

    E = [T' Y'];
    plot(T, Y)
end

