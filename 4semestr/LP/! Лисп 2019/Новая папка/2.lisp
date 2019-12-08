(defun f23(m n k) (cos (- (/ (* pi m) n) k)))
(defun f24(n k m) (sin (- (/ (* pi n) k) m)))
(defun f7(a b c x) (+ (* a x x x) (+ (* b x) c)))
(defun f17(a b c x) (+ (* a x x x) (+ (* b x x) c)))

(defun y23() (/ (+ (- 1 (f23 3 7 -1)) (* 2 (f23 4 7 0))) (+ 9 (- (f23 3 7 0) (* 4 (f23 5 9 0.5))))))
(defun y24() (/ (- (* 7 (f24 4 11 0)) (* 5 (f24 5 2 2))) (+ (* 5 (f24 8 5 -0.3)) (* 2 (f24 13 3 0)) 0.8)))
(defun y7(x7) (/ (f7 3.7 2.4 6.1 x7) (f7 3.9 -1.8 -9.2 x7)))
(defun y17(x17) (/ (f17 0.7 1.3 0.6 x17) (f17 4.5 -8.7 4.1 x17)))

(defun in()(format t "~%Enter x: ")(let((x (read))) (if (numberp x) x (in))))

(defun task23 () (format t "~%Function task23~%") (progn (setq val (in)) (y23 val)) )
(defun task7 () (format t "~%Function task7~%") (progn (setq val (in)) (y7 val)) )
(defun task17 () (format t "~%Function task17~%") (progn (setq val (in)) (y17 val)) )
(defun task24 () (format t "~%Function task24~%") (progn (setq val (in)) (y24 val)) )
