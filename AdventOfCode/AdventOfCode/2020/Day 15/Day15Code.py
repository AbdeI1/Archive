def part1():
	f = [2, 0, 1, 9, 5, 19]
	i = len(f)
	d = {2 : 0, 0 : 1, 1 : 2, 9 : 3, 5 : 4, 19 : 5}
	while i < 2020:
		d[f[i - 2]] = i - 2
		if f[i - 1] not in f[0 : len(f) - 1]:
			f.append(0)
		else:
			age = i - d[f[i - 1]] - 1
			f.append(age)
		i += 1
	print(f[len(f) - 1])


def part2():
	f = [2, 0, 1, 9, 5, 19]
	i = len(f)
	d = {2 : 0, 0 : 1, 1 : 2, 9 : 3, 5 : 4, 19 : 5}
	while i < 30000000:
		print(i)
		d[f[i - 2]] = i - 2
		if f[i - 1] not in f[0 : len(f) - 1]:
			f.append(0)
		else:
			age = i - d[f[i - 1]] - 1
			f.append(age)
		i += 1
	print(f[len(f) - 1])


def fasterPart2():
	f = [2, 0, 1, 9, 5, 19]
	i = len(f)
	d = {2 : 0, 0 : 1, 1 : 2, 9 : 3, 5 : 4, 19 : 5}
	m = 5
	n = 19
	while i < 30000000:
		print(i)
		d[m] = i - 2
		if n not in d:
			m = n
			n = 0
		else:
			m = n
			n = i - d[n] - 1
		i += 1
	print(n)


fasterPart2()