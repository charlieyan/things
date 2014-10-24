#SRM 637 DIV2, 500
class PathGameDiv2:

  def dfs(self, start, board, target):
    # dfs, return number of cells in path
    currentRow = -1
    currentCol = -1
    count = 0
    stack = []
    stack.append(start)
    visited = dict()
    while (currentCol < target and len(stack) > 0):
      current = stack.pop()
      k = str(current[0]) + "," + str(current[1])
      if (k in visited.keys()):
        continue
      currentRow = current[0]
      currentCol = current[1]
      visited[k] = 1
      count = count + 1
      if (currentRow-1 > -1 and board[currentRow-1][currentCol] == '.'):
        stack.append((currentRow-1,currentCol))
      if (currentRow+1 < 2 and board[currentRow+1][currentCol] == '.'):
        stack.append((currentRow+1,currentCol))
      if (currentCol+1 <= target and board[currentRow][currentCol+1] == '.'):
        stack.append((currentRow,currentCol+1))
    if (currentCol == target):
      return count
    return -1

  def calc(self, board):
    # board is a tuple of strings
    # put free items in row 0 to a list
    # put free items in row 1 to a list
    total = 0
    target = len(board[0])-1
    for j in range(len(board)):
      for i in range(len(board[j])):
        if (board[j][i] == '.'):
          total = total + 1
    # do a search for shortest path from l to r
    lowest = -1
    if (board[0][0] == '.'):
      c = self.dfs((0,0),board,target)
      if (c > 0):
        if (lowest > 0):
          lowest = max(lowest,total-c)
        else:
          lowest = total-c
    if (board[1][0] == '.'):
      c = self.dfs((1,0),board,target)
      if (c > 0):
        if (lowest > 0):
          lowest = max(lowest,total-c)
        else:
          lowest = total-c
    return lowest

#testing
p = PathGameDiv2()
b1 = (
  "#....",
  "...#.")
print p.calc(b1)

b2 = (
  "#",
  ".")
print p.calc(b2)

b3 = (
  ".",
  ".")
print p.calc(b3)

b4 = (
  "....#.##.....#...........",
  "..#......#.......#..#....")
print p.calc(b4)

