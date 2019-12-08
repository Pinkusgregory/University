(defun f(x)(/ (sin x) (cos x)))
(setq x 3)
(defun y (x) (/ (+ (* 2 (f (/ x 2)) ) (* 3 (/ 1 (f (/ x 2))))) (+ 4 (f (/ x 4))) ))

(defun f26(a b n m x) (+(* a (sin(* n x))) (* b (cos(* m x)))))
(defun f17(a b c x) (- (* a (expt x 3)) (* b (expt x 2)) c))
(defun f7(a b c x)(+ (* a (expt x 3)) (* b x) c))

(defun in()(format t "~%input x: ")(let((x (read))) (if (numberp x) x (in))))
(defun y7 (x) ( / (f7 3.7 2.4 6.1 x) (f7 3.9 -1.8 -9.2 x)))
(defun y17 (x) (/ (f17 0.7 -1.3 -0.6 x) (f17 4.5 8.7 -4.1 x)))
(defun y26(x) (+ (f26 3 0 2 0 x) (/ (f26 5 3 3 1 x) (f26 8 -4 1 4 x))))

(defun task () (format t "~%Function task~%") (progn (setq val (in)) (y val)) )

(defun task7 () (format t "~%Function task~%") (progn (setq val (in)) (y7 val)) )
(defun task17 () (format t "~%Function task~%") (progn (setq val (in)) (y17 val)) )
(defun task26 () (format t "~%Function task~%") (progn (setq val (in)) (y26 val)) )
