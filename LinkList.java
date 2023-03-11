package NEW;

import javax.swing.JTextField;

public class LinkList{
   ListNode head=null;

   //头插法
    public void headInsert(int data){
        ListNode listNode = new ListNode(data);
        if (head == null){
            head = listNode;
            return;
        }
        listNode.next = listNode;
        head = listNode;
    }

    //尾插法
    public void EndInsert(int data){
        ListNode listNode = new ListNode(data);
        if (head == null) {
            head = listNode;
            return;
        }
        ListNode indexNode = listNode;
        while (indexNode != null){
            indexNode=indexNode.next;
        }
        indexNode.next = listNode;
    }

    //链表输出
    public void printLink(){
        ListNode tempNode=head;
        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
        System.out.println();
    }
    
    //查找
    public boolean contains(int data){
        ListNode tempNode = head;
        int length = 0;
        while (tempNode != null) {
            if (tempNode.data == data) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }
}