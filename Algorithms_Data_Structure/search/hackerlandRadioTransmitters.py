#!/bin/python3

import sys


def hackerlandRadioTransmitters(arr, k):
    # Complete this function
    n = len(arr)
    arr.sort()
    i = 0
    transmitter = 0
    loc = 0
    while (i < n):
        transmitter+=1
        loc = arr[i] + k
        while (i < n and loc >= arr[i]):
            i+=1
        i=i-1
        loc = arr[i] + k
        while (i < n and loc >= arr[i]):
             i+=1
    return transmitter

if __name__ == "__main__":
    n, k = input().strip().split(' ')
    n, k = [int(n), int(k)]
    x = list(map(int, input().strip().split(' ')))
    result = hackerlandRadioTransmitters(x, k)
    print(result)
