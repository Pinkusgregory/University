man(stepa).
man(bob).
woman(zoya).
woman(olya).
woman(pam).
man(tom).
married(pam, tom).
woman(liz).
man(jim).
married(liz, jim).
woman(ann).
man(vasya).
man(petya).
child(olya, zoya).
child(pam, zoya).
child(ann, pam).
child(vasya, pam).
child(tom, bob).
child(liz, bob).
child(bob, stepa).
child(petya, liz).

wife(X,Y):-married(X,Y),woman(X).  %жена 
husband(X,Y):-married(X,Y),man(X). % муж 
child(C,Y):-married(X,Y),child(C,X),!. % Если является ребёнком одного из родителей то автоматически является ребёнком второго родителя 
doughter(X,Y):-child(X,Y),woman(X).  
son(X,Y):-child(X,Y),man(X). 
grandmother(G,C):-parent(X,C),parent(G,X),woman(G). %бабушка 
grandfather(G,C):-parent(X,C),parent(G,X),man(G).   %дедушка 
parent(D,X):-child(X,D). %родитель, если является ребёнком 
brother(A,Y):-parent(P,Y),parent(P,A),man(A).   %брат 
sister(X,Y):-child(X,P),child(Y,P),woman(X).  %сестра 
uncle(U,C):-parent(P,C),brother(U,P). %дядя 
aunt(A,C):-child(C,P),sister(A,P). %тётя
husband_of_father_sister(H,X):-married(Y,H),brother(B,Y),parent(B,X).
grandgrandfather(G,X):-man(G),parent(G,Y),parent(Y,C),parent(C,X).
pseudo_sister(S,C):-uncle(X,C),doughter(S,X).
pseudo_sister(S,C):-aunt(X,C),doughter(S,X). 

rr1:-parent(tom,ann),
    brother(tom,liz), 
    aunt(pam,vasya),   
    grandfather(stepa,liz).
rr2:-husband_of_father_sister(jim,vasya).
rr3:-grandgrandfather(stepa,vasya).
rr4:-pseudo_sister(ann,petya).