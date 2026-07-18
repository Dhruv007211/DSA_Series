/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode>set=new HashSet<>();
        ListNode t=head;
        while(t!=null){
            if(set.contains(t))return true;
            set.add(t);
            t=t.next;
        }
        return false;
    }
}