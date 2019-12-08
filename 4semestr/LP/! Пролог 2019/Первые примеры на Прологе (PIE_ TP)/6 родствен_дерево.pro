mother("Bill", "Lisa").    % 4 факта
father("Bill", "John").
father("Pam", "Bill").
father("Jack", "Bill").

parent(Child, Parent) :-    % правило1
mother(Child, Parent);      % обратить внимание на точку с запятой!
father(Child, Parent).

grandFather(GrandChild, GrandFather) :-    %правило2
father(GrandChild, Father),
father(Father, GrandFather).

rr1:-father("Pam","Bill").     % 3 цели 

rr2:-father("Bill",X),write("X= ",X),nl.

rr3:- father(AA, BB), parent(BB, CC),
            write("AA= ",AA),write("BB= ",BB),write("CC= ",CC),nl,fail.





rr4:- grandFather(GC, GFa),write("child= ",GC),nl,
                           write("grand= ",GFa),nl,
                           fail.

