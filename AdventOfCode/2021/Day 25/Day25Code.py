def reader():
	f = open("Day25input.txt", 'r').read()
	f = f.split('\n')
	f = f[:-1]
	return f

def step(m):
	moves = 0
	nm = [['.']*len(m[0]) for _ in range(len(m))]
	for i in range(len(m)):
		for j in range(len(m[i])):
			if m[i][j] == '>':
				if m[i][(j+1)%len(m[i])] == '.':
					moves += 1
					nm[i][(j+1)%len(m[i])] = '>'
				else:
					nm[i][j] = '>'
	for i in range(len(m)):
		for j in range(len(m[i])):
			if m[i][j] == 'v':
				if m[(i+1)%len(m)][j] != 'v' and nm[(i+1)%len(m)][j] == '.':
					moves += 1
					nm[(i+1)%len(m)][j] = 'v'
				else:
					nm[i][j] = 'v'
	return (moves, nm)


def part1():
	f = reader()
	m = list(map(list, f))
	(moves, nm) = step(m)
	count = 1
	while moves != 0:
		(moves, nm) = step(nm)
		count += 1
	print(count)

def part2():
	f = reader()

part1()
part2() 

