public class DoubleLinkedList {

    //有头节点
    DoubleHeroNode head=new DoubleHeroNode(0,"","");

    //插入到链表尾部，不排序
    public void add(DoubleHeroNode node){
        DoubleHeroNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }

    //插入，排序
    //注意双向链表最后在链表中间添加，和在链表最后一个添加pre指针有差异，最后一个节点不存在node.next.pre否则出现空指针问题
    //如果没有头节点，双向链表排序插入在，第一个元素前，最后一个元素后，和中间插入是不一样的
    public void addByOrder(DoubleHeroNode node){

        DoubleHeroNode temp=head;
        boolean isMax=true;
        while(temp.next!=null){
            if(temp.next.no>=node.no){
                isMax=false;
                break;
            }else{
                temp=temp.next;
            }
        }
        //判断是否在最后一个节点插入
        if(isMax==false){
            node.next=temp.next;
            temp.next=node;
            node.pre=temp;
            node.next.pre=node;
        }else{
            temp.next=node;
            node.pre=temp;
        }

    }

    //更新节点
    public void update(DoubleHeroNode newNode){
        DoubleHeroNode temp=head.next;
        boolean isExisted=false;
        while(temp!=null){
            if(temp.no==newNode.no){
                isExisted=true;
                break;
            }else{
                temp=temp.next;
            }
        }
        if(isExisted==false){
            System.out.println("链表中没有该节点，无法更新节点信息～");
        }else{
            temp.name=newNode.name;
            temp.nickname=newNode.nickname;
        }
    }

    //删除节点
    //双向链表删除，在链表内删除和在链表结尾处删除，next的指向是不一样的.
    //如果是没有头节点的链表，第一个元素，最后一个元素，和中间元素的删除操作指针指向是不一样的，注意
    public void delete(DoubleHeroNode newNode){
        DoubleHeroNode temp=head.next;
        boolean isExisted=false;
        while(temp!=null){
            if(temp.no==newNode.no){
                isExisted=true;
                break;
            }else{
                temp=temp.next;
            }
        }
        if(isExisted=true){
            if(temp.next==null){
                temp.pre.next=null;
                temp.pre=null;
            }else{
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.println("链表中没有该节点，不能删除～");
        }
    }

    //遍历节点-正向
    public void show(DoubleHeroNode head){
        DoubleHeroNode temp=head.next;
        while (temp!=null){
            System.out.println(temp.toString());
            temp=temp.next;
        }
    }

    //遍历节点-反向
    public void show1(DoubleHeroNode head){
        DoubleHeroNode temp=head.next;
        while (temp.next!=null){
            temp=temp.next;
        }
        while(temp.pre!=null){
            System.out.println(temp.toString());
            temp=temp.pre;
        }
    }

}

class DoubleHeroNode{
    int no;
    String name;
    String nickname;
    DoubleHeroNode next=null;
    DoubleHeroNode pre=null;

    public DoubleHeroNode(int no, String name, String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
