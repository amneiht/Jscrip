
package W_false;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Read {
	static int[] op = { '[', '{', '(' };
	static int[] end = { ']', '}', ')' };
	static Kword keyword = new Kword();
	static Kword ope = new Kword();
	static int ch = 0;// doc truoc 1 ky tu
	static int point = 0;
	static int[] key = new int[30];
	static Stack<String> sta = new Stack<String>();
	static Queue<String> que = new Queue<String>();
	static final int len=1000;
	static void init() {
		String s = new File("").getAbsolutePath() + "/ope.txt";
		List<String> h = getText(s);
		for (String sd : h) {
			String[] d = sd.split(":");
			ope.add(d[0], Integer.parseInt(d[1])+len);
		}
		s = new File("").getAbsolutePath() + "/code.txt";
		h = getText(s);
		int i = 0;
		for (String sd : h) {
			keyword.add(sd, i);
			i++;
		}
	}

	protected void balantext(InputStream in) {
		
	}

	static boolean bget;

	protected static String get(InputStream in) throws IOException {
		while (ch <= ' ') // loai cac ky tu thua
		{
			ch = in.read();
		}
		bget = ischar(ch);
		point = 0;
		key[0] = ch;
		ch = in.read();
		while (bget != ischar(ch)) {
			point++;
			key[point] = ch;
			ch = in.read();
		}
		if (key[point] == ';')
			point--;
		return new String(key, 0, point);
	}

	static protected String getString(DataInputStream in) throws IOException {
		StringBuilder st = new StringBuilder();
		ch = in.read();
		while (ch != '"') {
			st.append((char) ch);
			ch = in.read();
		}
		ch = in.read();
		return st.toString();
	}

	static boolean ischar(int a) {
		if (a >= '0' && a <= '9')
			return true;
		if (a == '_')
			return true;
		a = a | 0x60;
		return (a >= 'A' && a <= 'Z');
	}

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
