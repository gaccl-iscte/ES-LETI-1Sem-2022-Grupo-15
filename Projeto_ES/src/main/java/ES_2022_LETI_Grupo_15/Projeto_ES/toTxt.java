package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * The Class toTxt.
 */
public class toTxt {

	/**
	 * Convert.
	 *
	 * @param urlStr the url str
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void convert(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}

	/**
	 * Convert.
	 *
	 * @param file the file
	 * @param result the result
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void convert(File file, String result) throws IOException {  
		FileInputStream fin = new FileInputStream(file);
		ReadableByteChannel rbc = Channels.newChannel(fin);
		FileOutputStream fos = new FileOutputStream(result);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}
}
