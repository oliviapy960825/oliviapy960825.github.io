function [arraySum] = seqSum(a,N)
% Lab 5 problem 3
%  Returns the sum of the sequence
%  - a, a/2, a/3, ..., a/N
    array1=zeros(1,N);
    array1(:)=a;
    array2=[1:N];
    arraySum=sum(array1./array2);
end
