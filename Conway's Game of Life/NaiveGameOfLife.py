board = [\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 1, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 1, 0, 0, 0, 0],\
[0, 0, 0, 1, 1, 1, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],]

def printm(b):
	for x in b:
		print(x)


def countAdjAlive(b, row, col):
	adj = [\
	(row + 1, col + 1), (row + 1, col), (row + 1, col - 1),\
	(row - 1, col + 1), (row - 1, col), (row - 1, col - 1),\
	(row, col + 1), (row, col - 1)]
	count = 0
	for (r, c) in adj:
		if r < 0 or c < 0:
			continue
		try:
			count += b[r][c]
		except Exception as e:
			pass
	return count


def clone(b):
	newb = []
	for row in b:
		temp = []
		for e in row:
			temp.append(e)
		newb.append(temp)
	return newb


def advance(b):
	newb = clone(b)
	for r in range(len(b)):
		for c in range(len(b[r])):
			adjAlive = countAdjAlive(b, r, c)
			if b[r][c] == 1:
				if not (adjAlive == 2 or adjAlive == 3):
					newb[r][c] = 0
			else:
				if adjAlive == 3:
					newb[r][c] = 1
	return newb



for x in range(10):
	printm(board)
	print("----------------------------------")
	board = advance(board)


