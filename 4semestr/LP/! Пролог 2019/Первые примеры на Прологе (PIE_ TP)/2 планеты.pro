% domains
 % name=symbol
% predicates
% star(name)
 % planet(name)
 % revolve(name,name)
 % satellite(name,name).
% clauses
 star("sun").
 planet("earth").
 planet("mars").
 revolve("earth","sun").
 revolve("mars","sun").
 revolve("moon ","earth").
 revolve("fobos","mars").
 revolve("demos","mars").
 satellite(X,Y):-planet(Y),revolve(X,Y).
goal:-
 satellite(X,"mars"),
 write(X,"  satellite mars"),nl,fail.
