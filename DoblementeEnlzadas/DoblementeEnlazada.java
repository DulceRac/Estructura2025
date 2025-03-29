package umg.edu.progra.listas.doblementeEnlazada;

class Nodo {
    int data;
    Nodo next;
    Nodo prev;
    
    public Nodo(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoblementeEnlazada {

    private Nodo head;
    private Nodo tail;

    public DoblementeEnlazada() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtEnd(int data) {
        Nodo newNode = new Nodo(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtBeginning(int data) {
        Nodo newNode = new Nodo(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public boolean delete(int data) {
        Nodo current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    } else {
                        head = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean search(int data) {
        Nodo current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayForward() {
        Nodo current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        Nodo current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public int count() {
        int count = 0;
        Nodo current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean insertAfter(int key, int data) {
        if (head == null) {
            insertAtBeginning(data);
            return true;
        }
        Nodo current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        Nodo newNode = new Nodo(data);
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        return true;
    }

    public void reverse() {
        Nodo current = head;
        Nodo temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
}


