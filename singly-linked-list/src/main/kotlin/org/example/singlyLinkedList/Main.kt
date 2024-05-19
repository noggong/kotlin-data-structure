package org.example.singlyLinkedList

fun main(args: Array<String>) {
    val singlyList = SinglyLinkedList()
    singlyList.addNode(1)
    singlyList.addNode(2)
    singlyList.addNode(3)
    singlyList.printList()
}

class Node(val value: Int) {
    var next: Node? = null
}

class SinglyLinkedList {
    var head: Node? = null

    fun addNode(value: Int) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            return
        }

        var curr = head
        while(curr?.next != null) {
            curr = curr.next
        }

        curr?.next = newNode
    }

    fun deleteNode(value: Int) {
        if(head?.value == value) {
            head = head?.next
            return
        }

        var curr = head
        while(curr?.next != null) {
            if(curr.next!!.value == value) {
                curr.next = curr.next?.next
                return
            }
        }
    }

    fun printList() {
        var curr = head
        while(curr != null) {
            print("${curr.value} -> ")
            curr = curr.next
        }
        println("null")
    }
}