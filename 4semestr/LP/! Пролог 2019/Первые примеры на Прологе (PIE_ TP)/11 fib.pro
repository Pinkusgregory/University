% ряд чисел фиббоначи
 % predicates
   %   fib(integer,integer)
            
 % clauses

      fib(1,1):-!.
      fib(2,1):-!.
      
      fib(N,F):- N1=N-1, N2=N-2,
        fib(N1,F1),
        fib(N2,F2),
        F=F1+F2.

goal:- fib(7,X),write(X),nl.

