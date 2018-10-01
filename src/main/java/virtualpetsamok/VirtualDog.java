package virtualpetsamok;

public class VirtualDog extends OrganicPet implements WalkablePet {

	private boolean cageClean;

	public VirtualDog(String name, String desc) {
		super(name, desc);
		cageClean = true;
	}

	@Override
	public void walk() {
		decrementBoredom(5);
		decrementPoop(5);
	}

	//@Override
	public void tick(int ticks) {
		for (int i = 0; i < ticks; i++) {
			incrementHunger(1);
			incrementThirst(1);
			incrementBoredom(1);
			incrementHealth(2);
			incrementPoop((int) (Math.random() * 2 + 1));

			//TODO
			mood = "Happy";
			if (getHealth() < 20 || getHunger() + getThirst() + getBoredom() > 120) {
				mood = "Unhappy";
			}

			hunger = stayInLimits(hunger);
			thirst = stayInLimits(thirst);
			boredom = stayInLimits(boredom);
			health = stayInLimits(health);

			refreshCageClean();
			refreshPoopCount();
		}
	}

	private void refreshCageClean() {
		if (isPoopAtMax()) {
			cageClean = false;
			decrementHealth(10);
		}
	}

	public boolean getCageClean() {
		return cageClean;
	}

	public void cleanCage() {
		cageClean = true;
	}

	@Override
	public String toString() {
		return "[Dog] " + getName() + " Mood: " + getMood() + " \n\tHunger: " + getHunger() + " Thirst: " + getThirst()
				+ " Boredom: " + getBoredom() + " Health: " + getHealth() + "\n\tCage clean:" + cageClean + "";
	}

}
