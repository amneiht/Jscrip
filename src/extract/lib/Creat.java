package extract.lib;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;

import ex2.Read;

public class Creat {
	static String str; // "package extract.lib;\n";
	static int mod = 1000;
	static String ss = "/home/amneiht/app/code/workspace/jslib/src/";
	static FileWriter fw;

	public static void main(String[] args) {
		String ds = new Creat().getClass().getPackage().getName();
		str = "package " + ds + ";";
		try {
			code();
			//get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void code() throws Exception {

		fw = new FileWriter("/home/amneiht/app/code/workspace/jslib/src/extract/lib/Klist.java");
		String s = new File("").getAbsolutePath() + "/code.txt";
		List<String> h = Read.getText(s);
		Collections.sort(h);
		int i = 0;
		print(str + "\n");
		print("public class Klist { \n");
		StringBuilder st = new StringBuilder("public static String[] list= {");
		print("\tpublic static final int J_text = -5 ;\n");
		print("\tpublic static final int J_false = -4 ;\n");
		print("\tpublic static final int J_m = -3 ;  // toan tu\n");
		println();
		for (String sd : h) {
			// keyword.add(sd, i);
			if (i != 0)
				st.append(" , ");
			print("\tpublic static final int J_" + sd + " = " + i + " ;\n");
			i++;
			st.append('"' + sd + '"');
		}
		print("\n");
		s = new File("").getAbsolutePath() + "/ope.txt";
		h = Read.getText(s);

		i = 0;
		for (String sd : h) {
			// keyword.add(sd, i);
			String[] ps = sd.split(":");
			print("\tpublic static final int O_" + ps[2] + " = " + (Integer.parseInt(ps[1]) * 1000 + i) + " ;\n");
			i++;
		}
		st.append("} ;");
		print("\n");
		print("\tpublic static final int mod=" + mod + ";\n");
		print("\t// do uu tien = gia tri / mod \n ");
		print("\t" + st.toString() + "\n");
		print("} \n");
		fw.close();
	}

	public static void get() throws Exception {
		fw = new FileWriter("/home/amneiht/app/code/workspace/jslib/src/ex2/Ope.java");
		String s = new File("").getAbsolutePath() + "/ope.txt";
		List<String> h = Read.getText(s);
		// System.out.println("switch (ch) \n {");
		println("package ex2; ");
		println("import java.io.* ;");
		println("import extract.lib.*;");
		println("class Ope { ");
		println("public static int gettoken() throws IOException {");
		Tree ps = new Tree();
		for (String p : h) {
			String[] sh = p.split(":");
			ps.add(sh[0], "O_" + sh[2], 0);
		}
		ps.write();
		println("else return Read.kget(); ");
//		Tree pk = new Tree();
//		s = new File("").getAbsolutePath() + "/code.txt";
//		h = Read.getText(s);
//		for (String p : h) {
//			pk.add(p, "J_" + p, 0);
//		}
//		pk.write();
		
	//	println("return Klist.J_text ;");
		println("}");
		println("}");
		fw.close();
	}

	static void println(String s) throws Exception {
		fw.write(s + "\n");
	}

	static void println() throws Exception {
		fw.write("\n");
	}

	static void print(String s) throws Exception {
		fw.write(s);
	}
}
//
// public static void ope() {
// String s = new File("").getAbsolutePath() + "/ope.txt";
// List<String> h = Read.getText(s);
// System.out.println(str);
// System.out.println("public class Olist { ");
// for (String sd : h) {
// // keyword.add(sd, i);
// String[] ps = sd.split(":");
// System.out.println("\tpublic static final int O_" + ps[2] + " = " + ps[1] + "
// ;");
// }
// System.out.println("} ");
// }
