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
  oPos, bPos = 1
  for i in xrange(0, len(tokens), 2):
    tokens[i]

  print "Case #" + str(caseNum) +: ": " + str(s)