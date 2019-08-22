/**
 * tips:
 * 1. 增删改查操作中，增删找操作节点的前一个节点，改找当前操作节点
 * 2. 头节点不能动，需要使用辅助节点遍历
 * 3. 注意复制节点while循环的终止条件，和temp=head, temp=head.next有关，还和具体问题有关，可能会有while(temp.next!=null)或者while(temp!=null)
 * 4. 单链表=带头节点+无头节点  有无头节点会影响到temp辅助节点的赋值和while循环终止条件
 *
 * 5. 可以使用boolean isExisted 变量标注操作节点是否存在在链表中，while循环只用来找操作节点，while循环结束之后可以通过辅助变量的不同值进行不同操作，减少重复代码，while循环中可能存在
 *    不同的条件控制语句，有些可能有相同后续操作。
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
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);

        singleLinkedList.show(singleLinkedList.head);
    }

}

class SingleLinkedList{
    //有头节点的但链表，头节点不存放数据，只存放指针
    //也可以没有头节点，第一个节点即包括数据，也包括指针

    //有头节点
    HeroNode head=new HeroNode(0,"","");

    //插入节点，不排序，直接在链表末尾添加
    public void add(HeroNode heroNode){
        if(head.next==null){
            head.next=heroNode;
            return;
        }
        HeroNode temp=head.next;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    //插入节点，排序，按照HeroNode.no升序排列
    public void addByOrder(HeroNode heroNode){
        if(head.next==null){
            head.next=heroNode;
            return;
        }

        HeroNode temp=head;
        boolean isExisted=false;

        while(temp.next!=null){
            if(temp.next.no==heroNode.no){
                isExisted=true;
                break;
            }
            else if(temp.next.no>heroNode.no){
                break;
            }else{
                temp=temp.next;
            }
        }

        //isExisted==true表示编号已经存在，不能添加；否则在对应位置或者链表最后添加新的节点
        if(isExisted==true){
            System.out.println("不能添加，该英雄编号已经存在");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    //更新节点
    public void update(HeroNode newHeroNode){
        if(head.next==null){
            System.out.println("链表为空，不能更新节点");
            return;
        }
        HeroNode temp=head.next;
        boolean isExisted=false;
        while(temp!=null){
            if(temp.no==newHeroNode.no){
                isExisted=true;
                break;
            }else{
                temp=temp.next;
            }
        }
        //isExisted==true表示找到了编号为no的英雄，否则没有该英雄
        if(isExisted==true){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else{
            System.out.printf("不存在编号为%d的英雄", newHeroNode.no);
        }
    }

    //删除节点
    public void delete(int no){
        if(head.next==null){
            System.out.println("链表为空不能删除");
            return;
        }
        HeroNode temp=head;
        boolean isExisted=false;
        while(temp.next!=null){
            if(temp.next.no==no){
                isExisted=true;
                break;
            }else{
                temp=temp.next;
            }
        }
        if(isExisted==true){
            temp.next=temp.next.next;
        }else{
            System.out.println("链表中没有该节点，不能删除");
        }
    }

    //遍历节点
    public void show(HeroNode head){
        if(head.next==null){
            System.out.println("null");
            return;
        }
        HeroNode temp=head.next;
        while(temp!=null){
            System.out.println(temp.toString());
            temp=temp.next;
        }
    }

}


class HeroNode{
    int no;
    String name;
    String nickname;
    HeroNode next;

    public HeroNode(int no, String name, String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}