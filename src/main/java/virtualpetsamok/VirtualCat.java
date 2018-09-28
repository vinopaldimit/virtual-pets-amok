package virtualpetsamok;

public class VirtualCat extends OrganicPet {
	
	LitterBox box;
	
	public VirtualCat(String name, String desc, LitterBox box) {
		super(name, desc);
		this.box = box;
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
			if(health<20||hunger+thirst+boredom>120) {
				mood = "Unhappy";
			}
			
			hunger = stayInLimits(hunger);
			thirst = stayInLimits(thirst);
			boredom = stayInLimits(boredom);
			health = stayInLimits(health);

			box.updateFull();
			
			if(box.getFull()==true) {
				health -= 15;
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
