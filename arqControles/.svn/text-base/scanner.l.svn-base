package laxer;
import java_cup.runtime.*;


%%

%class Scanner
%unicode
%public
%cup
%line
%column

%{


  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

delim	=	[ \t\n]
ws		=	{delim}+
letter	=	[A-Za-z]
digit	=	[0-9]
id		=	({letter}|"_")({letter}|{digit}|"_")*

number	=	{digit}+
newline	=	\r|\n|\r\n

%%
{ws}			{ /* do nothing */ }
"//".*			{ /* do nothing */ }
{newline} 		{ /* do nothing */ }
{id}			{ 		if (yytext().toLowerCase().equals("if")) {
							//System.out.println("IF");
							return symbol(sym.IF);
						}else if (yytext().toLowerCase().equals("var")) {
							//System.out.println("VAR");
							return symbol(sym.VAR);
						}else if (yytext().toLowerCase().equals("procedure")) {
							//System.out.println("PROCEDURE");
							return symbol(sym.PROCEDURE);
						}else if (yytext().toLowerCase().equals("begin")) {
							//System.out.println("BEGIN");
							return symbol(sym.BEGIN);
						}else if (yytext().toLowerCase().equals("end")) {
							//System.out.println("END");
							return symbol(sym.END);
						}else if (yytext().toLowerCase().equals("module")) {
							//System.out.println("MODULE");
							return symbol(sym.MODULE);
						}else if (yytext().toLowerCase().equals("integer")) {
							//System.out.println("INTERGER");
							return symbol(sym.INTEGER);
						}else if (yytext().toLowerCase().equals("boolean")) {
							//System.out.println("BOLLEAN");
							return symbol(sym.BOOLEAN);
						}else if (yytext().toLowerCase().equals("while")) {
							//System.out.println("WHILE");
							return symbol(sym.WHILE);
						}else if (yytext().toLowerCase().equals("do")) {
							//System.out.println("DO");
							return symbol(sym.DO);
						}else if (yytext().toLowerCase().equals("read")) {
							//System.out.println("READ");
							return symbol(sym.READ);
						}else if (yytext().toLowerCase().equals("writeln")) {
							//System.out.println("WRITELN");
							return symbol(sym.WRITELN);
						}else if (yytext().toLowerCase().equals("repeat")) {
							//System.out.println("REPEAT");
							return symbol(sym.REPEAT);
						}else if (yytext().toLowerCase().equals("until")) {
							//System.out.println("UNTIL");
							return symbol(sym.UNTIL);
						}else if (yytext().toLowerCase().equals("then")) {
							//System.out.println("THEN");
							return symbol(sym.THEN);
						}else if (yytext().toLowerCase().equals("elsif")) {
							//System.out.println("ELSIF");
							return symbol(sym.ELSIF);
						}else if (yytext().toLowerCase().equals("else")) {
							//System.out.println("ELSE");
							return symbol(sym.ELSE);
						}else if (yytext().toLowerCase().equals("and")) {
							//System.out.println("AND");
							return symbol(sym.AND);
						}else if (yytext().toLowerCase().equals("or")) {
							//System.out.println("OR");
							return symbol(sym.OR);
						}else if (yytext().toLowerCase().equals("not")) {
							//System.out.println("NOT");
							return symbol(sym.NOT);
						}else if (yytext().toLowerCase().equals("real")) {
							//System.out.println("REAL");
							return symbol(sym.REAL);
						}else if (yytext().toLowerCase().equals("array")) {
							//System.out.println("ARRAY");
							return symbol(sym.ARRAY);
						}else if (yytext().toLowerCase().equals("of")) {
							//System.out.println("OF");
							return symbol(sym.OF);
						}else if (yytext().toLowerCase().equals("write")) {
							//System.out.println("WRITE");
							return symbol(sym.WRITE);
						}else if (yytext().toLowerCase().equals("size")) {
							//System.out.println("SIZE");
							return symbol(sym.SIZE);
						}else if (yytext().toLowerCase().equals("const")) {
							//System.out.println("CONST");
							return symbol(sym.CONST);
						}else if (yytext().toLowerCase().equals("true")) {
							//System.out.println("TRUE");
							return symbol(sym.TRUE, new String(yytext()));
						}else if (yytext().toLowerCase().equals("false")) {
							//System.out.println("FALSE");
							return symbol(sym.FALSE, new String(yytext()));
						}else if (yytext().toLowerCase().equals("mod")) {
							//System.out.println("MOD");
							return symbol(sym.MULTOP, new String(yytext()));
						}else {
						//System.out.println("ID: " + yytext());
							return symbol(sym.ID, new String(yytext()));
						}
				}
{number}		{ 
//System.out.println("NUMBER"); 
				return symbol(sym.NUMBER, new String(yytext())); }
"+"		        { 
//System.out.println("PLUS"); 
				return symbol(sym.ADDLOP, new String(yytext())); }
"-"		        { 
//System.out.println("MINUS"); 
				return symbol(sym.ADDLOP, new String(yytext())); }
"*"		        { 
//System.out.println("MULT"); 
				return symbol(sym.MULTOP, new String(yytext())); }
"/"		        { 
//System.out.println("DIV"); 
				return symbol(sym.MULTOP, new String(yytext())); }
"<"		        { return symbol(sym.RELOP, new String(yytext())); }
">"		        { return symbol(sym.RELOP, new String(yytext())); }
">="		    { 
//System.out.println("MAJOREQ"); 
				return symbol(sym.RELOP, new String(yytext())); }
"<="		    { 
//System.out.println("MINOREQ"); 
				return symbol(sym.RELOP, new String(yytext())); }
"#"		        { 
//System.out.println("DIF"); 
				return symbol(sym.RELOP, new String(yytext())); }
"("		        { 
//System.out.println("OPAR"); 
				return symbol(sym.OPAR); }
")"		        { 
//System.out.println("CPAR"); 
				return symbol(sym.CPAR); }
"]"		        { 
//System.out.println("OCPAR"); 
				return symbol(sym.OCPAR); }
"["		        { 
//System.out.println("OOPAR"); 
				return symbol(sym.OOPAR); }
";"		        { 
//System.out.println("PONTOVIRGULA"); 
				return symbol(sym.PONTOVIRGULA); }
","		        { 
//System.out.println("VIRGULA"); 
				return symbol(sym.VIRGULA); }
"."		        { 
//System.out.println("PONTO"); 
				return symbol(sym.PONTO); }
"="		        { 
//System.out.println("IGUAL"); 
				return symbol(sym.RELOP, new String(yytext())); }
":="		    { 
//System.out.println("ATRI"); 
				return symbol(sym.ATRI); }
":"		        { 
//System.out.println("PONTOPONTO"); 
				return symbol(sym.PONTOPONTO); }
.				{ System.out.println("Simbolo desconhecido: "+yytext()); }