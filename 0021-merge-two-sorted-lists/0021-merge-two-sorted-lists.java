/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer>list=new ArrayList<>();
        ListNode temp=list1;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
         temp=list2;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(list);
        ListNode d=new ListNode(-1);
        ListNode curr=d;
        for(int f:list){
            curr.next=new ListNode(f);
            curr=curr.next;
        }
        return d.next;
    }
}