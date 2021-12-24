def reader():
	f = open("Day24input.txt", 'r').read()
	f = f.split('\n')
	f = f[:-1]
	return f

def execute(ins, inp):
	reg = {'w': 0, 'x':0, 'y':0, 'z':0}
	j = 0
	for l in ins:
		i = l.split(' ')
		if i[0] == 'inp':
			reg[i[1]] = inp[j]
			j += 1
		elif i[0] == 'add':
			reg[i[1]] = reg[i[1]] + (reg[i[2]] if i[2] in reg else int(i[2]))
		elif i[0] == 'mul':
			reg[i[1]] = reg[i[1]] * (reg[i[2]] if i[2] in reg else int(i[2]))
		elif i[0] == 'div':
			reg[i[1]] = reg[i[1]] // (reg[i[2]] if i[2] in reg else int(i[2]))
		elif i[0] == 'mod':
			reg[i[1]] = reg[i[1]] % (reg[i[2]] if i[2] in reg else int(i[2]))
		elif i[0] == 'eql':
			reg[i[1]] = 1 if reg[i[1]] == (reg[i[2]] if i[2] in reg else int(i[2])) else 0
		else:
			print("failure: ", l)
			return reg
	return reg

def toList(i):
	res = []
	while i != 0:
		res = [i%10] + res
		i //= 10
	return res

# done by hand
# conditions:
# d7 + 1 = d8
# d2 - 5 = d5
# d3 - 7 = d4
# d9 + 5 = d10
# d11    = d12
# d6 - 3 = d13
# d1 + 6 = d14

def part1():
	f = reader()
	i = 39924989499969
	print(execute(f, toList(i)))

def part2():
	f = reader()
	i = 16811412161117
	print(execute(f, toList(i)))

part1()
part2() 

