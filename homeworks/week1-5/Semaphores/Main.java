import java.util.concurrent.*;

class Main {

	private static int NO_OF_THREADS;
	private static int met = 0;

	public static Semaphore mutex = new Semaphore(0, true);

	public static void rendezVous(int id) {

		System.out.println("\nrendezVous thread: "+id);
		
		try {
			if(++met >= NO_OF_THREADS) {
				System.out.println("\nEveryone is in the room - let someone speak!");
				mutex.release();
			}
			//Thread must wait in line..
			mutex.acquire();

		} catch(InterruptedException e) {}
		
	}

	public static void postProtocol(int id) {
		--met;
		System.out.println("Thrd "+id +" executing post-protocol");
	}

	public static void main(String[] args) {

		if(args.length == 0)
	    {
	        System.out.println("Missing argument: java Main <number of threads>");
	        System.exit(0);
	    }

		NO_OF_THREADS = Integer.parseInt(args[0]);

		for(int i = 0; i < NO_OF_THREADS; i++) {
			Thrd t = new Thrd(i); t.start();
		}

	}
}