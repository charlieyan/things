def chooseNK(arr, start, num):
  numItemsLeft = len(arr)-start
  if (numItemsLeft < num):
    return []
  elif (numItemsLeft == num):
    return [arr[start:]]
  elif (num == 1 and numItemsLeft > 0):
    out = []
    for i in range(numItemsLeft):
      out.append([arr[start+i]])
    return out
  else:
    out = []
    for i in range(numItemsLeft):
      popOut = arr[start+i]
      result = chooseNK(arr,start+i+1,num-1)
      for r in result:
        r2 = [popOut] + r
        out.append(r2)
    return out


print chooseNK([1,2,3,4],0,2)
print chooseNK([1,2,3,4,5],0,2)