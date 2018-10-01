package virtualpetsamok;

public abstract class OrganicPet extends VirtualPet {

	private final int POOP_TOTAL = 20;

	private int hunger;
	private int thirst;
	private int poop;

	public OrganicPet(String name, String desc) {
		super(name, desc);
		hunger = (int) (Math.random() * 20 + 1);
		thirst = (int) (Math.random() * 20 + 1);
		poop = (int) (Math.random() * 5 + 1);
	}

	// NOT CURRENTLY USED
	/*public void tick(int ticks) {
		for (int i = 0; i < ticks; i++) {
			hunger++;
			thirst++;
			incrementBoredom(1);
			poop += (int) (Math.random() * 2 + 1);

			hunger = stayInLimits(hunger);
			thirst = stayInLimits(thirst);
			boredom = stayInLimits(boredom);

			refreshPoopCount();
		}
	}*/

	// INTERACTIONS

	@Override
	public void play() {
		decrementBoredom(15);
		hunger += 5;
		thirst += 5;
		incrementHealth(2);
	}

	public void feed() {
		hunger -= 15;
		thirst += 5;
		poop += 3;
		incrementHealth(2);
	}

	public void water() {
		thirst -= 15;
		incrementHealth(2);
	}

	// METHODS FOR TICK

	public void refreshPoopCount() {
		if (poop > POOP_TOTAL) {
			poop = 0;
		}
	}

	public boolean isPoopAtMax() {
		if (poop >= POOP_TOTAL) {
			return true;
		}
		return false;
	}

	// ACCESSORS

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getPoop() {
		return poop;
	}
	
	//MUTATORS
	public void incrementHunger(int num) {
		hunger += num;
	}
	public void incrementThirst(int num) {
		thirst += num;
	}
	public void incrementPoop(int num) {
		poop += num;
	}
	public void decrementPoop(int num) {
		poop -= num;
	}

}