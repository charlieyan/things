#!/usr/bin/python
import sys
fileName = sys.argv[1]
fo = open(fileName,'r')
num = fo.readline()
caseNum = 1
for line in fo:
  tokens = line.replace("\n","").split(" ")[1:]
  # solve mechanism
  result = 0
  latestActiveBot = ""
  posDict = dict()
  posDict["B"] = 1
  posDict["O"] = 1
  discountDict = dict()
  discountDict["B"] = 0
  discountDict["O"] = 0
  for i in xrange(0, len(tokens), 2):
    color = tokens[i]
    pos = int(tokens[i+1])
    # solve mechanism
    ticks = abs(pos - posDict[color])
    # always try to exhaust any discounts possible
    if (latestActiveBot != color):
      otherColor = "O"
      if (color == "O"):
        otherColor = "B"
      if (ticks >= discountDict[otherColor]):
        ticks = ticks - discountDict[otherColor]
        discountDict[otherColor] = 0 # one time use
      else:
        discountDict[otherColor] = 0 # one time use
        ticks = 0
    ticks = ticks + 1 # for click
    result = result + ticks
    posDict[color] = pos
    discountDict[color] = discountDict[color] + ticks
    latestActiveBot = color
  print "Case #" + str(caseNum) + ": " + str(result)
  caseNum = caseNum + 1
