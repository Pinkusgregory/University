a = rand(5,1000);
parta = a(1:5, 1:10);
disp(parta);

q = input('¬ведите am');
w = input('¬ведите aM');

b = rasb(a, q, w);

disp(b);

for i = 1:5
    q = fregp(b(i,:), 1000);
    o(i) = q;
    disp("q=");
    disp(q);
end

plot(o);
semilogx(o);