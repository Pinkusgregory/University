function y = fregp(v, m)
n = 0;
k = 0;
for i = 1:m
    n = n+1;
    if v(i)==0
        k= k+1;
    end
end
y = k/n;
end

