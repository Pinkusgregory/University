   % Построения ряда кубов четных чисел. Пределы ряда задаются пользователем

   % Domains 
   % i=integer  
   % predicates
   % ryad(i,i)
   % clauses
	ryad(N,V):-N>V.
	ryad(N,V):-N mod 2=0,N2=N*N*N, write(N2),write(" "), N1=N+2, ryad(N1,V).
	ryad(N,V):-N1=N+1, ryad(N1,V).
	goal:- ryad(3,5).
