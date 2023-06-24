package de.uni_freiburg.informatik.ultimate.ultimatetest.suites.witnesses;

import org.junit.Before;
import org.junit.Test;

public class YamlWitnessParserTest {

	@Before
	public void setUp() {
	}

	@Test
	public void test1() {
		final String hash = "511f45a8d763ef520f6d92e4135c8572805994a66531c6216b17157d0dde2f9c";
		// var loc = new Location("multivar_1-1.c", hash, 22, 0, "main");
		// var metadata = null; // TODO?
		final String invariant = "(x >= 1024U) && (x <= 4294967295U) && (y == x)";
		// var loopInv = new LoopInvariant(metadata, loc, invariant, WitnessExpressionFormat.C);
		//
		// System.out.println(loopInv.toString());

		throw new AssertionError();
	}
}
