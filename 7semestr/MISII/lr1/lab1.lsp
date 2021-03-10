(defun F (x y z)
    (setq myList (list x y z))
    (if (rationalp (caddr myList))
		(butlast myList 1)
		(reverse myList)
    )
)

(princ "С рациональным элементом: ")
(print (F 1 2 4/5))
(terpri)
(princ "Без рационального элемента: ")
(print (F 1 2 3.1234))

