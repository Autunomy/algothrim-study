//23.合并 K 个升序链表
/*
思路就是首先将给定的集合中为空的链表删除，然后遍历所有链表的头结点，找出最小的链表的头结点，并记录其下标，加这个链表的头结点
加入到答案中，使用尾插法，然后将原链表的首节点删除，如果此时原链表为空，就从集合中删除
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] list) {
        //转为集合方便操作
        List<ListNode> lists = Arrays.stream(list).collect(Collectors.toList());

        ListNode head = null,p = null;
        lists.removeIf(Objects::isNull);

        while (lists.size() != 0) {
            ListNode temp = null;
            int idx = 0;
            for (int i = 0; i < lists.size(); ++i) {
                if (temp == null) {
                    idx = i;
                    temp = lists.get(i);
                } else {
                    if (temp.val > lists.get(i).val) {
                        idx = i;
                        temp = lists.get(i);
                    }
                }
            }

            if (head == null) {
                head = temp;
                p = head;
            } else {
                p.next = temp;
                p = p.next;
            }

            lists.remove(idx);
            if (temp.next != null) {
                lists.add(temp.next);
                temp.next = null;
            }
        }
        return head;
    }
}