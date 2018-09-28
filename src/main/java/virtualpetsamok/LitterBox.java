package virtualpetsamok;

public class LitterBox {

	private final int FULL_BOX = 20;
	private int poopQuantity;
	private boolean full;

	public LitterBox() {
		poopQuantity = 0;
		full = false;
	}

	public void increasePoop() {
		poopQuantity++;
	}

	public int getPoopQuantity() {
		return poopQuantity;
	}

	public boolean getFull() {
		return full;
	}

	public void updateFull() {
		if (poopQuantity >= FULL_BOX) {
			full = true;
		} else {
			full = false;
		}
	}

	public void cleanBox() {
		full = false;
		poopQuantity = 0;
	}

}
