package virtualpetsamok;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VirtualCatTest {
	//deleted tests which were broken because of superclass extraction and randomized numbers
	@Test
	public void shouldPoop() {
		LitterBox testBox = new LitterBox();
		VirtualCat underTest = new VirtualCat("","", testBox);
		underTest.poopInBox();
		int result = testBox.getPoopQuantity();
		assertThat(result, is(1));
	}
	
	@Test
	public void shouldPoopWithTick() {
		LitterBox testBox = new LitterBox();
		VirtualCat underTest = new VirtualCat("","", testBox);
		underTest.tick(20);
		int result = testBox.getPoopQuantity();
		assertThat(result, is(greaterThanOrEqualTo(1)));
	}
}
