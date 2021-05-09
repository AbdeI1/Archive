def min_index(l, start):
    mini = l[start]
    index = start
    i = start
    while i < len(l):
        if min(mini, l[i]) == l[i]:
            mini = l[i]
            index = i
        i += 1
    return index


def reverse(l, start, end):
    r = []
    i = end
    while i > start - 1:
        r.append(l[i])
        i -= 1
    return r


tests = int(input())
for casenum in range(tests):
    n = int(input())
    l = list(map((lambda x: int(x)), str(input()).split(" ")))
    cost = 0
    for i in range(n):
        j = min_index(l, i)
        cost += (j - i + 1)
        r = reverse(l, i, j)
        l = l[:i] + r + l[(j + 1):]
    print("Case #" + str(casenum + 1) + ": " + str(cost))


