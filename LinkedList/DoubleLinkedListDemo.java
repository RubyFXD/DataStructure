public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();

        DoubleHeroNode hero1= new DoubleHeroNode(1,"宋江","及时雨");
        DoubleHeroNode hero2=new DoubleHeroNode(2,"卢俊义","玉麒麟");
        DoubleHeroNode hero3=new DoubleHeroNode(3,"吴用","智多星");
        DoubleHeroNode hero4=new DoubleHeroNode(4,"林冲","豹子头");

//        //测试-add不排序
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//        doubleLinkedList.add(hero2);
//
//        System.out.println("插入测试-正向遍历～～");
//        doubleLinkedList.show(doubleLinkedList.head);
//
//        System.out.println("插入测试-反向遍历～～");
//        doubleLinkedList.show1(doubleLinkedList.head);

        //测试-add排序
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);

        System.out.println("插入测试-正向遍历～～");
        doubleLinkedList.show(doubleLinkedList.head);

        System.out.println("插入测试-反向遍历～～");
        doubleLinkedList.show1(doubleLinkedList.head);

        //测试-update

        DoubleHeroNode newHero1=new DoubleHeroNode(1,"小宋","及时雨～～");
        doubleLinkedList.update(newHero1);

        System.out.println("更新测试-正向遍历～～");
        doubleLinkedList.show(doubleLinkedList.head);

        //测试-delete

        DoubleHeroNode deleteHero4= new DoubleHeroNode(4,"林冲","豹子头");
        DoubleHeroNode deleteHero2= new DoubleHeroNode(2,"卢俊义","玉麒麟");
        doubleLinkedList.delete(deleteHero4);
        doubleLinkedList.delete(deleteHero2);

        System.out.println("删除测试-正向遍历～～");
        doubleLinkedList.show(doubleLinkedList.head);
    }
}
