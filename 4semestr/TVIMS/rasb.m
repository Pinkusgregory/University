function f = rasb(a, r , e)
for i = 1:5
    for j = 1:1000
        f(i, j) = logzn(r, e, a(i, j))
    end
end

end

