class Solution:
    def generateValIndexPair(self, nums): 
        arr = []
        for i in xrange(len(nums)):
            arr.append([i, nums[i]])
        return arr

    # @param {integer[]} nums
    # @param {integer} k
    # @return {boolean}
    def containsNearbyDuplicate(self, nums, k):
        if (len(nums) < 2):
            return False
        nums = sorted(self.generateValIndexPair(nums), key=lambda x: x[1]) # O( n ) + O ( n lg n)
        latestVal = nums[0][1]
        for i in xrange(1, len(nums)):
            x = nums[i][1]
            if (x == latestVal):
                distance = abs( nums[i][0] - nums[i-1][0] )
                if (distance <= k):
                    return True
            latestVal = x
        return False

arr1 = [1,2,3,4,1]
s = Solution()
print s.containsNearbyDuplicate(arr1, 2)
print s.containsNearbyDuplicate(arr1, 3)
print s.containsNearbyDuplicate(arr1, 4)
print s.containsNearbyDuplicate(arr1, 5)
