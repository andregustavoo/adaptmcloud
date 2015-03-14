package setup;

import modulo.blackboard.Blackboard;

public class StartLocal {
	public static void main(String[] args) {
		Blackboard b = Blackboard.getInstance(new Long(10000), new Long(10));
		Thread t = new Thread(b);
		t.start();
	}
}
