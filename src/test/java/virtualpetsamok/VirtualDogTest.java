package virtualpetsamok;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VirtualDogTest {
	@Test
	public void shouldDecreasePoop() {
		VirtualDog underTest = new VirtualDog("", "");
		int expected = underTest.getPoop() - 5; // if you change the amount walk decreases, change this
		underTest.walk();
		int result = underTest.getPoop();
		assertThat(result, is(expected));
	}

	@Test
	public void shouldDirtyCage() {
		VirtualDog underTest = new VirtualDog("", "");
		underTest.tick(20);
		boolean result = underTest.getCageClean();
		assertThat(result, is(false));
	}

	@Test
	public void shouldCleanCage() {
		VirtualDog underTest = new VirtualDog("", "");
		underTest.tick(20);
		underTest.cleanCage();
		boolean result = underTest.getCageClean();
		assertThat(result, is(true));
	}
	
	@Test
	public void shouldBeUnhappy() {
		VirtualDog underTest = new VirtualDog("","");
		underTest.tick(40);
		String result = underTest.getMood();
		assertThat(result, is(equalTo("Unhappy")));
	}
	
}
