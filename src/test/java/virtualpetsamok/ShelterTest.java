package virtualpetsamok;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class ShelterTest {

	@Test
	public void shouldReturnPetCollection() {
		Shelter underTest = new Shelter();
		RobotPet test = new RobotPet(null, null, null);
		underTest.addPet(test);
		Collection <VirtualPet> result = underTest.getPets();
		assertThat(result, contains(test));
	}
	
	@Test
	public void shouldCleanBox() {
		Shelter underTest = new Shelter();
		LitterBox box = underTest.getBox();
		for(int i = 0; i < 50; i++) {
			box.increasePoop();
		}
		underTest.cleanBox();
		int result = box.getPoopQuantity();
		assertThat(result, is(0));
	}
	
	//tests copied from last project
	@Test
	public void shouldAdoptPet() {
		Shelter underTest = new Shelter();
		VirtualPet catOne = new VirtualCat("Kitty the Cat", "Calico kitten", null);
		VirtualPet catTwo = new VirtualCat("Marty", "Black kitten", null);
		underTest.addPet(catOne);
		underTest.addPet(catTwo);
		underTest.adopt("Marty");
		Assert.assertEquals(1, underTest.pets.size());
	}
}
