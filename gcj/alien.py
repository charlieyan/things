fileName = 'alienS.in'
fo = open(fileName,'r')
dim = fo.readline().split(" ")
L = int(dim[0])
D = int(dim[1])
N = int(dim[2])
wordsSeen = 0
d = []
for i in range(L):
  d.append(dict())

def findCount(line, current, d, L):
  # base case
  #print "calling: " + current + "," + line
  if (line == "" and len(current) < L):
    return 0
  if ("(" not in line):
    return 1
  batching = False
  batch = ""
  s = 0
  for i in range(len(line)):
    if (line[i] == "("):
      batching = True
      continue
    if (line[i] == ")"):
      batching = False
      for j in batch:
        temp = current + j
        #print "temp:" + temp
        if (temp in d[len(temp)-1].keys()):
          s = s + findCount(line[i+1:], temp, d, L)
      batch = ""
      continue
    if (batching):
      batch = batch + line[i]
    else:
      current = current + line[i]


  return s

caseNum = 1
for line in fo:
  line = line.replace("\n","")
  if (wordsSeen < D):
    # for every substring of line, add to dictionary
    for s in range(len(line)):
      x = line[0:s+1]
      #print ("assigning:" + str(s) + "," + x)
      d[s][x] = ""
    wordsSeen = wordsSeen + 1
  else:
    count = findCount(line, "", d, L)
    print "Case #" + str(caseNum) + ": " + str(count)
    caseNum = caseNum + 1
