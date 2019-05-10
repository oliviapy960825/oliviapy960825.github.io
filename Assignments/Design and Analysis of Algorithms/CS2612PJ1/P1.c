/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
#include <stdio.h>
#include <math.h>
#include <limits.h>

int maxSubArray(int nums[], int size);
void main() {
    int arr[] = {-2, 3, 4, 5, -7}; 
    int size=sizeof(arr)/4;
    printf("size is : %d",size);
    printf("\n");
    printf("max is : %d",maxSubArray(arr,size));
    //printf("max is : %d", max(2,3));
}
int maxSubArray(int nums[],int size) {
   
   //int size=sizeof(nums)/sizeof(nums[0]);
   int mid=size/2;
   printf("mid is %d", mid);
   if(size==1){
       return nums[0];
}
   else{
       int sum=0;
       int maxNum=nums[0];
       int index=0;
       for(int i=0;i<size;i++){
           if(nums[i]>maxNum){
               maxNum=nums[i];
               index=i;
           }
       }
       printf("max num is %d", maxNum);
       printf("index num is %d", index);
       if(maxNum<0){
           return maxNum;
       }
       else{
           for(int i=index;i>=0;i--){
               if(nums[i]>=0){
                   sum+=nums[i];
               }
               else{
                   break;
               }
           }
           for(int i=index+1;i<size;i++){
               if(nums[i]>=0){
                   sum+=nums[i];
               }
               else{
                   break;
               }
           }
           return sum;
       }
   }
}
