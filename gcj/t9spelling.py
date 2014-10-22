t9 = ['','abc','def','ghi','jkl','mno','pqrs','tuv','wxyz',' ']
t9dict = dict()
for i in range(len(t9)):
  t = t9[i]
  for j in range(len(t)):
    l = t[j]
    t9dict[l] = str((i+1)%10)*(j+1)

def t9Spell(t9dict, s):
  out = ''
  currentNum = -1
  for i in range(len(s)):
    l = s[i]
    press = t9dict[l]
    if (press[0] == currentNum):
      out = out + " "
    out = out + press
    currentNum = press[0]
  return out

fileName = 't9spellingL.in'
fileName = 't9spellingS.in'
fo = open(fileName,'r')
num = fo.readline()
n = 0
for line in fo:
  n = n + 1
  line = line.replace("\n","")
  ans = t9Spell(t9dict,line)
  print "Case #" + str(n) + ": " + ans