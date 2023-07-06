package de.uni_freiburg.informatik.ultimate.witnessparser.yaml;

import org.junit.Before;
import org.junit.Test;

import de.uni_freiburg.informatik.ultimate.witnessparser.YAMLWitnessParser;

public class YamlWitnessParserTest {

	@Before
	public void setUp() {
	}

	public void testname() throws Exception {
		new YAMLWitnessParser();
	}
	
	@Test
	public void test1() {
		final String hash = "511f45a8d763ef520f6d92e4135c8572805994a66531c6216b17157d0dde2f9c";
		var loc = new Location ("CPAchecker", 22, 0, "multivar_1-1.c", "");
		final String invariant = "(x >= 1024U) && (x <= 4294967295U) && (y == x)";
		var loopInv = new LoopInvariant("", "C", "assertion", loc);
		//var loopInv = new LocationInvariant("x <= 0", "C", "assertion", loc);
		System.out.println(loopInv.getFormat());

		throw new AssertionError();
	}
}
