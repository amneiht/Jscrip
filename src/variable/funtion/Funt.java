package variable.funtion;

import java.util.LinkedList;
import java.util.List;

import variable.funtion.exec.Exe;

public class Funt extends Method {

	List<Exe> md = new LinkedList<Exe>();

	public void run() {
		// Exe cmn=new Funt();
		int l = md.size();
		while (point < l) {
			md.get(point).run();
			point++;
		}
	}

	public void setpoint(int a) {
		point = a;
	}

	public int getpoint() {
		return point;
	}
	

}
