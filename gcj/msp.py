fileName = 'mspL.in'
fileName = 'mspS.in'
fo = open(fileName,'r')
num = fo.readline()
n = 0
currentV1 = []
currentV2 = []
caseNum = 0
for line in fo:
  mode = n % 3
  line = line.replace("\n","")
  if (mode == 1):
  	currentV1 = line.split(" ")
  	for i in range(len(currentV1)):
  		currentV1[i] = int(currentV1[i])
  if (mode == 2):
    currentV2 = line.split(" ")
    for i in range(len(currentV2)):
      currentV2[i] = int(currentV2[i])
    caseNum = caseNum + 1
    s = 0
    currentV1 = sorted(currentV1)
    currentV2 = sorted(currentV2,reverse=True)
    for i in range(len(currentV1)):
      s = s + currentV1[i] * currentV2[i]
    print "Case #" + str(caseNum) + ": " + str(s)
  n = n + 1