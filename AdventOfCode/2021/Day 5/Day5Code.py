def reader():
	f = open("Day5input.txt", 'r').read()
	f = f.split('\n')
	f = f[:-1]
	return f

def part1():
	f = reader()
	d = {}
	for l in f:
		ps = l.split(' -> ')
		p1 = ps[0].split(',')
		p2 = ps[1].split(',')
		if int(p1[0]) == int(p2[0]):
			for i in range(min(int(p1[1]), int(p2[1])), max(int(p1[1]), int(p2[1])) + 1):
				if (int(p1[0]), i) in d:
					d[(int(p1[0]), i)] += 1
				else:
					d[(int(p1[0]), i)] = 1
			continue
		if int(p1[1]) == int(p2[1]):
			for i in range(min(int(p1[0]), int(p2[0])),max(int(p1[0]), int(p2[0])) + 1):
				if (i, int(p1[1])) in d:
					d[(i, int(p1[1]))] += 1
				else:
					d[(i, int(p1[1]))] = 1
	count = 0
	for di in d:
		if d[di] != 1:
			count += 1
	print(count)


def part2():
	f = reader()
	d = {}
	for l in f:
		ps = l.split(' -> ')
		p1 = ps[0].split(',')
		p2 = ps[1].split(',')
		if int(p1[0]) == int(p2[0]):
			for i in range(min(int(p1[1]), int(p2[1])), max(int(p1[1]), int(p2[1])) + 1):
				if (int(p1[0]), i) in d:
					d[(int(p1[0]), i)] += 1
				else:
					d[(int(p1[0]), i)] = 1
			continue
		if int(p1[1]) == int(p2[1]):
			for i in range(min(int(p1[0]), int(p2[0])),max(int(p1[0]), int(p2[0])) + 1):
				if (i, int(p1[1])) in d:
					d[(i, int(p1[1]))] += 1
				else:
					d[(i, int(p1[1]))] = 1
			continue
		i = int(p1[0])
		j = int(p1[1])
		while i != int(p2[0]):
			if (i, j) in d :
				d[(i,j)] += 1
			else:
				d[(i, j)] = 1
			if int(p2[0]) < int(p1[0]):
				i -= 1
			else:
				i += 1
			if int(p2[1]) < int(p1[1]):
				j -= 1
			else:
				j += 1
		if (i, j) in d :
			d[(i,j)] += 1
		else:
			d[(i, j)] = 1
	count = 0
	for di in d:
		if d[di] != 1:
			count += 1
	print(count)

part1()
part2()
