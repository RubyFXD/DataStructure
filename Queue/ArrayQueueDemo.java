import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {

        ArrayQueue queue=new ArrayQueue(3);
        boolean loop=true;
        String instruction="";
        Scanner scanner=new Scanner(System.in);

        //控制小程序
        while(loop){
            System.out.println("add：入队");
            System.out.println("poll: 出队");
            System.out.println("peak: 返回当前队列第一个元素");
            System.out.println("show: 输出当前当前队列有效元素");
            System.out.println("exit: 退出测试");
            System.out.println("请输入你要进行的操作:");
            instruction=scanner.next();
            switch (instruction){
                case "add":
                    try{
                        System.out.println("输入需要添加的数字");
                        int value=scanner.nextInt();
                        queue.add(value);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case "poll":
                    try{
                        System.out.println(queue.poll());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "peak":
                    try{
                        System.out.println(queue.peak());
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "show":
                    try{
                        queue.show();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop=false;
                    break;
                default:
                    break;
            }
        }
    }
}

//用数组模拟非环形队列，当front&rear=-1初始值，add、peak、poll、show中关于front、end的操作将会不一样
class ArrayQueue {
    //首指针、尾指针
    int front=0;
    int rear=0;
    int[] arr;
    int maxSize=0;

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return rear==maxSize;
    }

    //判断队列是否为空
    public boolean isEmpty(){
       return rear==front;
    }

    //入队
    public void add(int value){
        if(isFull()){
            throw new RuntimeException("队列已满，不能添加");
        }
        arr[rear]=value;
        rear++;
    }

    //出队
    public int poll(){
        if(isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        int value=arr[front];
        front++;
        return value;
    }

    //显示队列当前有效元素
    public void show(){
        if(isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        for(int i=0;i<rear-front;i++){
            //System.out.printf("arr[%d]=%d\n",front+i,arr[front+i]);
            System.out.println("arr[] "+arr[front+i]);
        }
    }

    //访问当前首位元素
    public int peak(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能访问数组");
        }
        return arr[front];
    }
}
