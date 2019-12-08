    % ќпределение n-го терма последовательности 1, 1, 2, 6, 24, ...(n=0,1,2Е.).
    % domains
    % n, v = integer
    % predicates
    % posl (n, v)
    % clauses
     posl (0, 1).
     posl (N, V) :-  N>0,  M=N-1, posl (M, U), V=U*N.
     goal:- posl (3, X).
     
