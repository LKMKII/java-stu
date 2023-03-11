package NEW;

import javax.swing.JTextField;

public class ListNode {
	   int data;   //当前节点值
	   ListNode next;  //下一节点值
	   public ListNode(int data2){
	       this.data = data2;
	   }

	    @Override
	    public String toString() {
	        return "data=" + data + "next=" + next;
	    }
	}