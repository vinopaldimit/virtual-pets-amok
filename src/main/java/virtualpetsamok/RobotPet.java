package virtualpetsamok;

public class RobotPet extends VirtualPet implements WalkablePet {

	private int rust;
	private String type;

	public RobotPet(String name, String desc, String type) {
		super(name, desc);
		rust = 0;
		this.type = type;
	}

	public void tick(int ticks) {
		for (int i = 0; i < ticks; i++) {
			incrementBoredom(1);
			rust+= 3;
			incrementHealth(2);

			if (rust >= 50) {
				decrementHealth(5);
			}

			//TODO help
			mood = "Happy";
			if (getHealth() < 20 || getBoredom() > 45) {
				mood = "Unhappy";
			}

			health = stayInLimits(health);
			boredom = stayInLimits(boredom);
			rust = stayInLimits(rust);
		}
	}

	public int getRust() {
		return rust;
	}

	public void oil() {
		rust -= 5;
		incrementHealth(15);
	}

	@Override
	public void walk() {
		decrementBoredom(5);
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "[Robot " + type + "] " + getName() + " Mood: " + getMood() + " \n\tBoredom: " + getBoredom() + " Rust: " + rust
				+ " Health: " + getHealth();
	}
}
