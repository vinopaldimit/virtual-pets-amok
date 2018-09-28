package virtualpetsamok;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RobotPetTest {
	@Test
	public void shouldRustWithTick() {
		RobotPet underTest = new RobotPet("", "", "");
		int expected = underTest.getRust() + 5;
		underTest.tick(5);
		int result = underTest.getRust();
		assertThat(result, is(expected));
	}
	
	@Test
	public void shouldDecreaseRust() {
		RobotPet underTest = new RobotPet("", "", "");
		underTest.tick(5);
		underTest.oil();
		int result = underTest.getRust();
		assertThat(result, is(0));
	}
	
	@Test
	public void shouldBeARobotCat() {
		RobotPet underTest = new RobotPet("", "", "Cat");
		String result = underTest.getType();
		assertThat(result, is(equalTo("Cat")));
	}
}
