package duoublyLinkedList

fun main() {

}

main()

/**
 * 이중 연결 리스트
 * * 각 노드에 이전 노드에 대한 참조, 다음 노드에 대한 참조가 있음
 * * 제네릭을 사용 하여 모든 타입의 데이터를 보유 가능
 * 필요한 기능
 * * 처음에 삽입
 * * 끝에 삽입
 * * 중간에 삽입
 * * 첫번째 삭제
 * * 끝에 삭제
 * * 중간에 삭제
 * * 사이즈를 알수 있다
*/

data class Node<T>(
    var data: T,
    var prev: Node<T>? = null,
    var next: Node<T>? = null
)

class DoublyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0

    fun insertAtBeginning(data: T) {
        val newNode = Node(
            data = data,
            prev = null,
            next = head)

        if (head == null) {
            tail = newNode
        } else {
            head.prev = newNode
        }

        head = newNode
        size = size + 1
    }

    fun insertAtEnd(data: T) {
        val newNode = Node(
            data = data,
            prev = tail,
            next = null
        )

        if (tail == null) {
            head = newNode
        } else {
            tail.next = newNode
        }

        tail = newNode
        size = size + 1
    }

    fun insertAtPosition(data: T, position: Int) {
        require(position >= 0 && position <= size) { "Invalid position" }

        when (position) {
            0 -> insertAtBeginning(data)
            size -> insertAtEnd(data)
            else -> {
                var prevNode = head
                for (i in 0 until position - 1) {
                    prevNode = prevNode.next
                }

                val newNode = Node(
                    data = data,
                    prev = prevNode,
                    next = prevNode.next
                )
                prevNode.next.prev = newNode
                prevNode.next = newNode
                size = size + 1
            }
        }
    }
}
