#https://code.google.com/codejam/contest/351101/dashboard#s=p0

def solve(arr, credit):
  #returns a tuple of 2 indexes (base 0)
  d = dict();
  for i in range(len(arr)):
    k = credit-arr[i]
    if k in d.keys():
      d[k].append(i)
    else:
      d[k] = [i]
  for i in range(len(arr)):
    if arr[i] in d.keys():
      for j in d[arr[i]]:
        if (j != i):
          return (i+1,j+1)

#f = open('storeCredit_small.in','r')
f = open('A-large-practice.in','r')
# f = open('A-large-practice.in','r')
N = f.readline().replace("\n","")
STATECREDIT = 0
STATEITEMC = 1
STATEITEMS = 2
count = 0
currentCredit = None
currentCaseNum = 1
for line in f:
  s = line.replace("\n","")
  if (count is STATECREDIT):
    currentCredit = int(s)
  elif (count is STATEITEMS):
    arr = [int(st) for st in s.split(" ")]
    r = solve(arr,currentCredit)
    f = min(r[0],r[1])
    l = max(r[0],r[1])
    print "Case #" + str(currentCaseNum) + ": " + str(f) + " " + str(l)
    currentCaseNum = currentCaseNum + 1
  count = (count + 1) % 3