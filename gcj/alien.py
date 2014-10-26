fileName = 'alienS.in'
fo = open(fileName,'r')
dim = fo.readline().split(" ")
L = int(dim[0])
D = int(dim[1])
N = int(dim[2])
wordsSeen = 0
d = dict()

def findCount(line, d):
  validCombos = []
  for i in range(len(line)):
    print line[i]
  return 0

caseNum = 1
for line in fo:
  line = line.replace("\n","")
  if (wordsSeen < D):
    d[line] = ""
    wordsSeen = wordsSeen + 1
  else:
    count = findCount(line, d)
    print "Case #" + str(caseNum) + ": " + str(count)
    caseNum = caseNum + 1
