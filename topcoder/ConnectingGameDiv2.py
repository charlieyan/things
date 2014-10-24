#SRM 637 DIV2, 1000
from copy import deepcopy

class ConnectingGameDiv2:

  rowBoundsDict = dict() # minRow, maxRow tuple
  countDict = dict()
  rowRegions = []
  sortedByCount = []
  calledDict = dict()

  def recurseCut(self, numCells, colored, numOpenRow,lowestSolution):
    # numOpenRow array, each cell is number of unshaded per row
    # lowestSolution is for pruning
    # returns -1 (no solution), or min numCells
    # stopping condition: numOpenRow contains 0
    if (str(numOpenRow) in self.calledDict.keys()):
      return lowestSolution

    self.calledDict[str(numOpenRow)] = 1
    
    if numCells >= lowestSolution:
      return lowestSolution

    if (0 in numOpenRow):
      return numCells

    # for each not colored sorted by cells, call recurseCut on it
    low = lowestSolution
    for i in range(len(colored)):
      if (colored[i] == 0):
        coloredCp = deepcopy(colored)
        coloredCp[i] = 1
        l = self.sortedByCount[i][0]
        numOpenRowCp = deepcopy(numOpenRow)
        rowRange = self.rowBoundsDict[l]
        for j in range(rowRange[0],rowRange[1]+1):
          numOpenRowCp[j] = numOpenRowCp[j] - 1
        c = self.countDict[l]
        result = self.recurseCut(numCells+c, coloredCp, numOpenRowCp, low)
        if result > 0 and result < low:
          low = result
    return low

  def getmin(self, board):
    # walk through board, updating row, col range for each letter
    # also keep track of number of cells in each letter
    # snuke wins by default, so try to block sothe has a path 
    self.rowBoundsDict = dict() # minRow, maxRow tuple
    self.countDict = dict()
    self.rowRegions = []
    self.sortedByCount = []
    self.calledDict = dict()
    numRows = len(board)
    lowestSolution = 2500 # 50*50
    for i in range(len(board)):
      self.rowRegions.append(dict())
      for j in range(len(board[i])):
        l = board[i][j]
        #update rowbounds
        if (l in self.rowBoundsDict.keys()):
          r = self.rowBoundsDict[l]
          self.rowBoundsDict[l] = (r[0],i)
        else:
          self.rowBoundsDict[l] = (i,i)
        #update counts
        if (l in self.countDict.keys()):
          self.countDict[l] = self.countDict[l] + 1
        else:
          self.countDict[l] = 1
        # update row regions
        if (l not in self.rowRegions[i].keys()):
          self.rowRegions[i][l] = 1

    # sort ascending by size, try to cutoff one entire row or column
    # decrement all rows by 1 or all cols by 1 (perfect cut)
    self.sortedByCount = sorted(self.countDict.items(), key=lambda x: x[1])
    colored = [0]*len(self.sortedByCount)
    counts = [0]*len(self.rowRegions)
    for i in range(len(self.rowRegions)):
      counts[i] = len(self.rowRegions[i].keys())

    return self.recurseCut(0, colored, counts, lowestSolution)
    # start recursive search on each region
    # recurseCut(0, [0,0,0], [1,2], 2500)
    # which will cut by C first, then B, then A
      # recurseCut(1, [1,0,0], [1,1], 2500)
        # which will cut by B, returned 2
          # recurseCut(2, [1,1,0], [1,0], 2500)
            # which will return 2
        # which will cut by A, returned 3
          # recurseCut(3, [1,0,1], [0,1], 2500)
            # which will return 3
        # which will return min(2,3) = 2
      # recurseCut(1, [0,1,0], [1,1], 2)
        # which will eventually return 2, cutting by B,C, and avoid A
      # recurseCut(2, [0,0,1], [0,1], 2)
        # which will return 2 immediately
      # returns 2

#testing
c = ConnectingGameDiv2()
r1 = (
  "AA",
  "BC")
print c.getmin(r1)

r2 = (
  "AAB",
  "ACD",
  "CCD")
print c.getmin(r2)

r3 = (
  "iii",
  "iwi",
  "iii")
print c.getmin(r3)

r4 = (
  "rng58",
  "Snuke",
  "Sothe")
print c.getmin(r4)

# r5 = (
#   "yyAArJqjWTH5",
#   "yyEEruYYWTHG",
#   "hooEvutpkkb2",
#   "OooNgFFF9sbi",
#   "RRMNgFL99Vmm",
#   "R76XgFF9dVVV",
#   "SKnZUPf88Vee")
# print c.getmin(r5)

r6 = (
  "abcd",
  "efgh",
  "ijkl",
  "mnop")
print c.getmin(r6)
