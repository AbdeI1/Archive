import time


# alives = set([(0,-4),(1,-4),(0,-3),(1,-3),(0,6),(1,6),(2,6),(3,7),(4,8),(4,9),(1,10),(-1,7),(-2,8),(-2,9),(-1,11),(3,11),\
# (0,12),(1,12),(2,12),(1,13),(0,16),(-1,16),(-2,16),(0,17),(-1,17),(-2,17),(-3,18),(1,18),(1,20),(2,20),(-3,20),(-4,20),(-2,30),(-2,31),(-1,30),(-1,31)])

def boardToSet(b):
	result = set()
	for r in range(len(b)):
		for c in range(len(b[r])):
			if b[r][c] == 1:
				result.add((r, c))
	return result

board = [\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1],\
[1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]


alives = boardToSet(board)


def display(a):
	minRow = float("inf")
	minCol = float("inf")
	maxRow = float("-inf")
	maxCol = float("-inf")
	for (r, c) in a:
		minRow = min(minRow, r)
		maxRow = max(maxRow, r)
		minCol = min(minCol, c)
		maxCol = max(maxCol, c)
	try:
		for r in range(minRow, maxRow + 1):
			for c in range(minCol, maxCol + 1):
				if (r, c) in alives:
					print("O ", end = '')
				else:
					print(". ", end = '')
			print('')
	except:
		print(".")


def countAdjAlive(a, row, col):
	adj = [\
	(row + 1, col + 1), (row + 1, col), (row + 1, col - 1),\
	(row - 1, col + 1), (row - 1, col), (row - 1, col - 1),\
	(row, col + 1), (row, col - 1)]
	count = 0
	for (r, c) in adj:
		if (r, c) in a:
			count += 1
	return count


def advance(a):
	visited = set()
	newAlives = set()
	for (row, col) in a:
		adj = [\
		(row + 1, col + 1), (row + 1, col), (row + 1, col - 1),\
		(row - 1, col + 1), (row - 1, col), (row - 1, col - 1),\
		(row, col + 1), (row, col - 1)]
		adjAlive = 0
		for (r, c) in adj:
			if (r, c) in alives:
				adjAlive += 1
			else:
				if (r, c) not in visited:
					if countAdjAlive(a, r, c) == 3:
						newAlives.add((r, c))
					visited.add((r, c))
		if adjAlive == 2 or adjAlive == 3:
			newAlives.add((row, col))
	return newAlives


for x in range(100):
	display(alives)
	print("----------------------------------")
	alives = advance(alives)
	time.sleep(0.5)