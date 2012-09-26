grammar Ipa;

// *********** Header Declarations ***********
@header {
  package com.kevinchard.ipa.lang;
}

@lexer::header { package com.kevinchard.ipa.lang; }

@members {
private Interpreter interp;
public IpaParser(TokenStream input, Interpreter interp) {
    this(input);
    this.interp = interp;
}
}

// *********** Grammar Rules ***********
program returns [Object value]
@init { Object lastStatement = null; }
	: ( s=statement[false] { lastStatement = $s.value; } )+ EOF { if(lastStatement != null) $value = interp.lookup((String)lastStatement); }
	;

statement[boolean defer] returns [Object value]
	: ID ':=' a=expr[defer] { if(!defer) { interp.store($ID.text, $a.value); $value = $ID.text; } }
	| funccall[defer]
	;
	
	
expr[boolean defer]  returns [Object value]
	: a=literal[defer] { if(!defer) $value = $a.value; } 
	| ID { if(!defer) $value = interp.lookup($ID.text); }
	| a=funccall[defer] { if(!defer) $value = $a.value; }
	;
	
funccall[boolean defer]  returns [Object value]
@init { List<Object> args = new ArrayList<Object>(); }
	: ID '(' ( a=expr[defer] {args.add($a.value);} ( ',' a=expr[defer] {args.add($a.value);} )* )? ')'  { if(!defer) $value = interp.doFuncCall($ID.text, args); }
	;
	
literal[boolean defer]  returns [Object value]
	: STRING { if(!defer) $value = interp.string($STRING.text); }
	| NUMBER { if(!defer) $value = interp.number($NUMBER.int); }
	| ':' ID { if(!defer) $value = interp.symbol(":" + $ID.text); }
	| a=list[defer] { if(!defer) $value = $a.value; }
	| a=set[defer] { if(!defer) $value = $a.value; }
	| a=map[defer] { if(!defer) $value = $a.value; }
	| a=funcdef { $value = $a.value; }
	;

list[boolean defer]  returns [Object value]
@init { List<Object> values = new ArrayList<Object>(); }
	: 'L' '[' ( a=expr[defer] {values.add($a.value);} ( ',' a=expr[defer] {values.add($a.value);} )* )? ']' { $value = interp.list(values); }
	;
	
set[boolean defer]  returns [Object value]
@init { List<Object> values = new ArrayList<Object>(); }
	: 'S' '[' ( a=expr[defer] {values.add($a.value);} ( ',' a=expr[defer] {values.add($a.value);} )* )? ']' { $value = interp.set(values); }
	;
	
map[boolean defer]  returns [Object value]
@init { List<Object> keys = new ArrayList<Object>(); List<Object> values = new ArrayList<Object>(); }
	: 'M' '[' ( k=expr[defer] {keys.add($k.value);} ':' v=expr[defer] {values.add($v.value);} ( ',' k=expr[defer] {keys.add($k.value);} ':' v=expr[defer] {values.add($v.value);} )* )? ']' { $value = interp.map(keys, values); }
	;
	
funcdef  returns [Object value]
@init { List<String> types = new ArrayList<String>(); List<String> parameters = new ArrayList<String>(); List<String> statements = new ArrayList<String>(); String returnType = null; String returnExpr = null; }
	: '|' ( t=TYPE {types.add($t.text);} p=ID {parameters.add($p.text);} (',' t=TYPE {types.add($t.text);} p=ID {parameters.add($p.text);} )* )? '->' rt=TYPE { returnType = $rt.text;} '|' '{' ( s=statement[true] { statements.add($s.text); } )* 'return' r=expr[true] {returnExpr = $r.text;} '}' { $value = interp.funcDef(types, parameters, statements, returnType, returnExpr); }
	;

// *********** Lexical Rules ***********
TYPE : 'Num' | 'Str' | 'List' | 'Set' | 'Map' | 'Sym' | 'Func' | 'Any' ; 

ID :   (LETTER (LETTER | DIGIT)* '.' )? LETTER (LETTER | DIGIT)*  ;

STRING : '\"' .* '\"' ;

NUMBER : DIGIT+ ; 

fragment LETTER :   ('a'..'z' | 'A'..'Z') ;

fragment DIGIT : ('0'..'9') ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' | ';' )+ { $channel = HIDDEN; };
