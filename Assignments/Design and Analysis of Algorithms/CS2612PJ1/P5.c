/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#include <limits.h>

/*int findMin(int bookPages[], int bookNo, int studentNo);
bool findPossibility(int arr[], int n, int m, int min) ;
int main(){
    int bookPages[] = {12, 34, 67, 90}; 
    int n = sizeof bookPages / sizeof bookPages[0]; 
    int m = 2;  
    printf("min is %d",findMin(bookPages, n, m));
}
int findMin(int bookPages[], int bookNo, int studentNo) 
{ 
    long sum = 0; 
    if (bookNo < studentNo) 
        return -1; 
    for (int i = 0; i < bookNo; i++) 
        sum += bookPages[i]; 
  
    int start = 0, end = sum; 
    int min_page = sum; 
  
    while (start <= end) 
    { 
        int mid = (start + end) / 2; 
        if (findPossibility(bookPages, bookNo, studentNo, mid)==true) 
        { 
            min_page = fmin(min_page, mid); 
            end = mid - 1; 
        } 
  
        else
            start = mid + 1; 
    } 
    return min_page; 
} 
bool findPossibility(int arr[], int n, int m, int min) 
{ 
    int studentsNum = 1; 
    int sum = 0; 
 
    for (int i = 0; i < n; i++) 
    { 
        //check to see if there's way that we can get the min pages
        if (arr[i] > min) 
            return false; 
  //at some point when the pages assigned to one student exceeded the min page
 //increase studentNum and start fresh(another student)
        if (sum + arr[i] > min) 
        { 
            sum = arr[i]; 
            studentsNum++;
            if (studentsNum > m){ 
                return false; 
            }
        } 

        else{
            sum += arr[i]; 
        }
    } 
    return true; 
} */