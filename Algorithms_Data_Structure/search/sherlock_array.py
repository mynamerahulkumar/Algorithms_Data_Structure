#!/bin/python3
#first element and 2nd sum third num onwards .add to 1st num and sub from 2nd sum
import sys

def solve(a):
    # Complete this function
    sumLeft=a[0]
    sumRight=0
    if(len(a)==1):
        return "YES"
    for i in range(2,len(a)):
        sumRight+=a[i]
    k=1    
   # print(sumLeft,sumRight)
    for i in range(2,len(a)):
        if(sumLeft==sumRight):
            return "YES"
        if(sumLeft>sumRight):
            return "NO"
        sumLeft+=a[k]
        k+=1
        sumRight-=a[i]
    return "NO"

T = int(input().strip())
for a0 in range(T):
    n = int(input().strip())
    a = list(map(int, input().strip().split(' ')))
    result = solve(a)
    print(result)
