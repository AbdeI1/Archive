def reader():
	f = open("Day6input.txt", 'r').read()
	f = f.split('\n')
	f = f[:-1]
	return f

def part1():
	f = reader()
	timers = list(map(int,f[0].split(',')))
	fish = len(timers)
	for i in range(80):
		l = len(timers)
		for i in range(l):
			if(timers[i] == 0):
				timers[i] = 6
				fish+=1
				timers.append(8)
			else:
				timers[i] -= 1
	print(fish)

memo = [[-1]*500 for i in range(10)]

def simulate(n, t):
	if memo[n][t] != -1:
		return memo[n][t]
	if t <= 0:
		memo[n][t] = 1
		return 1
	if n == 0:
		l = simulate(6,t-1) + simulate(8, t-1)
		memo[n][t] = l
		return l
	l = simulate(n-1, t-1)
	memo[n][t] = l
	return l

def part2():
	f = reader()
	timers = list(map(int,f[0].split(',')))
	sum = 0
	for t in timers:
		sum += simulate(t, 256)
	print(sum)

part1()
part2()
