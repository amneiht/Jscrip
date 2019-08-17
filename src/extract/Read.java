
package extract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Read {
	static int[] op = { '[', '{', '(' };
	static int[] end = { ']', '}', ')' };
	static List<Integer>tth=new ArrayList<Integer>();// toan tu
	static List<Integer>dut=new ArrayList<Integer>();// do uu tien

	static void init() {
		String s = new File("").getAbsolutePath() + "/ope.txt";
		List<String> h = getText(s);
		for (String sd : h) {
			String[] d = sd.split(":");
			tth.add(Integer.parseInt(d[0]));
			tth.add(Integer.parseInt(d[1]));
		}
//		for (int f : end) {
//			System.out.println((char) f);
//		}
	}

	// private List<String> balantext(InputStream in)
	// {
	// char d=
	// }
	public static List<String> getText(String s) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
			List<String> ret = new LinkedList<String>();
			String rd = in.readLine();
			while (rd != null) {
				ret.add(rd);
				rd = in.readLine();
			}
			in.close();
			return ret;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		init();
	}
}
