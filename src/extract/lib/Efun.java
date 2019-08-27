package extract.lib;

import java.util.LinkedList;
import java.util.List;

public class Efun {
	LinkedList<LinkedList<Integer>> cmn = new LinkedList<LinkedList<Integer>>();
	int dem=-1;
	int r=0;
	public void makecode()
	{
		cmn.add(new LinkedList<Integer>());
		dem++;
	}
	public void add(int i)
	{
		cmn.get(dem).add(i);
	}
	public List<Integer> get()
	{
		return cmn.removeFirst();
	}
	
}
