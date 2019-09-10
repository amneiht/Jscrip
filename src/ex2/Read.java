
package ex2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import extract.lib.Klist;

public class Read {
	protected static int ch = 0;// doc truoc 1 ky tu
	private static int point = 0;
	private static int[] key = new int[30];
	static final int len = 1000;
	static InputStream in;
	protected static Stack<String> text = new Stack<String>();
	static Queue<String> que = new Queue<String>();
	static int line = 0;
	static int token = 0;

	static void init(InputStream tin) {
		in = tin;
		try {
			ch = in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * kiem tra cu phap cua bieu thuc
	 */
	protected static void check_m() {
		try {
			token = Ope.gettoken();
			if (token != Klist.O_1bang) {
				System.out.println("loi thieu dau = o dong thu " + line);
				endcode();
				return;

			}
			int d; // luu vet
			Queue<Integer> q = new Queue<Integer>();
			Stack<Integer> st = new Stack<Integer>();
			token = Ope.gettoken();
			if (ismath(token))
				q.push(token);
			else
				st.push(token);
			while (true) {
				d = token;
				token = Ope.gettoken();
				CheckL.cl(token);
				if (token == Klist.O_het)
					break;
				if (isope(d) && ismath(token)) {// dat toan hang vao stack
					q.push(token);
				} else if (token == Klist.O_mtron) {
					if (isope(d)) {
						st.push(token);
					} else {
						// loai th a(sO
						System.out.println("loi cu phap o dong thu " + line);
						endcode();
						return;
					}
				} else if (token == Klist.O_dtron) {
					int x;
					int f = 1;
					// System.out.println();
					while (!st.isempty()) {

						x = st.pop();
						if (x != Klist.O_mtron) {
							q.push(x);
						} else {
							f = 0;
							break;
						}
					}
					if (f == 1) {
						System.out.println("loi thieu ngoac o dong thu " + line);
						endcode();// ket thuc cau lenh
						return;
					}
				} else if (isope(token)) {
					if (d == Klist.O_dtron || ismath(d)) {
						if (st.isempty()) {
							st.push(token);
						} else {
							int z = st.show();

							if ((z != Klist.O_mtron) && (getmod(z) <= getmod(token))) {
								st.pop();// lay z
								st.push(token);
								q.push(z);

							} else {

								st.push(token);
							}
						}
					} else {
						System.out.println("loi cu phap o dong thu " + line);
						endcode();// ket thuc cau lenh
						return;
					}
				} else {
					System.out.println("loi cu phap o dong thu " + line);
					endcode();// ket thuc cau lenh
					return;
				}
				// if(ismath)
			}
			while (!st.isempty())
				q.push(st.pop());
			System.out.println();
			while (!q.isempty())

			{
				CheckL.cl(q.pop());
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * lay do uu tien
	 * 
	 * @param a
	 * @return
	 */
	static int getmod(int a) {
		return (a / Klist.mod - 1);
	}

	/**
	 * end of code
	 * 
	 * @throws IOException
	 */
	private static void endcode() throws IOException {
		while (ch != '\n' && ch != ';' && ch != -1) // doc het dong lenh
		{
			ch = get();

		}
	}

	/**
	 * kiem tra a co phai la toan tu hay khong
	 * 
	 * @param a
	 * @return
	 */
	private static boolean isope(int a) {
		return a >= Klist.mod;
	}

	/**
	 * kiem tra a co la toan hang hay khong
	 * 
	 * @param a
	 * @return
	 */
	private static boolean ismath(int a) {
		// se con cap nhat

//		if (a == Klist.J_text)
//			return true;
//		if (a == Klist.J_v)
//			return true;
//		if (a == Klist.J_m)
//			return true;
		if(a<0) return true;
		return false;
	}

	/**
	 * lay ki tu trong ham da test
	 * 
	 * @return
	 * @throws IOException
	 */
	protected static String getword() throws IOException {
		point = 0;
		key[0] = ch;
		point++;
		ch = get();
		while (ischar(ch) || ch == '_') {
			key[point] = ch;
			ch = get();
			point++;
		}
		return new String(key, 0, point);
	}

	protected static int kget() // lay bien in tu
	{
		try {
			if (ch == -1)
				return Klist.O_het;
			if (ch == '"') {
				String t;
				t = getString();
				que.push(t);
				return Klist.J_text;
			} else {

				if (isnumber(ch)) {
					String t = getNumber(in);
					que.push(t);
					return Klist.J_m;
				} else if (ischar(ch)) {

					String t = getword();
					int a = binarySearch(t);
					if (a > -1)
						return a;
					else {
						que.push(t);
						return Klist.J_v; // variable tra ve gia tri bien
					}
				} else
					return Klist.J_false; // bao loi
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Klist.J_false;
		}
	}

	static void next() throws IOException {
		while (ch <= ' ') // loai cac ky tu thua
		{
			ch = get();
		}
	}

	static int binarySearch(String x) {// copy tren mang
		int l = 0, r = Klist.list.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;

			int res = x.compareTo(Klist.list[m]);

			// Check if x is present at mid
			if (res == 0)
				return m;

			// If x greater, ignore left half
			if (res > 0)
				l = m + 1;

			// If x is smaller, ignore right half
			else
				r = m - 1;
		}

		return -1;
	}

	static protected String getString() throws IOException {
		StringBuilder st = new StringBuilder();
		int d = ch;
		st.append((char) ch);
		ch = get();
		while (ch != '"' && d != '/') {
			d = ch;
			st.append((char) ch);
			ch = get();
		}
		ch = get();
		String ld = st.toString();
		que.push(ld);// ?
		return ld;
	}

	static protected String getNumber(InputStream in) throws IOException // use when ch is number
	{
		point = 0;
		key[0] = ch;
		point++;
		ch = get();
		while (ischar(ch) || ch == '+' || ch == '-') {
			key[point] = ch;
			ch = get();
			point++;
		}
		return new String(key, 0, point);
	}

	public static int get() throws IOException {
		int p = in.read();
		if (p == '\n')
			line++;
		return p;
	}

	public static boolean isnumber(int a) {
		return a >= '0' && a <= '9';
	}

	public static boolean ischar(int a) {
		if (a >= '0' && a <= '9')
			return true;
		a = a | 0x20;
		return (a >= 'a' && a <= 'z');
	}

	protected int find(String a) {
		return 0;
		// for(int )
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
		FileInputStream fin;
		try {
			fin = new FileInputStream("/home/amneiht/Desktop/test.js");
			init(fin);
			Ope.gettoken();
			check_m();
			fin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
