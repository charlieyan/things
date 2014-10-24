# SRM 636 DIV 2 250, 12.5 minutes coding, 185.15 pts
class GameOfStones:

  def count(self, stones):
    if (len(stones) == 1):
      return 0
    
    total = 0
    for i in stones:
      total = total + i
    
    rem = total % len(stones)
    if (rem > 0):
      return -1

    avg = total / len(stones)
    diffs = []
    for i in stones:
      diffs.append(i-avg)
    posSum = 0
    for i in diffs:
      if (i % 2 > 0):
        return -1
      if (i > 0):
        posSum = posSum + i
    return posSum / 2

# testing
g = GameOfStones()
t1 = (7,15,9,5)
print g.count(t1)