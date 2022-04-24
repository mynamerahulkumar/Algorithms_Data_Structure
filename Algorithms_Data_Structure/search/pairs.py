#!/bin/python3
#sort the list and find the diff 
import sys

def pairs(k, arr):
    # Comlplete this function
    arr.sort()
    count=0
    i=0
    j=1
    n=len(arr)
    while(j<n):
        diff=arr[j]-arr[i]
        if(diff==k):
            count+=1
            j+=1
        elif(diff>k):
            i+=1;
        elif(diff<k):
            j+=1
    return count

if __name__ == "__main__":
    n, k = input().strip().split(' ')
    n, k = [int(n), int(k)]
    arr = list(map(int, input().strip().split(' ')))
    result = pairs(k, arr)
    print(result)
