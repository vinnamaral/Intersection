/*
    Kotlin program for
    Find intersection point of two linked list
*/
// Linked list node
class LinkNode {
    var data: Int;
    var next: LinkNode?;

    constructor(data: Int) {
        this.data = data;
        this.next = null;
    }
}

class SingleLL {
    var head: LinkNode?;
    var tail: LinkNode?;

    constructor() {
        this.head = null;
        this.tail = null;
    }

    fun insert(data: Int): Unit {
        val node: LinkNode = LinkNode(data);
        if (this.head == null) {
            // Add first node
            this.head = node;
        } else {
            // Add node at the end position
            this.tail?.next = node;
        }
        // New last node
        this.tail = node;
    }

    // Display linked list element
    fun display(): Unit {
        if (this.head == null) {
            return;
        }
        var temp: LinkNode? = this.head;
        // iterating linked list elements
        while (temp != null) {
            print(" " + temp.data + " →");
            // Visit to next node
            temp = temp.next;
        }
        println(" NULL");
    }

    // Count the number of nodes in linked list
    fun length(): Int {
        var temp: LinkNode? = this.head;
        var counter: Int = 0;
        // iterating linked list elements
        while (temp != null) {
            counter += 1;
            // Visit to next node
            temp = temp.next;
        }
        return counter;
    }

    // Returns a intersection node of two linked list
    // When if it is not exist then its returns a null value.
    fun intersectionNode(
        list1: LinkNode?,
        list2: LinkNode?,
        n: Int
    ): LinkNode? {
        // Get the first node of given linked lists
        var t1: LinkNode? = list1;
        var t2: LinkNode? = list2;
        // Define a counter variable
        var counter: Int = 0;
        // Skip the first n node in given first list
        while (t1 != null && counter < n) {
            // Visit to next node
            t1 = t1.next;
            counter += 1;
        }
        if (counter != n || t1 == null) {
            return null;
        } else {
            while (t1 != null && t2 != null) {
                if (t1 == t2) {
                    // When get intersection point
                    return t1;
                }
                // Visit to next node
                t1 = t1.next;
                t2 = t2.next;
            }
            return null;
        }
    }

    // Find the intersection point of given two linked lists
    fun intersectionPoint(other: SingleLL): Unit {
        // Define resultant variable
        var result: LinkNode? = null;
        // Find the length of linked list
        val l1: Int = this.length();
        val l2: Int = other.length();
        // Display given linked lists
        print("\n Linked Linked A : ");
        this.display();
        print(" Linked Linked B : ");
        other.display();
        if (l1 > 0 && l2 > 0) {
            if (l1 > l2) {
                // When the given list-1 contains more
                // nodes than list-2
                result = this.intersectionNode(
                    this.head, other.head, l1 - l2
                );
            } else {
                result = this.intersectionNode(
                    other.head, this.head, l2 - l1
                );
            }
        }
        if (result == null) {
            println(" Intersection Point are not exist");
        } else {
            println(" Intersection Point : " + result.data);
        }
    }
}

fun main(args: Array<String>): Unit {
    val list1: SingleLL = SingleLL();
    val list2: SingleLL = SingleLL();
    // Add node in first linked list
    // 1 → 5 → 3 → 2 → 7 → 11 → 4 → NULL
    list1.insert(1);
    list1.insert(5);
    list1.insert(3);
    list1.insert(2);
    list1.insert(7);
    list1.insert(11);
    list1.insert(4);
    // Add node in second linked list
    // 4 → 6 → 5 → 8 → NULL
    list2.insert(4);
    list2.insert(6);
    list2.insert(5);
    list2.insert(8);
    // Test Case
    // intersection in linked list
    //  4 → 6 → 5 → 8 → 3 → 2 → 7 → 11 → 4 → NULL
    list2.tail?.next = list1.head?.next?.next;
    list1.intersectionPoint(list2);
    //  4 → 6 → 5 → 8 → 2 → 7 → 11 → 4 → NULL
    list2.tail?.next = list1.head?.next?.next?.next;
    list1.intersectionPoint(list2);
    //  4 → 6 → 5 → 8 → 1 → 5 → 3 → 2 → 7 → 11 → 4 → NULL
    list2.tail?.next = list1.head;
    list1.intersectionPoint(list2);
    list2.tail?.next = null;
    //  1 → 5 → 3 → 2 → 7 → 11 → 4 → 6 → 5 → 8 → NULL
    list1.tail?.next = list2.head?.next;
    list1.intersectionPoint(list2);
    list1.tail?.next = null;

    //more easy in my way:
    val lista1 = listOf(1, 2, 3, 4, 5)
    val lista2 = listOf(3, 4, 5)
    val result = mutableListOf<Any>()

    //intersect
    val resultado = println("intersect: ${lista1.intersect(lista2)}")

    //first result and stop
    for (i in lista1.indices) {
        for (j in lista2.indices) {
            if (lista1[i] == lista2[j]) {
                result.add(lista1[i])
            }
        }
    }
    println("Meu intersect ${result.first()}")

}