class Node {
  constructor(data, next) {
    this.data = data;
    this.next = next;
  }
}

class LinkedList {
  len = 0;
  last = null;
  head=null;
  constructor(data) {
    this.head = new Node(data, null);
    this.last = this.head;
    this.len++;
  }
  addFirst(data) {
    const temp=this.head;
    this.head=new Node(data,temp);
    this.len++;
  }
  addLast(data) {
    this.last.next = new Node(data, null);
    this.last = this.last.next;
    this.len++;
  }
  addNth(data, n) {
    let nthNode = this.head;
    while (n > 1) {
      nthNode = nthNode.next;
      n--;
    }
    const temp = nthNode.next;
    nthNode.next = new Node(data, temp);
    this.len++;
  }
  show(){
    let i=0;
    let node=this.head;
    while(i<this.len){
      console.log(node.data);
      node=node.next;
      i++;
    }
  }
}

let list=new LinkedList(1);
list.addLast(2);
list.addLast(4);
list.addLast(5);
list.show();
list.addFirst(0);
console.log("--------------------");
list.show();
console.log("--------------------");
list.addNth(3,3);
list.show();
console.log("--------------------");
list.addLast(6);
list.show();
console.log("--------------------");
list.addLast(7);
list.show();
console.log("--------------------");
console.log(list.len);
