    % Реализовать программы вычисления суммы следующих рядов:
    % 1 + 2 + 3 + ... + 9 + 10
    % 2 + 4 + 6 + ... + 14 + 16
    % 10 + 9 + 8 + ... + 2 + 1
    % 1 + 3 + 5 + ... + 13 + 15
    % domains
    %               number,sum=integer
    %  predicates
    %                sum(number,sum)
    % clauses
                     sum(11,0).
                     sum(Number, Sum) :--
                       New_number=Number+1,
                       sum(New_number,Partial_sum),
                       Sum=Number+Partial_sum.
     goal:-  write("summa :  "),
             sum(1,Sum),  write(Sum).
     

