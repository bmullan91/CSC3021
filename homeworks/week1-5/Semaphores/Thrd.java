class Thrd extends Thread {
	
	private int id;

	public Thrd(int id) {
		this.id = id;
	}

	public void run() {

		while(true) {
			Main.rendezVous(this.id);
			criticalSection();
			Main.postProtocol(this.id);

			//leave the room, go for a nap.
			try {
				this.sleep(3000);
			} catch (InterruptedException e) {}
		}

	}

	private void criticalSection() {
		System.out.println("Thrd "+this.id +" executing it's critical section");
	}

}