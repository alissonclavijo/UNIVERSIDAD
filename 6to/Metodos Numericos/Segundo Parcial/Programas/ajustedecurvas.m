%ajuste de curvas
%y=b0+b1x

x = [2, 4, 6, 8, 10];
y = [8, 15, 12, 24, 21];
C = polyfit(x, y, 1);
disp(C);

