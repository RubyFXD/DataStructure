import java.util.Stack;

/**
 * 单链表节点增删改查测试
 * 单链表相关面试题
 * 实现过程都考虑有头节点
 *
 * 链表操作过程中注意使用辅助变量(e.g. 链表反转current, next)，还有辅助变量next之间的指向关系，但链表马虎很容易断掉链接
 * newNode=oldNode 因为newNode和oldNode指向相同的内存空间，所以改变newNode的属性e.g. newNode.next, oldNode.next也会跟着变，所以注意别断链
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList=new SingleLinkedList();

        HeroNode hero1= new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");

        // 插入，不排序
//        System.out.println("插入不排序测试");
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //插入，排序
        System.out.println("插入排序测试");
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.show(singleLinkedList.head);

        //更新测试
        System.out.println("单链表更新测试");
        HeroNode newHeroNode=new HeroNode(2,"小卢","玉麒麟～～");
        singleLinkedList.update(newHeroNode);

        singleLinkedList.show(singleLinkedList.head);

        //删除测试
        System.out.println("单链表删除测试");
        singleLinkedList.delete(4);


        singleLinkedList.show(singleLinkedList.head);

        //测试-面试题1：求单链表中节点的个数，即单链表的长度
        System.out.println("测试-面试题1：求单链表中节点的个数，即单链表的长度");
        System.out.println("单链表的长度为："+getSingleLinkedListLength(singleLinkedList.head));

        //测试-面试题2：求单链表倒数第k个节点，有返回该节点，无返回null
        System.out.println("测试-面试题2：求单链表倒数第k个节点，有返回该节点，无返回null");
        System.out.println("resultNode1= "+getLastKNode1(1,singleLinkedList));
        System.out.println("resultNode2= "+getLastKNode2(1,singleLinkedList));

        //测试-面试题3：单链表的反转
        System.out.println("测试-面试题3：单链表的反转");
        reverse(singleLinkedList);
        singleLinkedList.show(singleLinkedList.head);

        //测试-面试题4：单链表的逆序输出（栈实现）
        System.out.println("测试-面试题4：单链表的逆序输出（栈实现）");
        reversePrint(singleLinkedList);

    }

    //面试题1：求单链表中节点的个数，即单链表的长度
    public static int getSingleLinkedListLength(HeroNode head){
        if(head.next==null){
            return 0;
        }
        HeroNode temp=head.next;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    //面试题2：查找单链表中的倒数第K个节点，找到返回该节点，没找到返回null
    //第一种方法，先统计singleLinkedList的长度，然后从头节点开始遍历，移动length-K次，就是第倒数第K个节点
    public static HeroNode getLastKNode1(int k, SingleLinkedList singleLinkedList){
        if(singleLinkedList.head.next==null){
            return null;
        }
        int length=getSingleLinkedListLength(singleLinkedList.head);
        if(k<=0 || k>length){
            return null;
        }
        HeroNode temp=singleLinkedList.head.next;
        for(int i=0;i<length-k;i++){
            temp=temp.next;
        }
        return temp;
    }
    //第二种方法，用两个指针，第一个指针先移动k次，然后两个指针一起移动，当第一个指针到null的时候，return第二个指针指的node
    public static HeroNode getLastKNode2(int k, SingleLinkedList singleLinkedList){
        if(singleLinkedList.head.next==null || k<=0){
            return null;
        }
        HeroNode firstNode=singleLinkedList.head.next;
        HeroNode secondNode=singleLinkedList.head.next;
        for(int i=0;i<k;i++){
            if(firstNode!=null){
                firstNode=firstNode.next;
            }else{
                return null;
            }
        }
        while(firstNode!=null){
            firstNode=firstNode.next;
            secondNode=secondNode.next;
        }
        return secondNode;
    }

    //面试题3：单链表的反转
    public static void reverse(SingleLinkedList singleLinkedList){
        if(singleLinkedList.head.next==null || singleLinkedList.head.next.next==null){
            return;
        }
        HeroNode reverseHead=new HeroNode(0,"","");
        HeroNode current=singleLinkedList.head.next;
        while(current!=null){
            HeroNode next=current.next;
            current.next=reverseHead.next;
            reverseHead.next=current;
            current=next;
        }
        singleLinkedList.head.next=reverseHead.next;

    }

    //面试题4：从尾到头打印单链表节点
    //可以使用 单链表反转的方法，但是会破坏原始链表的结构
    //可以使用 栈数据结构，后进先出的特点，逆序打印链表节点
    public static void reversePrint(SingleLinkedList singleLinkedList){
        if(singleLinkedList.head.next==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<>();
        HeroNode current=singleLinkedList.head.next;
        while(current!=null){
            stack.add(current);
            current=current.next;
        }

        while (stack.size()>0){
            System.out.println(stack.pop().toString());
        }
    }

}




