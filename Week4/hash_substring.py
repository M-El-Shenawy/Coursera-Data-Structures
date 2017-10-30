p = 1000000007 
x = 263
def read_input():
	return (input().rstrip(), input().rstrip())

def print_occurrences(output):
	print(' '.join(map(str, output)))

def hashComp(s):
	hash = 0 
	for c in reversed(s):
	    hash = (hash * x + ord(c)) % p 
	return hash

def preHashs(text , len_pattern):
	Hash = [None] * (len(text) - len_pattern + 1)
	Sub = text[len(text) - len_pattern:]
	Hash[len(text) - len_pattern] = hashComp(Sub)
	y = 1 
	for i in range(len_pattern):
	    y = (y * x ) % p 
	for i in range(len(text) - len_pattern -1 , -1 , -1):
	    Hash[i] = (x * Hash[i+1] + ord(text[i]) - y * ord(text[i+ len_pattern])) % p
	return Hash
def get_occurrences(pattern, text):
	output = []
	h = hashComp(pattern)
	H = preHashs(text , len(pattern))
	for i in range(len(text) - len(pattern)+1):
		if(h == H[i] and (text[i:i + len(pattern)] == pattern)):
		   output.append(i)
	return output
	

if __name__ == '__main__':
	print_occurrences(get_occurrences(*read_input()))

