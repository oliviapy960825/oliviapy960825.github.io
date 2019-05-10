/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
#include <stdio.h>
#include <math.h>
/*int findMissNo(int num[], int size);
int main(int argc, char** argv) {
    int num[] = {2, 4, 6, 8, 12};
    //printf("mid is %d", mid);
    int size=sizeof(num)/4;
    printf("The size is %d", sizeof(num)/4);
     printf("\n");
    printf("The missing element is %d", findMissNo(num,size)); 
}
int findMissNo(int nums[], int size){
    //int size=sizeof(nums)/sizeof(nums[0]);
    printf("The size is %d", size);
    int diff=(nums[size-1]-nums[0])/size;
    printf("The diff is %d", diff);
    int mid=size/2;//1
    int newNums[mid+1];
    printf("\n");
    printf("The mid-index is %d",mid);
  
    if(size<=1){
        return -1;
    }
    
   if(nums[mid+1]-nums[mid]!=diff){
          return nums[mid]+diff;
        }
    else if(nums[mid]-nums[mid-1]!=diff){
            printf("should stop here1");
          return nums[mid-1]+diff;
          printf("should stop here2");
        }
    
    else if(nums[mid]==nums[0]+diff*mid){
        for(int i=mid;i<size;i++){
            newNums[i-mid]=nums[i];
        }
    }  
    
    else{
        for(int i=0;i<=mid;i++){
            newNums[i]=nums[i];
        }
        }
    return findMissNo(newNums,(mid+1));
           
    }
*/