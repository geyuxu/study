#! /bin/clisp
(defvar *db* nil)

(defun make-cd (title artist rating ripped) 
  (list :title title :artist artist :rating rating :ripped ripped))


(defun add-record (cd) (push cd *db*))

(add-record (make-cd "Roses" "Kathy Mattea" 7 t))
(add-record (make-cd "Home" "Dixie Chicks" 8 t))
(add-record (make-cd "Fly" "Dixie Chicks" 9 t))

#(print *db*)

(defun dump-db () 
  (dolist (cd *db*)
    (format t "~{~a: ~10t~a~%~}~%" cd)))
(dump-db)
#(print "done.")
