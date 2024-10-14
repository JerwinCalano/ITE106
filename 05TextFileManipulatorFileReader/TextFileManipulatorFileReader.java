import java.io.*;

public class TextFileManipulationFileReader
{
	public static void main(String [] args) throws Exception{
		
		File file = new File("jerwin.txt");
		
		int i;
		while((i = fr.read()) != -1)
			System.out.print((char) i);
	}
}
