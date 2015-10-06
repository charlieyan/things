class Solution:
    # @param {integer[]} digits
    # @return {integer[]}
    def plusOne(self, digits):
        # walk through digits from the back to the front, until no overflow is detected
        if (len(digits) == 0):
            return digits
        idx = len(digits)-1
        num = digits[idx] + 1
        quotient = num / 10
        remainder = num % 10
        digits[idx] = remainder
        while (quotient >= 1 and idx > 0):
            idx = idx - 1
            num = digits[idx] + quotient
            quotient = num / 10
            remainder = num % 10
            digits[idx] = remainder
        if (quotient >= 1):
            digitsNew = [0]*(len(digits)+1)
            for i in range(len(digits)):
                digitsNew[i+1] = digits[i]
            digitsNew[0] = quotient
            digits = digitsNew
        return digits
        
s = Solution()
digits1 = [1,2,3]
digits2 = [1,2,9]
print s.plusOne(digits1)
print s.plusOne(digits2)
digits3 = []
print s.plusOne(digits3)
digits4 = [9,9,9]
print s.plusOne(digits4)
digits4 = [0,9,9]
print s.plusOne(digits4)