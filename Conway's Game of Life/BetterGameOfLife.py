alives = set([(0, 1), (1, 2), (2, 2), (2, 1), (2, 0), (10, 10), (9, 10), (11, 10)])


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
	for r in range(minRow, maxRow + 1):
		for c in range(minCol, maxCol + 1):
			if (r, c) in alives:
				print("1 ", end = '')
			else:
				print("0 ", end = '')
		print('')


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


for x in range(50):
	display(alives)
	print("----------------------------------")
	alives = advance(alives)