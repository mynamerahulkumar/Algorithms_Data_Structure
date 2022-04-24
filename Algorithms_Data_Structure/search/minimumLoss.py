#!/bin/python3

import sys
#using hash map
def minimumLoss(price):
    # Complete this function
    min_diff=0
    min_dict={}
    for i in range(len(price)):
    	min_dict[price[i]]=i
    price.sort()
    min_cost=10**10
    for i in range(1,len(price)):
    	if((price[i]-price[i-1])<min_cost and min_dict[price[i]]<min_dict[price[i-1]]):
    		min_cost=price[i]-price[i-1]
    return min_cost
if __name__ == "__main__":
    n = int(input().strip())
    price = list(map(int, input().strip().split(' ')))
    result = minimumLoss(price)
    print(result)
