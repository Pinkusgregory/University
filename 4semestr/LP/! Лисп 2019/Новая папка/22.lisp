(defun f1(a) (sin (* 4 a)))
(defun f11(a) (* (cos a) (- (* 4 (sin a)) (* 8 (expt (sin a) 3)))))
(defun f2(a) (cos (* 4 a)))
(defun f22(a) (+ (- (* 8 (expt (cos a) 4)) (* 8 (expt (cos a) 2))) 1))