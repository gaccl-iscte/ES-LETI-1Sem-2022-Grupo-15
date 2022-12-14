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
	 * Convert url to .txt file
	 *
	 * @param urlStr the url in string
	 * @param file the destination file
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
	 * Convert .ics file to .txt file
	 *
	 * @param file the file to convert
	 * @param result the destination file
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
