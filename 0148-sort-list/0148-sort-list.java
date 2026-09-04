class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int[] arr = new int[count];
        temp = head; 
        for(int i = 0; i < count; i++){
            arr[i] = temp.val;
            temp = temp.next;
        }
        Arrays.sort(arr);
        temp = head;
        for(int i = 0; i < count; i++){
            temp.val = arr[i];
            temp = temp.next;
        }
        
        return head;
    }
}