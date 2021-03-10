(defun insertSymbolRec (myList) 
    (cond 
        ((zerop n) (cons x myList)) 
        (T (cons (car myList) (insertSymbolRec (cdr myList)))) 
    ) 
) 

(princ "Рекурсивная функция:")
(print (insertSymbolRec '(1 ((2 3) 4 6))))

(terpri)

(defun insertSymbolIter (myList) 
    (let ((sum 0))
        (loop 
            (cond 
                ((zerop n) (return sum))
                (T 
                    (setf tempList1 (append tempList1 (list (car tempList2)))) 
                    (setf tempList2 (cdr tempList2)) (setf n (- n 1)) 
                )
            )
        )
    )
)

(princ "Итерационная функция:")
(print (insertSymbolIter '(1 ((2 3) 4 6))))
