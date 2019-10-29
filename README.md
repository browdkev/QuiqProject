# QuiqProject
Author: Kevin Browder

This program was written for Quiq and takes in a pair of JSON files and compares
their similarity. The similarity is calculated bi-directionally. This similarity
is calculated by iterating to the base of each object/array and comparing privative
values inside each object/array. This error is biased towards more similar because
if an object is present in one file and not present in the other it only
adds one difference point which is equivalent to a single difference between
privative variables instead of the number of privative variables in the object. The
same is true for arrays that are of different lengths in each file except that the
difference is calculated by determining the difference in the number of indexes
between the arrays.
