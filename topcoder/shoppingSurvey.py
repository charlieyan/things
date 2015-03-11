class ShoppingSurveyDiv2:

  def minValue(self, N, s):



# Test cases

inst = ShoppingSurveyDiv2()

example0 = (3, 3)
result = inst(example0)
#There are 5 customers and 2 items in the store. Each of the items was bought by three of the customers. Since there are five people and a total of six bought items, we must have at least one big shopper. And we can easily verify that there could have been exactly one big shopper and four other customers who have bought one item each.
assert( result ==  1)

example1 = (97)
result = inst(example1)
#
assert( result ==  97)

example2 = (9, 9, 9, 9, 9)
result = inst(example2)
#
assert( result ==  5)

example3 = (1, 2, 3)
result = inst(example3)
#
assert( result ==  0)

example4 = (3, 3, 3)
result = inst(example4)
#
assert( result ==  0)

