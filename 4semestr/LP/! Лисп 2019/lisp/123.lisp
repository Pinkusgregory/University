defun quadratic-roots-2 (A B C) 
  (cond ((= A 0) (string "Not a quadratic equation.")) 
    (t 
    (let ((D (- (* B B) (* 4 A C)))) 
      (cond ((= D 0) (concatenate 'string "x = " (write-to-string (/ (+ (- B) (sqrt D)) (* 2 A))))) 
        (t 
        (concatenate 'string (concatenate 'string "x1 = " (write-to-string (/ (+ (- B) (sqrt D)) (* 2 
A)))) 
                             (concatenate  'string  "~%x2  =  "  (write-to-string  (/  (- (- B)  (sqrt  D))  (*  2 
A))))))))))) 
 
(let ((A (read)) 
     (B (read)) 
     (C (read))) 
(format t (quadratic-roots-2 A B C)))