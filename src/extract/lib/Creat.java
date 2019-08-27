package extract.lib;

import java.io.File;
import java.util.List;

import ex2.Read;

public class Creat {
	public static void code() {
		String s = new File("").getAbsolutePath() + "/code.txt";
		List<String> h = Read.getText(s);
		int i = 0;
		System.out.println("package ex2;\n");
		System.out.println("public class Klist { ");
		StringBuilder st = new StringBuilder("protected static String[] list= {");
		System.out.println("\tpublic static final int J_text = -5 ;");
		for (String sd : h) {
			// keyword.add(sd, i);
			if (i != 0)
				st.append(" , ");
			System.out.println("\tpublic static final int J_" + sd + " = " + i + " ;");
			i++;
			st.append('"' + sd + '"');
		}
		st.append("} ;");
		// System.out.println("\t"+st.toString());
		System.out.println("} ");
	}

	public static void ope() {
		String s = new File("").getAbsolutePath() + "/ope.txt";
		List<String> h = Read.getText(s);
		System.out.println("package ex2;\n");
		System.out.println("public class Olist { ");
		for (String sd : h) {
			// keyword.add(sd, i);
			String[] ps = sd.split(":");
			System.out.println("\tpublic static final int O_" + ps[2] + " = " + ps[1] + " ;");
		}
		System.out.println("} ");
	}

	public static void main(String[] args) {
		ope();
	}
}
