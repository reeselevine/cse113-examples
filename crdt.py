class Process:

    def __init__(self, n, _id):
        self.id = _id
        self.n = n
        self.counter = [0 for i in range(n)]

    def read(self):
        return sum(self.counter)

    def update(self):
        self.counter[self.id] += 1

    def merge(self, p):
        for i in range(self.n):
            self.counter[i] = max(self.counter[i], p.counter[i])


N = 3

p0 = Process(N, 0)
p1 = Process(N, 1)
p2 = Process(N, 2)

def printCurState():
    print("")
    print("Current state:")
    print("p0: " + str(p0.read()))
    print("p1: " + str(p1.read()))
    print("p2: " + str(p2.read()))


print("Running CRDT with " + str(N) + " processes")
print("Updating p0 and p1")
p0.update()
p1.update()

printCurState()
print("Merging p0 with p1")
p1.merge(p0)
printCurState()
print("Merging p1 with p2")
p2.merge(p1)
printCurState()
print("Merging p1 with p0")
p0.merge(p1)
printCurState()