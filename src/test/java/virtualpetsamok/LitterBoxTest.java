package virtualpetsamok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LitterBoxTest {
	@Test
	public void shouldBeFull() {
		LitterBox underTest = new LitterBox();
		for (int i = 0; i < 50; i++) {
			underTest.increasePoop();
		}
		underTest.updateFull();
		boolean result = underTest.getFull();
		assertThat(result, is(true));
	}
	
	@Test
	public void shouldCleanBox() {
		LitterBox underTest = new LitterBox();
		for (int i = 0; i < 50; i++) {
			underTest.increasePoop();
		}
		underTest.updateFull();
		underTest.cleanBox();
		boolean result = underTest.getFull();
		assertThat(result, is(false));
	}
	
	@Test
	public void shouldHaveZeroPoop() {
		LitterBox underTest = new LitterBox();
		for (int i = 0; i < 50; i++) {
			underTest.increasePoop();
		}
		underTest.updateFull();
		underTest.cleanBox();
		int result = underTest.getPoopQuantity();
		assertThat(result, is(0));
	}
}
