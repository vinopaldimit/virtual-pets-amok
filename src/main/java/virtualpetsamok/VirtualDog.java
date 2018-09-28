package virtualpetsamok;

public class VirtualDog extends OrganicPet implements WalkablePet {

	private boolean cageClean;

	public VirtualDog(String name, String desc) {
		super(name, desc);
		cageClean = true;
	}

	@Override
	public void walk() {
		boredom -= 5;
		poop -= 5;
	}

	@Override
	public void tick(int ticks) {
		for (int i = 0; i < ticks; i++) {
			hunger++;
			thirst++;
			boredom++;
			health += 2;
			poop += (int) (Math.random() * 2 + 1);

			mood = "Happy";
			if (health < 20 || hunger + thirst + boredom > 120) {
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
			health -= 10;
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
