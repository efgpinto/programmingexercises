import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindFirstSingleTest {

	@Test
	public void testSamples() {
        assertEquals(Character.valueOf('s'), FindFirstSingle.findFirstSingle("teste"));
        assertEquals(Character.valueOf('o'), FindFirstSingle.findFirstSingle("testesiio"));
        assertEquals(Character.valueOf('a'), FindFirstSingle.findFirstSingle("hhassddr"));
        assertEquals(Character.valueOf('r'), FindFirstSingle.findFirstSingle("hhassddraaj"));
	}

}
