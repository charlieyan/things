class Solution:
    d = dict()

    # @param {integer} n
    # @return {integer}
    def climbStairs(self, n):
        if (n == 1):
            return 1
        elif (n == 2):
            return 2

        if (n in self.d.keys()):
            return self.d[n]
        else:
            x = self.climbStairs(n-1)+self.climbStairs(n-2)
            self.d[n] = x
            return x

s = Solution()
print s.climbStairs(100)