export class Node {
  constructor(data, next) {
    this.data = data;
    this.next = next;
  }
}

export class LinkedList {
  len = 0;
  tail = null;
  head = null;
  constructor(data) {
    this.head = new Node(data, null);
    this.tail = this.head;
    this.len++;
  }
  addFirst(data) {
    const temp = this.head;
    this.head = new Node(data, temp);
    this.len++;
  }
  addLast(data) {
    this.tail.next = new Node(data, null);
    this.tail = this.tail.next;
    this.len++;
  }
  addNth(data, n) {
    if (n == 0) {
      this.addFirst(data);
    } else if (n == this.len - 1) {
      this.addLast(data);
    } else if (n > 0 && n < this.len - 1) {
      let nthNode = this.head;
      while (n > 1) {
        nthNode = nthNode.next;
        n--;
      }
      const temp = nthNode.next;
      nthNode.next = new Node(data, temp);
      this.len++;
    } else {
      console.error("Out of bound");
    }
  }
  show() {
    let i = 0;
    let node = this.head;
    while (i < this.len) {
      console.log(i, "-->", node.data);
      node = node.next;
      i++;
    }
  }
  deleteFirst() {
    const { data } = this.head;
    this.head = this.head.next;
    this.len--;
    return data;
  }
  deleteLast() {
    console.error("Not valid operation in singly linked list");
  }
  deleteNth(n) {
    if (n == 0) {
      return this.deleteFirst();
    } else if (n >= 0 && n < this.len) {
      let nthNode = this.head;
      //we can also check if node.next!=null
      while (n > 0) {
        nthNode = nthNode.next;
        n--;
      }
      const { data } = nthNode.next;
      nthNode.next = nthNode.next.next;
      this.len--;
      return data;
    } else {
      console.error("Out of Bound");
      return null;
    }
  }
}

let list = new LinkedList(1);
list.addLast(2);
list.addLast(4);
list.addLast(5);
list.show();
list.addFirst(0);
console.log("--------------------");
list.show();
console.log("--------------------");
list.addNth(3, 3);
list.show();
console.log("--------------------");
list.addLast(6);
list.show();
console.log("--------------------");
list.addLast(7);
list.show();
list.addNth(-1, 0);
list.addNth(8, list.len - 1);
list.show();
console.log(list.len);
list.addNth(10, list.len);
console.log("-----------Check---------");
console.log(list.deleteFirst());
console.log(list.deleteLast());
console.log(list.deleteNth(6));
list.show();
