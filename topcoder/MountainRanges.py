# SRM 634 DIV 2 250 154 pts
class MountainRanges:
  def checkLeft(self, heights, i):
    if (i == 0):
      return True
    if (heights[i-1] < heights[i]):
      return True
    return False

  def checkRight(self, heights, i):
    if (i == len(heights)-1):
      return True
    if (heights[i+1] < heights[i]):
      return True
    return False
  def countPeaks(self, heights):
    peaks = 0
    for i in range(len(heights)):
      left = self.checkLeft(heights,i)
      right = self.checkRight(heights,i)
      if (left and right):
        peaks = peaks + 1
    return peaks

# testing
m = MountainRanges()
x = [5, 6, 2, 4]
print m.countPeaks(x)

x2 = [1,2,3,4,4,3,2,1]
print m.countPeaks(x2)