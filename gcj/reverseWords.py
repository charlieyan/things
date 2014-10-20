def reverseWord(s):
  # reverse a string with words by word in O(n) time
  return " ".join(s.split(" ")[::-1])

fileName = 'reverseS.in'
fo = open(fileName,'r')
num = fo.readline()
n = 0
for line in fo:
  n = n + 1
  ans = reverseWord(line.replace("\n",""))
  print "Case #" + str(n) + ": " + ans