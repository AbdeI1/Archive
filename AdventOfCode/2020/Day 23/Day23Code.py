def part1():
	# sample input:
	input = "389125467"
	# actual input:
	# input = "418976235"
	f = list(map(lambda x: int(x), list(input)))
	cc = 0
	for i in range(100):
		label = f[cc]
		temps = []
		for i in range(3):
			if cc == len(f) - 1:
				temps.append(f[0])
				del f[0]
				cc = len(f) - 1
			else:
				temps.append(f[cc + 1])
				del f[cc + 1]
		print(f)
		dc = f[cc] - 1
		while dc not in f:
			if dc == 0:
				dc = 9
			else:
				dc -= 1
		f = f[:f.index(dc) + 1] + temps + f[f.index(dc) + 1 :]
		cc = (f.index(label) + 1)%len(f)
		print(f)
	answer = ""
	cc = f.index(1)
	while len(answer) < 9:
		answer += str(f[cc])
		cc = (cc + 1)%len(f)
	print(f)
	print(answer[1:])


def part2():
	# sample input:
	input = "389125467"
	# actual input:
	# input = "418976235"
	f = list(map(lambda x: int(x), list(input)))
	
	print(f)


# part1()
# part1 sample answer: 67384529
part1()
# part2 sample answer: 149245887792