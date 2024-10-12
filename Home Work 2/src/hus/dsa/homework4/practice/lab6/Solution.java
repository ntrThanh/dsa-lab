package hus.dsa.homework4.practice.lab6;

public class  Solution
{
    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
        if (front == null) {
            front = new QueueNode(a);
            rear = front;
        } else {
            QueueNode node = new QueueNode(a);
            rear.next = node;
            rear = rear.next;
        }
        // Your code here
    }

    //Function to pop front element from the queue.
    int pop()
    {
        if (front == null) {
            return -1;
        }

        int data = front.data;
        front = front.next;

        return data;
        // Your code here
    }
}
