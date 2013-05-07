package controle;

Module ::= "int":id1 Decla Decla "int":id2

Decla ::= {DeclaDeclaDecla} Decla:left Decla:right
		| {DeclaConst} "int":id Exp
		| {DeclaIdList} "int":tipo Decla
		| {DeclaProcHeader} "int":id Decla Decla
		| {DeclaProcBody} Decla Decla "int":id
		| {DeclaArrayType} Exp Decla
		| {DeclaStatements} Decla Com
		| {DeclaId} "int":id
		| {DeclaVartype}"String":vartype
		| {DeclaCom} Com

Exp ::= {ExpBinary} Exp "String":tipo Exp
		| {ExpAtrib} "int":id Exp
		| {ExpProcCall}  "int":id Exp
		| {ExpFactor} "String":prec Exp
		| {ExpVartypeExp} Decla Exp
		| {ExpList} Exp Exp
		| {ExpValor} "int":valor
		| {ExpId} "int":id
		| {ExpIdSize} "int":id "String":size
		| {ExpBoolean} "boolean":booo

Com ::= {ComAssignment} Exp Exp
		| {ComExpDecla} Exp Decla "int":control //0-elseif 1-if 2-while
		| {ComElse} Decla
		| {ComRepeat} Com Exp
		| {ComExp} Exp
		| {ComConditional} Com Com