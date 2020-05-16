/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TugasJobsheet12;

/**
 *
 * @author dhimas
 */
public class MahasiswaDLL {

    Node2 head;
    int size;
    int nilai;
    String nama;

    public MahasiswaDLL() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(MahasiswaDLL item) {
        if (isEmpty()) {
            head = new Node2(null, item, null);
        } else {
            Node2 newNode = new Node2(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(MahasiswaDLL item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node2 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node2 newNode = new Node2(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(MahasiswaDLL item, int index) throws Exception {
        if (isEmpty()) {
            addFirst(item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indek di luar batas");
        } else {
            Node2 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Node2 newNode = new Node2(null, item, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Node2 newNode = new Node2(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node2 tmp = head;
            System.out.println("Nilai\t|\tNama");
            while (tmp != null) {
                System.out.println(tmp.data.nilai + "\t|\t" + tmp.data.nama);
                tmp = tmp.next;
            }
        } else {
            System.out.println("Linked lists Kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node2 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks diluar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node2 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            System.out.println(current.data);
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public MahasiswaDLL getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        return head.data;
    }

    public MahasiswaDLL getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        Node2 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public MahasiswaDLL get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas.");
        }
        Node2 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void cari(String item) {
        Node2 tmp = head;
        Boolean search = false;
        int i = 0;
        if (tmp != null) {
            if (tmp.data.nama.equalsIgnoreCase(item)) {
                search = true;
            } else if (tmp.next != null) {
                while (tmp != null) {
                    if (tmp.data.nama.equalsIgnoreCase(item)) {
                        search = true;
                        break;
                    } else {
                        tmp = tmp.next;
                    }
                    i++;
                }
            }
            if (search) {
                System.out.println("Data : " + item + " ditemukan pada indeks ke-" + i);
            } else {
                System.out.println("Data tidak berada pada linked list");
            }
        } else {
            System.out.println("Linked list kosong");
        }
    }

    Node2 bubbleSort(Node2 start) {
        int swap, i;
        Node2 a;
        Node2 b = null;
        if (start == null) {
            return null;
        }
        do {
            swap = 0;
            a = start;
            while (a.next != b) {
                if (a.data.nilai < a.next.data.nilai) {
                    MahasiswaDLL t = a.data;
                    a.data = a.next.data;
                    a.next.data = t;
                    swap = 1;
                }
                a = a.next;
            }
            b = a;
        } while (swap != 0);
        return start;
    }
}