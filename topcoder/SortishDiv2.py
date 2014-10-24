# SRM 636 DIV 2 500 : 150.71 points got stuck trying to find something better
from itertools import permutations

class SortishDiv2:

  def s(self, arr):
    count = 0
    for i in range(len(arr)):
      for j in range(i+1,len(arr)):
        if arr[i] < arr[j]:
          count = count + 1
    return count    

  def ways(self, sortedness, seq):
    present = [0]*len(seq)
    idxes = []
    for i in range(len(seq)):
      if seq[i] != 0:
        present[seq[i]-1] = 1
      else:
        idxes.append(i)
    missing = []
    for i in range(len(present)):
      if present[i] == 0:
        missing.append(i+1)

    if len(missing) == 0:
      if self.s(seq) == sortedness:
        return 1

    ways = 0
    seq = list(seq)
    x = list(permutations(missing))
    for perm in x:
      # assign
      for i in range(len(idxes)):
        seq[idxes[i]] = perm[i]
      ways = ways + (self.s(seq) == sortedness)
    return ways



#testing
s = SortishDiv2()
t1 = (4,0,0,2,0)
print s.ways(5,t1)

t2 = (1,3,2)
print s.ways(2,t2)



    
