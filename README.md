# QuiqProject
Author: Kevin Browder

This program was written for Quiq and takes in a pair of JSON files and compares
 their similarity. The similarity calculated bi-directionally. This similarity
 is calculated by iterating to the base of each object/array and comparing privative
 values inside each object/array. This error is biased towards more similar because
 if an object is not present in the one file it only adds one difference point which
 is equivalent to a single difference between a privative variable instead of the 
 number of privative variable in the object. The same is true for arrays that are
  of different lengths between the files. I would like to fix this but ran out of
  time.
