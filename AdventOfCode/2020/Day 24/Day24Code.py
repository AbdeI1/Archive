def reader():
	f = open("C:\\Users\\SSolqr\\Desktop\\Advent of Code\\Day 24\\Day24input.txt", 'r').read().split('\n')
	return f[:-1]


def part1():
	f = reader()
	flippedTiles = []
	for line in f:
		i = 0
		pos = [0, 0]
		while i < len(line):
			direction = ""
			if line[i] == 's' or line[i] == 'n':
				direction = line[i] + line[i + 1]
				i += 1
			else:
				direction = line[i]
			if direction == "ne":
				pos = [pos[0] + 0.5, pos[1] + 0.5]
			elif direction == "nw":
				pos = [pos[0] - 0.5, pos[1] + 0.5]
			elif direction == "se":
				pos = [pos[0] + 0.5, pos[1] - 0.5]
			elif direction == "sw":
				pos = [pos[0] - 0.5, pos[1] - 0.5]
			elif direction == "e":
				pos = [pos[0] + 1, pos[1]]
			elif direction == "w":
				pos = [pos[0] - 1, pos[1]]
			i += 1
		if pos not in flippedTiles:
			flippedTiles.append(pos)
		else:
			flippedTiles.remove(pos)
	print(len(flippedTiles))


def part2():
	f = reader()
	blacks = []
	for line in f:
		i = 0
		pos = [0, 0]
		while i < len(line):
			direction = ""
			if line[i] == 's' or line[i] == 'n':
				direction = line[i] + line[i + 1]
				i += 1
			else:
				direction = line[i]
			if direction == "ne":
				pos = [pos[0] + 0.5, pos[1] + 0.5]
			elif direction == "nw":
				pos = [pos[0] - 0.5, pos[1] + 0.5]
			elif direction == "se":
				pos = [pos[0] + 0.5, pos[1] - 0.5]
			elif direction == "sw":
				pos = [pos[0] - 0.5, pos[1] - 0.5]
			elif direction == "e":
				pos = [pos[0] + 1, pos[1]]
			elif direction == "w":
				pos = [pos[0] - 1, pos[1]]
			i += 1
		if pos not in blacks:
			blacks.append(pos)
		else:
			blacks.remove(pos)
	print(blacks)


def simulate(blacks):
	newBlacks = []
	for pos in blacks:
		continue



def countAround(tile, tiles):
	total = 0
	if [tile[0] + 0.5, tile[1] + 0.5] in tiles:
		total += 1
	if [tile[0] + 0.5, tile[1] - 0.5] in tiles:
		total += 1
	if [tile[0] - 0.5, tile[1] + 0.5] in tiles:
		total += 1
	if [tile[0] - 0.5, tile[1] - 0.5] in tiles:
		total += 1
	if [tile[0] + 1, tile[1]] in tiles:
		total += 1
	if [tile[0] - 1, tile[1]] in tiles:
		total += 1
	return(total)


part1()