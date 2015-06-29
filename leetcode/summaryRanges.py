class Solution:
    def patchRange(self, range, x):
        tokens = range.split("->")
        if (len(tokens) == 2):
            tokens[1] = str(x)
        else:
            tokens.append(str(x))
        return "->".join(tokens)

    # @param {integer[]} nums
    # @return {string[]}
    def summaryRanges(self, nums):
        res = []
        if (len(nums) == 0):
            return res
        lastNum = nums[0]
        currentStr = str(lastNum)
        for i in xrange(1, len(nums)):
            x = nums[i]
            if ( (x - lastNum) == 1):
                currentStr = self.patchRange(currentStr, x)
            else:
                res.append(currentStr)
                currentStr = str(x)
            lastNum = x
        res.append(currentStr)
        return res

s = Solution()
arr1 = []
arr2 = [1]
arr3 = [1,2,3]
arr4 = [1,3,5]
arr5 = [1,2,3,5,7]
arr6 = [1,2,3,5,7,8,9]

print s.summaryRanges(arr1)
print s.summaryRanges(arr2)
print s.summaryRanges(arr3)
print s.summaryRanges(arr4)
print s.summaryRanges(arr5)
print s.summaryRanges(arr6)
        