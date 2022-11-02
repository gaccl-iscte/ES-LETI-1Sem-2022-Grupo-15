/**
 * 
 */
package ES_2022_LETI_Grupo_15.Projeto_ES;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.fortuna.ical4j.data.ParserException;

/**
 * @author Asus
 *
 */
class test {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException, ParseException, ParserException {
		//fail("Not yet implemented");
		UrlToTxt.main(null);
	}

}
