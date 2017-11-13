# python3

import sys, threading
sys.setrecursionlimit(10**6) # max depth of recursion
threading.stack_size(2**27)  # new thread will get stack of such size

class TreeOrders:
	def read(self):
		self.n = int(sys.stdin.readline())
		self.key = [0 for i in range(self.n)]
		self.left = [0 for i in range(self.n)]
		self.right = [0 for i in range(self.n)]
		for i in range(self.n):
			[a, b, c] = map(int, sys.stdin.readline().split())
			self.key[i] = a
			self.left[i] = b
			self.right[i] = c

	def inOrder(self):
		result = []
		# Finish the implementation
		# You may need to add a new recursive method to do that
		def inOrderRec(i,result):
			if self.left[i] != -1:
				inOrderRec(self.left[i], result)
			result.append(self.key[i])
			if self.right[i] != -1:
				inOrderRec(self.right[i], result)
		inOrderRec(0, result)
					
		return result

	def preOrder(self):
		result = []
		# Finish the implementation
		# You may need to add a new recursive method to do that
		def preOrderRec(i,result):
			result.append(self.key[i])
			if self.left[i] != -1:
				preOrderRec(self.left[i], result)
			if self.right[i] != -1:
				preOrderRec(self.right[i], result)
		preOrderRec(0, result)
					
		return result

	def postOrder(self):
		result = []
		# Finish the implementation
		# You may need to add a new recursive method to do that
		def postOrderRec(i,result):
			if self.left[i] != -1:
				postOrderRec(self.left[i], result)
			if self.right[i] != -1:
				postOrderRec(self.right[i], result)
			result.append(self.key[i])
		postOrderRec(0, result)
					
		return result

def main():
	tree = TreeOrders()
	tree.read()
	print(" ".join(str(x) for x in tree.inOrder()))
	print(" ".join(str(x) for x in tree.preOrder()))
	print(" ".join(str(x) for x in tree.postOrder()))

threading.Thread(target=main).start()
