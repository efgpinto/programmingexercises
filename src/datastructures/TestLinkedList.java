package datastructures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(3, list.size());
		
		list.add(2);
		list.add(5);
		assertEquals(5, list.size());
		
		list.remove(2);
		assertEquals(4, list.size());
		
		list.remove(5);
		assertEquals(3, list.size());
		
		/*for (Integer i : list) {
			System.out.println(i + ",");
		}*/
		
		System.out.println(list);
	}

}
