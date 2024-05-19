package org.example.binaryTree

fun main(args: Array<String>) {
    println("Hello, World!")
    val bt = BinarySearchTree()

    bt.insert(40)
    bt.insert(59)
    bt.insert(23)
    bt.insert(11)
    bt.insert(33)
    bt.insert(9)
    bt.insert(62)
    bt.insert(32)
    bt.insert(19)
    bt.printlnOrder()
}

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinarySearchTree {
    var root: Node? = null

    fun insert(value: Int) {
        val newNode = Node(value)

        if (root === null) {
            root = newNode
            return
        }

        var curr = root!!
        while(true) {
            if (value < curr.value) {
                if (curr.left == null) {
                    curr.left = newNode
                    return
                }
                curr = curr.left!!

            } else {
                if (curr.right == null) {
                    curr.right = newNode
                    return
                }
                curr = curr.right!!
            }
        }
    }

    fun delete(value: Int) {
        root = deleteRecursive(root, value)
    }

    fun deleteRecursive(curr: Node?, value: Int): Node? {
        if (curr == null) {
            return null
        }

        if (value === curr.value) {
            if(curr.left == null) {
                return curr.right
            }

            if (curr.right == null) {
                return curr.left
            }

            val successor = findSuccessor(curr.right)
            curr.value = successor!!
            curr.right = deleteRecursive(curr.right, successor)

        } else if (value < curr.value) {
            curr.left = deleteRecursive(curr.left, value)
        } else {
            curr.right = deleteRecursive(curr.right, value)
        }

        return curr
    }

    fun findSuccessor(curr: Node?): Int? {
        var successor = curr
        while(successor?.left != null) {
            successor = successor.left
        }

        return successor?.value
    }

    fun printlnOrder() {
        printlnOrderRecursive(root)
        println()
    }

    fun printlnOrderRecursive(curr: Node?) {
        if (curr == null) {
            return
        }

        printlnOrderRecursive(curr.left)
        print("${curr.value} -> ")
        printlnOrderRecursive(curr.right)
    }
}
