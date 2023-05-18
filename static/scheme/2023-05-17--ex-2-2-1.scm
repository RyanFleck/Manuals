;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname 2023-05-17--ex-2-2-1) (read-case-sensitive #t) (teachpacks ((lib "convert.rkt" "teachpack" "htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "convert.rkt" "teachpack" "htdp")) #f)))
; Load convert teachpack

; Exercise 2.2.1.   Define the program Fahrenheit->Celsius,
; which consumes a temperature measured in Fahrenheit and
; produces the Celsius equivalent. Use a chemistry or
; physics book to look up the conversion formula.

(define (fahrenheit->celsius x)
  (* (- x 32) (/ 5 9)))

(convert-gui fahrenheit->celsius)