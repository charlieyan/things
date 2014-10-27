# SRM 635 DIV 2 250, 75 pts
class IdentifyingWood:
  def check(self, s, t):
    goodMsg = "Yep, it's wood."
    badMsg = "Nope."
    if (len(s) < len(t)):
      return badMsg
    # iterate through s, find all characters in t
    currentT = 0
    for i in range(len(s)):
      if (s[i] == t[currentT]):
        currentT = currentT + 1
      if (currentT == len(t)):
        break
    if (currentT == len(t)):
      return goodMsg
    else:
      return badMsg

# testing
i = IdentifyingWood()
s = "absdefgh"
t = "asdf"

print i.check(s, t)

print i.check("oxoxoxox","ooxxoo")

print i.check("oxoxoxox","xxx")

print i.check("qwerty","qwerty")

print i.check("string","longstring")