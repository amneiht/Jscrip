package extract.lib;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;

import ex2.Read;

public class Creat {
	static String str; // "package extract.lib;\n";
	static int mod = 1000;
	static FileWriter fw;
	static boolean show = false;

	public static void main(String[] args) {
		String ds = new Creat().getClass().getPackage().getName();
		str = "package " + ds + ";";
		try {
			code();
//			get();
//			cmp();
			check();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void check() throws Exception
	{
		fw = new FileWriter("/home/amneiht/app/code/workspace/jslib/src/ex2/CheckL.java");// tao file so sanh
		println("package ex2; \n");
		println("import extract.lib.Klist;");
		println("class CheckL {");
		println("public static void cl(int p) {");
		println("if(p==Klist.J_v) {System.out.print(\"variable \"); \n return; }");
		println("if(p==Klist.J_text) {System.out.print(\"text \"); \n return; }");
		println("if(p==Klist.J_m) {System.out.print(\"math \"); \n return; }");
		println("if(p==Klist.J_false) {System.out.print(\"false \"); \n return; }");
		String s = new File("").getAbsolutePath() + "/code.txt";
		List<String> h = Read.getText(s);
		Collections.sort(h);
		for(String p:h)
		{
			println("if(p==Klist.J_"+p+" ) {System.out.print(\""+p+" \"); \n return; }");
		}
		s = new File("").getAbsolutePath() + "/ope.txt";
		h = Read.getText(s);
		for (String sd : h) {
			// keyword.add(sd, i);
			String[] ps = sd.split(":");
			println("if(p==Klist.O_"+ps[2]+" ) {System.out.print(\""+ps[0]+" \"); \n return; }");
		}
		println("}");
		println("}");
		fw.close();
	}
	public static void cmp() throws Exception {
		fw = new FileWriter("/home/amneiht/app/code/workspace/jslib/src/ex2/T_cmp.java");// tao file so sanh
		println("package ex2; \n");
		println("import extract.lib.* ;");
		println("class T_cmp {");
		println("\tprotected static void code(){");

		println("\tswitch(Read.token) {");
		for (String s : Klist.list) {
			println("\t\tcase Klist.J_" + s + " :");
			println("\t\t\t//Read.check_" + s + "() ;");
			println("\t\t\tbreak ;");
		}
		println("\t\tcase Klist.J_m :");
		println("\t\t\t//Read.check_m() ;");
		println("\t\t\tbreak ;");
		println("\t\t}");
		println("\t}");
		println("}");
		fw.close();
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
		print("\tpublic static final int J_m = -6 ;  // bien so \n");
		print("\tpublic static final int J_text = -5 ;\n");
		print("\tpublic static final int J_false = -4 ;\n");
		print("\tpublic static final int J_v = -3 ;  // toan hang\n");
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
			print("\tpublic static final int O_" + ps[2] + " = " + ((1 + Integer.parseInt(ps[1])) * 1000 + i) + " ;\n");
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
		println("package ex2; ");
		println("import extract.lib.*;");
		println("import java.io.IOException;");
		println("class Ope { ");
		println("public static int gettoken() throws IOException {");
		println("Read.next();");
		println("try {");
		Tree ps = new Tree();
		for (String p : h) {
			String[] sh = p.split(":");
			ps.add(sh[0], "O_" + sh[2], 0);
		}
		ps.write();
		println("else return Read.kget(); ");
		println("}catch(Exception e) \n { \n e.printStackTrace(); ");
		println("	return Klist.J_false; ");
		println("}");
		println("}");
		println("}");
		fw.close();
	}

	static void println(String s) throws Exception {
		if (!show)
			fw.write(s + "\n");
		else
			System.out.println(s);
	}

	static void println() throws Exception {
		if (!show)
			fw.write("\n");
		else
			System.out.println();
	}

	static void print(String s) throws Exception {
		if (!show)
			fw.write(s);
		else
			System.out.print(s);
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
