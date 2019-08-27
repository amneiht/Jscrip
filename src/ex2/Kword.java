package ex2;

import java.util.ArrayList;
import java.util.List;

import extract.lib.Klist;

// co the tang toc voi hashmap
public class Kword {
	protected List<String> key = new ArrayList<String>(10);
	protected List<Integer> pri = new ArrayList<Integer>(10);
	protected String[]list;
	protected int[]plist;
	
	private boolean cv = true;
	public Kword() {
		pri.add(Integer.MIN_VALUE);
		pri.add(Integer.MAX_VALUE);
		key.add("    ");// chot dau
		key.add("~~~~");// chot cuoi
	}
	public void add(String a,int b)
	{
		int d=find(a);
		key.add(d+1,a);
		pri.add(d, b);
	}
	public void convert()
	{
		if(cv)
		{
		int d=key.size();
		list=key.toArray(new String[d]);
		plist=new int[d];
		for(int  i=0;i<d;i++)
		{
			plist[i]=pri.get(i);
		}
		cv=false;
		key.clear();
		pri.clear();
		}
		
	}
	private int find(String a)
	{
		int d = 0, cuoi = key.size() - 1;
		int mid, cmp;
		mid = 0;
		while (cuoi > d) {
			mid = (d + cuoi) / 2;
			cmp = key.get(mid).compareTo(a);
			if (cmp == 0) {
				return mid;
			}
			if (cmp >0) {
				d = mid;
			} else {
				cuoi = mid;
			}
		}
		return mid;
	}
	protected int findl(String a) // chuyen doi
	{ 
		int d = 0, cuoi = list.length - 1;
		int mid, cmp;
		mid = 0;
		while (cuoi > d) {
			mid = (d + cuoi) / 2;
			cmp = list[mid].compareTo(a);
			if (cmp == 0) {
				return mid;
			}
			if (cmp >0) {
				d = mid;
			} else {
				cuoi = mid;
			}
		}
		return Klist.J_text;
	}
}
