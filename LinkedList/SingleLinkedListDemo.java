/**
 * 单链表节点增删改查测试
 * 单链表相关面试题
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


}




