package controle;

Module ::= "String":ID Declarations Statements "String":ID

Constdecl ::= "String":ID Exp |

Vardecl ::= IdList Vartype | 

IdList ::= "String":ID IdList

Vartype ::=  "String":type Arraytype

Arraytype ::= Exp Vartype

Procdecl ::= Procheader Procbody

Procheader ::= "String":ID Formalpars Vartype
	
Procbody ::= Declarations Statements "String":ID

Formalpars ::= Fpsection Formalpars

Fpsection ::= IdList Vartype

Statements ::= Statement Statements

Declarations ::= Constdecl Vardecl Procdecl

Actualpar ::= Exp Actualpar

Exp ::= {BinExpre} Exp "String":OP Exp
		| {IntExpre} "int":valor
		| {VarExpre} Variable
		
Variable ::= "String":ID

Assignment ::= Variable Exp

Statement ::= Assignment Conditional Repetion Exp Io

Conditional ::= "String":tipo Exp Statements 

Repetion ::= {WhileRepetion} Exp Statements | {RepetionRepetion} Statement Exp

Io ::= Exp

