class ShoppingSurveyDiv2:
  def minValue(self, N, s):
    # infer total number of items in the store as sum(s)

    # 
    return sum(s)

s = ShoppingSurveyDiv2()
# print s.minValue(5, (3, 3)) # 6 purchases, 2 items, 5 customers, 1 has bought both

# print s.minValue(100,(97)) #97

# print s.minValue(10, (9,9,9,9,9)) #5

# print s.minValue(7,(1,2,3)) #0, 6 total purchases, 7 customers, noboy could have been a big shopper

# # print s.minValue(5,(3,3,3)) #0 9 total purchases, 5 customers, nobody could have bought all 3 once?
