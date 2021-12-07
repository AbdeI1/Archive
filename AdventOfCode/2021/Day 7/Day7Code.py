def reader():
	f = open("Day7input.txt", 'r').read()
	f = f.split('\n')
	f = f[:-1]
	return f

def part1():
	f = reader()
	crabs = list(map(int,f[0].split(',')))
	m = 10000000
	for i in range(1914):
		f = 0
		for c in crabs:
			f += abs(c - i)
		m = min(m, f)
	print(m)

def part2():
	f = reader()
	crabs = list(map(int,f[0].split(',')))
	m = 100000000
	for i in range(1914):
		f = 0
		for c in crabs:
			s = abs(c-i)
			f += int((s*(s+1))/2)
		m = min(m, f)
	print(m)

part1()
part2()
