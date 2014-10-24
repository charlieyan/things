#SRM 637 DIV2, 250
class GreaterGameDiv2:
  def calc(self, snuke, sothe):
    # snuke is a tuple of integers
    # sothe is a tuple of integers
    count = 0
    for i in range(len(snuke)):
      if snuke[i] > sothe[i]:
        count = count + 1
    return count

# test
g = GreaterGameDiv2()
snuke = (1,3)
sothe = (4,2)
print g.calc(snuke,sothe)

snuke2 = (1,3,5,7,9)
sothe2 = (2,4,6,8,10)
print g.calc(snuke2,sothe2)