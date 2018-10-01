package virtualpetsamok;

public class VirtualCat extends OrganicPet {

	LitterBox box;

	public VirtualCat(String name, String desc, LitterBox box) {
		super(name, desc);
		this.box = box;
	}

	//@Override
	public void tick(int ticks) {
		for (int i = 0; i < ticks; i++) {
			incrementHunger(1);
			incrementThirst(1);
			incrementBoredom(1);
			incrementHealth(2);
			incrementPoop((int) (Math.random() * 2 + 1));

			mood = "Happy";
			if (getHealth() < 20 || getHunger() + getThirst() + getBoredom() > 120) {
				mood = "Unhappy";
			}

			hunger = stayInLimits(hunger);
			thirst = stayInLimits(thirst);
			boredom = stayInLimits(boredom);
			health = stayInLimits(health);

			box.updateFull();

			if (box.getFull() == true) {
				decrementHealth(15);
			}

			if (isPoopAtMax()) {
				poopInBox();
			}

			refreshPoopCount();
		}
	}

	public void poopInBox() {
		box.increasePoop();
	}

	@Override
	public String toString() {
		return "[Cat] " + getName() + " Mood: " + getMood() + " \n\tHunger: " + getHunger() + " Thirst: " + getThirst()
				+ " Boredom: " + getBoredom() + " Health: " + getHealth();
	}

}
