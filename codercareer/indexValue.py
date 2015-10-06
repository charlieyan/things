
def indexValue(strArr):
  if len(strArr) == 0:
    return None

  if len(strArr) == 1:
    return ()
  # binary search looking for a match
  mid = len(strArr)/2

