package W_false;

import java.io.File;
import java.util.List;

public class Creat {
public static void main(String[] args) {
	String s = new File("").getAbsolutePath() + "/code.txt";
	List<String> h = Read.getText(s);
	int i = 1;
	System.out.println("package extract;\n");
	System.out.println("public class Klist { ");
	StringBuilder st=new StringBuilder("protected static String[] list= {");
	System.out.println("\tpublic static final int J_text = -1");
	for (String sd : h) {
		//keyword.add(sd, i);
		if(i!=0) st.append(" , ");
		System.out.println("\tpublic static final int J_"+sd+" = "+i+" ;");
		i++;
		st.append('"'+sd+'"');
	}
	st.append("} ;");
//	System.out.println("\t"+st.toString());
	System.out.println("} ");
}
}
