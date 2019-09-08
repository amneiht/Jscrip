package ex2; 

import extract.lib.* ;
class T_cmp {
	protected static void code(){
	switch(Read.token) {
		case Klist.J_String :
			//Read.check_String() ;
			break ;
		case Klist.J_boolean :
			//Read.check_boolean() ;
			break ;
		case Klist.J_break :
			//Read.check_break() ;
			break ;
		case Klist.J_else :
			//Read.check_else() ;
			break ;
		case Klist.J_for :
			//Read.check_for() ;
			break ;
		case Klist.J_if :
			//Read.check_if() ;
			break ;
		case Klist.J_then :
			//Read.check_then() ;
			break ;
		case Klist.J_var :
			//Read.check_var() ;
			break ;
		case Klist.J_m :
			//Read.check_m() ;
			break ;
		}
	}
}
