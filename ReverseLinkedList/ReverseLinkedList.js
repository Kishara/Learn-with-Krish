// CREATING NODE AND LINKED LIST CLASSES
class Node {
	constructor(value, next, prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
}
class LinkedList {
	constructor() {
		this.tail = null;
		this.head = null;
	}
	//ADDING VALUES TO THE LINKEDLIST
	add(val) {
		const newNode = new Node(val, null, this.tail);

		if (this.tail) {

			this.tail.next = newNode;
		} else {
			this.head = newNode;
		}
		this.tail = newNode;
	}
	//PRINTING LINKEDLIST
	printList(head) {
		let current = head;
		while (current) {
			console.log(current.value);
			current = current.next;
		}
	}
	//REVERSING
	reverse(node) {

		if (node === null || node.next === null) {
			return node;
		}

		let rest = this.reverse(node.next);
		node.next.next = node;

		node.next = null;

		return rest;
	}
}


let LinkList = new LinkedList();

LinkList.add('A');
LinkList.add('B');
LinkList.add('C');
LinkList.add('D');
LinkList.add('E');
LinkList.add('F');
LinkList.add('G');
LinkList.add('H');
LinkList.add('I');

console.log('------- Original Values --------');
LinkList.printList(LinkList.head);

let reverdedList = LinkList.reverse(LinkList.head);

console.log('------- Reversed --------');
LinkList.printList(reverdedList);