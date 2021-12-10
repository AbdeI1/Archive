def reader():
	f = open("Day10input.txt", 'r').read()
	f = f.split('\n')
	f = f[:-1]
	return f

def part1():
	f = reader()
	s = 0
	points = {')':3, ']':57, '}':1197, '>':25137}
	for l in f:
		stack = []
		for c in l:
			if c in {'(','{','[','<'}:
				stack.append(c)
			else:
				t = stack.pop()
				if t == '(' and c != ')':
					s += points[c]
				if t == '[' and c != ']':
					s += points[c]
				if t == '{' and c != '}':
					s += points[c]
				if t == '<' and c != '>':
					s += points[c]
	print(s)

def part2():
	f = reader()
	clean = []
	for l in f:
		clean.append(l)
		stack = []
		for c in l:
			if c in {'(','{','[','<'}:
				stack.append(c)
			else:
				t = stack.pop()
				if t == '(' and c != ')':
					clean.pop()
					break
				if t == '[' and c != ']':
					clean.pop()
					break
				if t == '{' and c != '}':
					clean.pop()
					break
				if t == '<' and c != '>':
					clean.pop()
					break
	scores = []
	for l in clean:
		stack = []
		for c in l:
			if c in {'(','{','[','<'}:
				stack.append(c)
			else:
				stack.pop()
		points = {'(':1, '[':2, '{':3, '<':4}
		stack.reverse()
		s = 0
		for c in stack:
			s *= 5
			s += points[c]
		scores.append(s)
	scores.sort()
	print(scores[len(scores)//2])
	

part1()
part2()
