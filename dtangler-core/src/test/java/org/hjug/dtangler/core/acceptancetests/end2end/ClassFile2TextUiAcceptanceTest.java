// This product is provided under the terms of EPL (Eclipse Public License) 
// version 2.0.
//
// The full license text can be read from: https://www.eclipse.org/legal/epl-2.0/

package org.hjug.dtangler.core.acceptancetests.end2end;

import static org.junit.Assert.assertEquals;

import org.hjug.dtangler.core.CommandLineApp;
import org.hjug.dtangler.core.configuration.ParserConstants;
import org.hjug.dtangler.core.input.CommandLineParser;
import org.hjug.dtangler.core.testutil.ClassPathEntryFinder;
import org.hjug.dtangler.core.testutil.output.FileUtil;
import org.hjug.dtangler.core.testutil.output.MockWriter;
import org.junit.Test;

/**
 * Example scenarios are in separate source folders (testdata-xxx). Each folder
 * has a file that describes the expected DSM output (expected.txt) The Eclipse
 * project has a separate output folder for each testdata source (for example
 * "testdata-minimal-classes")
 */
public class ClassFile2TextUiAcceptanceTest {

	private final String inputKey = CommandLineParser
			.getKeyString(ParserConstants.INPUT_KEY);

	@Test
	public void testGoodDependencies() {
		assertDsmResult(ClassPathEntryFinder
				.getPathContaining("testdata-good-deps"));
	}

	private void assertDsmResult(String path) {
		MockWriter writer = new MockWriter();
		new CommandLineApp(writer).run(new String[] { inputKey + path });
		String dsm = writer.getOutput();

        String expected;
		if(path.endsWith(".jar")) {
		    expected = FileUtil.readFileInJar(this.getClass().getResourceAsStream("/expected.txt"));
        } else {
            expected = FileUtil.readFile(path + "/expected.txt");
        }


		assertEquals(expected.replaceAll("\r", ""), dsm.replaceAll("\r", ""));
	}

}