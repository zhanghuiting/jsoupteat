package a;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //add()��remove()������ʧ�ܵ�ʱ����׳��쳣(���Ƽ�)
        Queue<String> queue = new LinkedList<String>();
        //���Ԫ��
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //���ص�һ��Ԫ�أ����ڶ�����ɾ��
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //���ص�һ��Ԫ�� 
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //���ص�һ��Ԫ�� 
        for(String q : queue){
            System.out.println(q);
        }
    }
}
