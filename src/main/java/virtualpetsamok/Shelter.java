package virtualpetsamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Shelter {

	Map<String, VirtualPet> pets = new HashMap<>();
	
	LitterBox box = new LitterBox();
	
	public void addPet(VirtualPet pet) {
		pets.put(pet.getName(), pet);
	}

	public Collection<VirtualPet> getPets() {
		return pets.values();
	}

	public void walkAll() {
		for(VirtualPet pet: pets.values() ) {
			if(pet instanceof WalkablePet) {
				((WalkablePet) pet).walk();
			}
		}
	}

	public LitterBox getBox() {
		return box;
	}

	public void cleanBox() {
		box.cleanBox();
	}
	
	public void feedAll() {
		for(VirtualPet pet: pets.values() ) {
			if(pet instanceof OrganicPet) {
				((OrganicPet) pet).feed();
			}
		}
	}
	
	public void waterAll() {
		for(VirtualPet pet: pets.values() ) {
			if(pet instanceof OrganicPet) {
				((OrganicPet) pet).water();
			}
		}
	}
	
	public void cleanACage(String name) {
		if(pets.get(name) instanceof VirtualDog) {
			((VirtualDog) pets.get(name)).cleanCage();
		}
	}
	
	public void playWithPet(String name) {
		pets.get(name).play();
	}
	
	public void oilAll() {
		for(VirtualPet pet: pets.values() ) {
			if(pet instanceof RobotPet) {
				((RobotPet) pet).oil();
			}
		}
	}

}
