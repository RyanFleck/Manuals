#lang scheme

(define (area-of-ring outer-r inner-r)
  (- (area-of-disk outer-r) (area-of-disk inner-r)))

(define (area-of-disk r)
  (* 3.14 r r))