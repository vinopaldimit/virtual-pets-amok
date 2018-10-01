package virtualpetsamok;

public abstract class VirtualPet {
	private final int VALUE_MAX = 50;

	protected int boredom;
	protected int health;
	protected String desc;
	protected String name;
	protected String mood;

	public VirtualPet(String name, String desc) {
		this.name = name;
		this.desc = desc;
		health = 50;
		mood = "Happy";
		boredom = (int) (Math.random() * 20 + 1);
	}

	public void play() {
		boredom -= 15;
		health += 2;
	}

	public int getBoredom() {
		return boredom;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
	
	public String getMood() {
		return mood;
	}
	
	public int getHealth() {
		return health;
	}

	public int stayInLimits(int number) {
		if (number > VALUE_MAX) {
			return VALUE_MAX;
		}
		if (number < 0) {
			return 0;
		}
		return number;
	}

}