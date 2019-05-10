/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <stdio.h>
#include <math.h>
/*int findRotationNo(int nums[], int size);
int main(int argc, char** argv) {
int arr[] = {2,3,4,6,8,1}; //{6,12,15,18,2}
int size=sizeof arr/sizeof arr[0];
printf("rotation num is %d", findRotationNo(arr, size));
}

int findRotationNo(int nums[], int size){
    //int size=sizeof(nums)/4;    
    int mid=size/2;
    if(size-1<=0){
        return 0;
    }
    else if(size-1==0){
        return 1;
    }
    else if(mid<size-1&&nums[mid+1]<nums[mid]){
        return mid+1;
    }
    else if(mid>0&&nums[mid]<nums[mid-1]){
        return mid;
    }
    else{
        if(size%2==1){
            
            if(nums[size-1]>nums[mid]){
                int newsNums[mid];
                for(int i=0;i<mid;i++){
                    newsNums[i]=nums[i];
                }
                return findRotationNo(newsNums,mid);
            }
            else{
                int newsNums[mid+1];
                for(int i=mid;i<size;i++){
                    newsNums[i-mid]=nums[i];
                }
                return findRotationNo(newsNums,mid+1);
            }
            
        }
        else{
            int newsNums[mid];
            if(nums[size-1]>nums[mid]){
                for(int i=0;i<mid;i++){
                    newsNums[i]=nums[i];
                }
            }
            else{
                for(int i=mid;i<size;i++){
                    newsNums[i-mid]=nums[i];
                }
            }
            return findRotationNo(newsNums,mid);
        }
    }
}*/