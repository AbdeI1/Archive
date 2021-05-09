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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        int[] listArray = new int[size];
        cur = head;
        for(int i = 0; i < size; i++){
            listArray[i] = cur.val;
            cur = cur.next;
        }
        for(int i = 0; i <= size - k; i+=k){
            reverse(listArray, i, i + k - 1);
        }
        ListNode newHead = new ListNode(listArray[0]);
        cur = newHead;
        for(int i = 1; i < size; i++){
            cur.next = new ListNode(listArray[i]);
            cur = cur.next;
        }
        return newHead;
    }
    public static void reverse(int[] l, int start, int end){
        int[] r = new int[end - start + 1];
        int index = 0;
        for(int i = end; i > start - 1; i--){
            r[index] = l[i];
            index++;
        }
        index = 0;
        for(int s = start; s < end + 1; s++){
            l[s] = r[index];
            index++;
        }
    }
}
