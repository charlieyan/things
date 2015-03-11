# SRM 635 DIV 2 500 281 pts
import math
class QuadraticLaw:
  def getTime(self, d):
    print "d: " + str(d)
    # take square root of d
    s = int(math.floor(math.sqrt(d)))
    t = s + s * s
    while (t > d):
      s = s - 1
      t = s + s * s
    return s

# testing
q = QuadraticLaw()
print q.getTime(1)

print q.getTime(2)

print q.getTime(5)

print q.getTime(6)

print q.getTime(7)

print q.getTime(1482)

print q.getTime(1000000000000000000)

print q.getTime(31958809614643170)

