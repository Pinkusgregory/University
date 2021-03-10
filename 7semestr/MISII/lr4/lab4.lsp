(defun main ()
  (query '(��������� ����))
  
  (format t "�������� ������� �� ������ � ��������� � ������� 418~%")
  (query '(�������� ������� �� "������" � "���������" � ������� "418"))
  (format t "�������� ������� �� ��������� � ����������� � ������� 8~%~%")
  (query '(�������� ������� �� "���������" � "�����������" � ������� "8"))
  
  (format t "����� �������� ���� � ����� �����������~%")
  (selectQuery '(����� �������� ���� � ����� "�����������"))
  
  (format t "����� ������� ����� 8~%")
  (selectQuery '(����� ������� ����� "8"))
  
  (format t "����� ������� ���� � ���������~%")
  (selectQuery '(����� ������� ���� � "���������"))
  
  (format t "�������� ��� ��������")
  (selectQuery '(�������� ��� ��������))
  
  (format t "�������� �������� � �������� �������� ����������� �� ����~%")
  (query '(�������� �������� � �������� �������� "�����������" �� "����"))
  
  (format t "�������� ��������� ������� � 1 ������ �� ����� ����������~%~%")
  (query '(�������� ��������� ������� � "1" ������ �� ����� "����������"))
  
  (format t "�������� ��� ��������")
  (selectQuery '(�������� ��� ��������))
  
  (format t "������� �������� � �������� �� 1 �� 9~%")
  (selectQuery '(������� �������� � �������� �� "1" �� "9"))
  )

(defvar *db* nil)

(defun insert (start end number)
  (push (list :start start :end end :number number) *db*)
  )

(defun savef (filename)
  (with-open-file (out filename :direction :output :if-exists :supersede)
    (with-standard-io-syntax
      (print *db* out)
      )
    )
  )

(defun loadf (filename)
  (with-open-file (in filename)
    (with-standard-io-syntax
      (setf *db* (read in))
      )
    )
  )

(defun select* ()
  (format t "~%")
  (format t "~%~{~{~a:~a~%~}~%~}" *db*)
  )

(defun where(&key start end number)
  #'(lambda (row)
      (and 
       (if start (equal (getf row :start) start) t)
       (if end (equal (getf row :end) end) t)
       (if number (equal (getf row :number) number) t)
       )
      )
  )

(defun update (where-func &key start end number)
  (setf *db*
        (mapcar
         #'(lambda (row)
             (when (funcall where-func row)
               (if start (setf (getf row :start) start))
               (if end (setf (getf row :end) end))
               (if number (setf (getf row :number) number))
               )
             row
             )
         *db*
         )
        )
  )

(defun selectByRangeNumber (startNumber endNumber)
  (remove-if-not #'(lambda (row) (and (> (parse-integer (getf row :number)) (parse-integer startNumber)) (< (parse-integer (getf row :number)) (parse-integer endNumber)))) *db*)
  )

(defun match (p d)
  (cond
    ;; ������� 1
    ((and (null p) (null d)) t)
    
    ;; ������� 2
    ((and (null d)
          (eq (car p) '$)
          (null (cdr p))) t)
    
    ;; ���� �� ������� ��������
    ((or (null p) (null d)) nil)
    
    ;; ������� 3 � ������� 4
    ((or (equal (car p) '?)
         (equal (car p) (car d)))
     (match (cdr p) (cdr d)))
    
    ;; ������� 5 � 6
    ((eq (car p) '$)
     (cond ((match (cdr p) d) t)
       ((match p (cdr d)) t)))
    
    ;; ������� 7 - ������������� �������, ���������� ���������
    ((and (not (atom (car p)))
          (not (atom (car d)))
          (match (car p) (car d)))
     (match (cdr p) (cdr d)) )
    
    ;; ������� 8 � ����������� �������� � ����������
    ((and (atom (car p))
          (eq (car-letter (car p)) #\?)
          (match (cdr p)(cdr d)))
     (set (cdr-name (car p)) (car d)) t)
    
    ;; ������� 9 - ����������� �������� �������� � ����������
    ((and (atom (car p))
          (eq (car-letter (car p)) #\$))
     (cond ((match (cdr p)(cdr d))
            (set (cdr-name (car p)) (list (car d)))
            t)
       ((match p (cdr d))
        (set (cdr-name (car p))
             (cons (car d)(eval (cdr-name (car p)))))
        t)))
    
    ;; ������� 10 - ��������� ������ �����������, ���� � ������ ���� �?�
    ((and (not(atom (car p)))
          (eq (caar p) 'restrict)
          (eq (cadar p) '?)
          (and-to-list
           (mapcar #'(lambda (pred)
                       (funcall pred (car d))) (cddar p))))
     (match (cdr p)(cdr d)))
    
    ;; ������� 11 - ��������� ������ �����������, ���� � ������ ���� �?V�
    ;; ��������: (match '((restrict ?V integerp evenp) b c) '(36 b c))
    ((and (not (atom (car p)))
          (not (atom d))
          (eq (caar p) 'restrict)
          (eq (car-letter (cadar p)) #\?)
          (and-to-list
           (mapcar #'(lambda (pred)
                       (funcall pred (car d))) (cddar p)))
          (match (cdr p)(cdr d)))
     (set (cdr-name (cadar p)) (car d))
     t)
    ))

(defun car-letter (x) (if (not (numberp x)) (car (coerce (string x) 'list))))

(defun cdr-name (x)
  (intern (coerce (cdr (coerce (string x) 'list)) 'string))
  )

(defun and-to-list (lis)
  (let ((res t))
    (dolist (temp lis res)
      (setq res (and res temp)))
    )
  )

(defun get-matches (p database)
  (remove-if-not #'(lambda (record) (match p record)) database)
  )

(defun query (q)
  (cond 
    ((match `($ ��������� $) q)
     (loadf "database.txt"))
    ((match `($ ��������� $) q)
     (savef "database.txt"))
    ((match `(�������� $ �� ?start � $ ?end $ � ������� $ ?number) q)   
     (insert start end number))
    ((match `($ � ����� $ ?end) q)
     (setf temp (get-matches `($ :end ,end $) *db*))
     (if (null temp) "��������� ���� ���" temp))
    ((match `($ ����� $ ?number) q)
     (setf temp (get-matches `($ :number ,number $) *db*))
     (if (null temp) "��������� � ����� ������� ���" temp))
    ((match `($ ���� � $ ?end) q)
     (setf temp (get-matches `($ :end ,end $) *db*))
     (if (null temp) "����������� �������� � ����� ������� ����������" temp))
    ((match `($ ��� $) q)
     (select*))
    ((match `(�������� $ �������� �������� ?end �� ?endNew) q)
     (update (where :end end) :end endNew))
    ((match `(�������� ��������� ������� � ?number ������ �� ����� ?start) q)
     (update (where :number number) :start start))
    ((match `(������� $ � �������� �� ?startNumber �� ?endNumber) q)
     (selectByRangeNumber startNumber endNumber))
    )
  )

(defun selectQuery (q) 
  (setf temp (query q)) 
  (if (listp temp) 
      (format t "~%~{~{~a:~a~%~}~%~}" temp) 
      (format t "~%" temp)
      )
  )