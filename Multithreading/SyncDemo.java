package JavaThreadsDemo;


class Table{
	synchronized void printTable(int num) {
			for(int i = 1; i<= 10; i++) {
				System.out.println(i+" x "+num+" = "+ i*num);
			}
		}
		
	}

class MyThread extends Thread{
	Table table;
	
	MyThread(Table table){
		this.table=table;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getPriority());
		table.printTable(5);
	}
	
}
class MyThreadTwo extends Thread{
	Table table;;
	
	MyThreadTwo(Table table){
		this.table=table;
	}
	
	public void run() {
		table.printTable(7);
	}
	
}





public class SyncDemo {

	public static void main(String[] args) {
		Table tableOne = new Table();
			
//		table.printTable(5);
		MyThread threadOne = new MyThread(tableOne);
		threadOne.setPriority(2);
		MyThreadTwo threadTwo = new MyThreadTwo(tableOne);
		threadTwo.setPriority(1);
		threadOne.start();
		threadTwo.start();

	}

}
