import java.util.Scanner;

public class ArrayCircleQueueDemo {
    public static void main(String[] args) {
        ArrayCircleQueue queue=new ArrayCircleQueue(3);
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        String instruction="";

        while(loop){
            System.out.println("add: 入队");
            System.out.println("poll: 出队");
            System.out.println("peak: 访问队首元素");
            System.out.println("show: 当前有效元素");
            System.out.println("exit: 退出");
            System.out.println("请输入指令");
            instruction=scanner.next();

            switch (instruction){
                case "add":
                    try{
                        System.out.println("请输入一个数字");
                        int value=scanner.nextInt();
                        queue.add(value);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
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
                    }catch (Exception e){
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

class ArrayCircleQueue{
    int front=0;
    int rear=0;
    int maxSize=0;
    int[] arr;

    ArrayCircleQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public void add(int value){
        if(isFull()){
            throw new RuntimeException("队列已满，不能添加");
        }
        arr[rear]=value;
        rear=(rear+1)%maxSize;
    }

    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能出队");
        }
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    public int peak(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能访问");
        }
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能访问");
        }
        for(int i=0;i<(rear+maxSize-front)%maxSize;i++){
            System.out.printf("arr[%d]=%d\n",(front+i)%maxSize,arr[(front+i)%maxSize]);
        }

    }
}
