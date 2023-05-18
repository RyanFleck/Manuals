;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname 2023-05-17--ex-2-3-1) (read-case-sensitive #t) (teachpacks ((lib "convert.rkt" "teachpack" "htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "convert.rkt" "teachpack" "htdp")) #f)))
(define (wage h)
  (* 12 h))

(define (tax gross-pay)
  (* 0.15 gross-pay))

(define (subtract-taxes net-pay)
  (- net-pay (tax net-pay)))

(define (net-pay h)
  (subtract-taxes (wage h)))
