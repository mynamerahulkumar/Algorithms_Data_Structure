#!/bin/python3

import sys


def marcsCakewalk(calorie):
    # Complete this function
    calorie.sort()
    total = 0    
    n = len(calorie)
    i = n-1
    j=0
    while(i>=0):
        total += (2**j)*calorie[i]
        i -= 1
        j +=1
    return total


if __name__ == "__main__":
    n = int(input().strip())
    calorie = list(map(int, input().strip().split(' ')))
    result = marcsCakewalk(calorie)
    print(result)
