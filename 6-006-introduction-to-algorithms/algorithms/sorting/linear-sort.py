def counting_sort(A): 
  "Sort A assuming items have non-negative keys" 
  u = 1 + max([x['key'] for x in A]) # O(n) find maximum key 
  D = [[] for i in range(u)] # O(u) direct access array of chains 
  for x in A: # O(n) insert into chain at x.key 
    D[x['key']].append(x) 
    i = 0 
  for chain in D: # O(u) read out items in order 
    for x in chain: 
      A[i] = x 
      i += 1 
l= [32, 3, 44, 42, 22]
A=[{'key':x} for x in l]

counting_sort(A)

print(A)
