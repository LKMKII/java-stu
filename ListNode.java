package NEW;

import javax.swing.JTextField;

public class ListNode {
	   int data;   //��ǰ�ڵ�ֵ
	   ListNode next;  //��һ�ڵ�ֵ
	   public ListNode(int data2){
	       this.data = data2;
	   }

	    @Override
	    public String toString() {
	        return "data=" + data + "next=" + next;
	    }
	}