package ex2;

import java.io.*;
import extract.lib.*;

class Ope {
	public static int gettoken() throws IOException {
		if (Read.ch == ']') {
			Read.ch = Read.get();
			return Klist.O_dvuong;
		} else if (Read.ch == '[') {
			Read.ch = Read.get();
			return Klist.O_mvuong;
		} else if (Read.ch == ')') {
			Read.ch = Read.get();
			return Klist.O_dtron;
		} else if (Read.ch == '(') {
			Read.ch = Read.get();
			return Klist.O_mtron;
		} else if (Read.ch == '=') {
			Read.ch = Read.get();
			if (Read.ch == '=') {
				Read.ch = Read.get();
				if (Read.ch == '=') {
					Read.ch = Read.get();
					return Klist.O_3bang;
				} else
					return Klist.O_2bang;
			} else
				return Klist.O_1bang;
		} else if (Read.ch == '<') {
			Read.ch = Read.get();
			if (Read.ch == '<') {
				Read.ch = Read.get();
				return Klist.O_dtrai;
			}
			return Klist.J_false;
		} else if (Read.ch == '>') {
			Read.ch = Read.get();
			if (Read.ch == '>') {
				Read.ch = Read.get();
				return Klist.O_dphai;
			}
			return Klist.J_false;
		} else if (Read.ch == '/') {
			Read.ch = Read.get();
			return Klist.O_chia;
		} else if (Read.ch == '*') {
			Read.ch = Read.get();
			return Klist.O_nhan;
		} else if (Read.ch == '-') {
			Read.ch = Read.get();
			return Klist.O_tru;
		} else if (Read.ch == '+') {
			Read.ch = Read.get();
			if (Read.ch == '=') {
				Read.ch = Read.get();
				return Klist.O_cmot;
			} else
				return Klist.O_cong;
		} else if (Read.ch == ';') {
			Read.ch = Read.get();
			return Klist.O_het;
		} else
			return Read.kget();
		
	}
}
