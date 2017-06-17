# python3

import sys
import threading
sys.setrecursionlimit(10**7)  # max depth of recursion
threading.stack_size(2**27)  # new thread will get stack of such size


class TreeHeight:
        def read(self):
                self.n = int(sys.stdin.readline())
                self.parent = list(map(int, sys.stdin.readline().split()))
                self.nodes = [0] * self.n
        
        def len(self, node):
                parent = self.parent[node]
                if parent == -1:
                        return 1 
                if self.nodes[node]:
                        return self.nodes[node]
                
                self.nodes[node] = 1 + self.len(self.parent[node])
                return self.nodes[node]

        def compute_height(self):
                return max([self.len(i) for i in range(self.n)])
                

def main():
  tree = TreeHeight()
  tree.read()
  print(tree.compute_height())

threading.Thread(target=main).start()
