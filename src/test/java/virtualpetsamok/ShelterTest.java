package virtualpetsamok;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

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
}
