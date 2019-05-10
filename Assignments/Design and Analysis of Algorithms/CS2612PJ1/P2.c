/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
#include <stdio.h>
#include <math.h>
#include <limits.h>
/*int findKthLargest(int nums[], int size, int k);
//void merge(int arr[], int low, int medium, int high);
//void mergeSort(int arr[], int low, int high);
int partition(int arr[], int size);
int main(int argc, char** argv) {
    int arr[] = {12, 3, 5, 19, 4}; //{26,19,7,5,4,3,12};{19,26,7};{12,4,3,5}
    int size = sizeof(arr)/sizeof(arr[0]);
    int k =1; 
    printf("the kth largest is %d", findKthLargest(arr,size,k));
}
void swap(int *a, int *b) 
{ 
    int temp = *a; 
    *a = *b; 
    *b = temp; 
} 
int partition(int arr[], int size){//all greater to the left and smaller to the right
    int pivot=arr[0];
    int left=0;
    int right=size-1;
    printf("the pivot is %d", pivot);
    while(left<=right){
        while(arr[left]>pivot){
            left++;
        }
        while(arr[right]<pivot){
            right--;
        }
        if(arr[left]<=arr[right]) {
            swap(&arr[left], &arr[right]); 
             
            //increment left index and decrement right index
            left++;
            right--;
        } 
    }
    return left;
    
}
/*void mergeSort(int arr[], int low, int high){
    if(low<high){
       int med=low+(high-low)/2; 
    mergeSort(arr,low, med);
    mergeSort(arr,med,high);
    merge(arr,low, med, high );
    }
}
void merge(int arr[], int low, int medium, int high){
    int l1=medium-low+1;
    int l2=high-medium;
    int leftArr[l1];
    int rightArr[l2];
    for(int i=0;i<l1;i++){
        leftArr[i]=arr[i+low];
    }
    for(int i=0;i<l2;i++){
        rightArr[i]=arr[medium+1+i];
    }
    int i=0;
    int j=0;
    int w=low;
     while (i < l1 && j < high-l2) 
    { 
        if (leftArr[i] <= rightArr[j]) 
        { 
            arr[w] = leftArr[i]; 
            i++; 
        } 
        else
        { 
            arr[w] = rightArr[j]; 
            j++; 
        } 
        w++; 
    } 

    while (i < l1) 
    { 
        arr[w] = leftArr[i]; 
        i++; 
        w++; 
    } 
  
    while (j < l2) 
    { 
        arr[w] = rightArr[j]; 
        j++; 
        w++; 
    } 
}*/
/*int findKthLargest(int nums[], int size, int k){
    if(size==1){
        return nums[0];
    }
    else if(k>0 && k<=size){
       /*mergeSort(nums,0,size-1);
       return nums[size-k];*/
        /*int med=partition(nums,size);
        printf("med is %d",med);*/
       /* if(k<med){
            return nums[k-1];
        }
        else if(med>1){
            int newNums[size-med+1];
            for(int i=med-1;i<size;i++){
              newNums[i-med+1]=nums[i];  
                
            }
            return findKthLargest(newNums, size-med+1, k-med+1);
        }
        else{
            int newNums[size-med];
            for(int i=med;i<size;i++){
                newNums[i-med]=nums[i];
            }
            return findKthLargest(newNums, size-med, k-med);
        }*/
       /*if(k==med){
            return nums[med-1];
        }
        else if(med>k){
            int newNums[size/2];
            for(int i=0;i<size/2;i++){
                newNums[i]=nums[i];
            }
            return findKthLargest(newNums,size/2,k);
            
        }
        else{
            if(size%2==1){
                int newNums[size/2+1];
                for(int i=size/2;i<size;i++){
                    newNums[i-size/2]=nums[i];
                }
                return findKthLargest(newNums,size/2+1,k-med+1);
            }
            else{
                int newNums[size/2];
                for(int i=size/2;i<size;i++){
                    newNums[i-size/2]=nums[i];
                }
                return findKthLargest(newNums,size/2,k-med+1);
            }
        }
        
    }
}*/
