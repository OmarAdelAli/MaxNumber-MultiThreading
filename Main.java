class Th1 extends Thread {
	int a[];
	public int maxVal;
	public Th1(int arr[]) {
		super();
		a = new int [arr.length /4];
		int lo = (0 * arr.length) /4;
		for (int i = lo, j = 0; j < a.length ; i++, j++) {
			a[j] = arr[i];
		}
	}
	public void run() {
		int max1 = a[0];
		for (int i = 0; i < a.length; i++)
		{
			if (max1 < a[i])
				max1 = a[i];
		}
		
		System.out.println("The max value of part 1 : "+ max1);
		maxVal = max1;
	}
}
class Th2 extends Thread {
	int a[];
	public int maxVal;

	public Th2(int arr[]) {
		super();
		a = new int [arr.length /4];
		int lo = (1 * arr.length) /4;
		for (int i = lo, j = 0; j < a.length ; i++, j++) {
			a[j] = arr[i];
		}
	}

	public void run() {
		int max2 = a[0];
		for (int i = 0; i < a.length; i++)
		{
			if (max2 < a[i])
				max2 = a[i];
		}
		System.out.println("The max value of part 2 : "+ max2);
		maxVal = max2;
	}
}

class Th3 extends Thread {
	int a[];
	public int maxVal;

	public Th3(int arr[]) {
		super();
		a = new int [arr.length /4];
		int lo = (2 * arr.length) /4;
		for (int i = lo, j = 0; j < a.length ; i++, j++) {
			a[j] = arr[i];
		}
	}
	public void run() {
		int max3 = a[0];
		for (int i = 0; i < a.length; i++)
		{
			if (max3 < a[i])
				max3 = a[i];
		}
		System.out.println("The max value of part 3 : "+ max3);
		maxVal = max3;
	}
}

class Th4 extends Thread {
	int a[];
	public int maxVal;

	public Th4(int arr[]) {
		super();
		a = new int [arr.length /4];
		int lo = ( 3 * arr.length) /4;
		for (int i = lo, j = 0; j < a.length ; i++, j++) {
			a[j] = arr[i];
		}
	}
	public void run() {
		int max4 = a[0];
		for (int i = 0; i < a.length; i++)
		{
			if (max4 < a[i])
				max4 = a[i];
		}
		System.out.println("The max value of part 4 : "+ max4);
		maxVal = max4;
	}
}


class Th5 extends Thread {
	int a[];
	public int maxVal;
	public Th5(int arr[]) {
		super();
		a = arr;
	
	}
	public void run() {
		

		Th1 th1 = new Th1(a);
		Th2 th2 = new Th2(a);
		Th3 th3 = new Th3(a);
		Th4 th4 = new Th4(a);

		
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();

		try {
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			int maxVal = th1.maxVal;
			maxVal = Math.max(maxVal, th2.maxVal);
			maxVal = Math.max(maxVal, th3.maxVal);
			maxVal = Math.max(maxVal, th4.maxVal);
			System.out.println("The max value of all parts : " + maxVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
}
public class ArrayMaxOfAll {
	public static void main(String[] args) {
		int arr[] = new int [20];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();

		Th5 th5 = new Th5(arr);
		th5.start();


	}
}
