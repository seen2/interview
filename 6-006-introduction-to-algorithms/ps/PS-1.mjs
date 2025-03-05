/*
Given  a  linked list  containing  the names  of  the  2n kids,  in  order  of the  original  line 
formed in front of Jen’s truck (where the first node contains the name of the first kid in 
line), describe an O(n)-time algorithm to modify the linked list to reverse the order of 
the last half of the list.  Your algorithm should not make any new linked list nodes or 
instantiate any new non-constant-sized data structures during its operation. 

------------------ALGORITHM---------------------
nthNode=list;
head=null
for i=0 to 2n
  if i = 2n-1
    head=ntNode.next
  if i>=n
    temp=nthNode.next.next
    nthNode.next.next=nthNode
    if i=n
      nthNode.next=null
    nthNode=temp
  nthNode=nthNode.next
// RECURSIVE

*/

import { LinkedList } from "../data_structures/linked-list.mjs";

function reverseHalfList(list) {
  let nthNode = list;
  let newHead = null;
  let n=list.len;
  for (let i = 0; i < list.len; i++) {
    if (i == 2 * n - 1) {
      newHead = nthNode.next;
    }
    if (i >= n) {
      temp = nthNode.next.next;
      nthNode.next.next = nthNode;
      if (i == n) nthNode.next = null;
      nthNode = temp;
    }
    nthNode = nthNode.next;
  }
  newHead.len=n;
  return newHead;
}

function show(list) {
  let i = 0;
  let node = list;
  while (i < list.len) {
    console.log(i, "-->", node.data);
    node = node.next;
    i++;
  }
}

let list = new LinkedList(1);
[1,2,3,4,4,5,6,7].forEach(e=>list.addLast(e));
list.show()
halfList=reverseHalfList(list);
show(halfList);

