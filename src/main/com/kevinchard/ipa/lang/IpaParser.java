// $ANTLR 3.4 C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g 2012-09-25 16:56:53

  package com.kevinchard.ipa.lang;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class IpaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "ID", "LETTER", "NUMBER", "STRING", "TYPE", "WHITESPACE", "'('", "')'", "','", "'->'", "':'", "':='", "'L'", "'M'", "'S'", "'['", "']'", "'return'", "'{'", "'|'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int DIGIT=4;
    public static final int ID=5;
    public static final int LETTER=6;
    public static final int NUMBER=7;
    public static final int STRING=8;
    public static final int TYPE=9;
    public static final int WHITESPACE=10;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public IpaParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public IpaParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return IpaParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g"; }


    private Interpreter interp;
    public IpaParser(TokenStream input, Interpreter interp) {
        this(input);
        this.interp = interp;
    }



    // $ANTLR start "program"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:19:1: program returns [Object value] : (s= statement[false] )+ EOF ;
    public final Object program() throws RecognitionException {
        Object value = null;


        IpaParser.statement_return s =null;


         Object lastStatement = null; 
        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:21:2: ( (s= statement[false] )+ EOF )
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:21:4: (s= statement[false] )+ EOF
            {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:21:4: (s= statement[false] )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:21:6: s= statement[false]
            	    {
            	    pushFollow(FOLLOW_statement_in_program47);
            	    s=statement(false);

            	    state._fsp--;


            	     lastStatement = (s!=null?s.value:null); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input,EOF,FOLLOW_EOF_in_program55); 

             if(lastStatement != null) value = interp.lookup((String)lastStatement); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "program"


    public static class statement_return extends ParserRuleReturnScope {
        public Object value;
    };


    // $ANTLR start "statement"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:24:1: statement[boolean defer] returns [Object value] : ( ID ':=' a= expr[defer] | funccall[defer] );
    public final IpaParser.statement_return statement(boolean defer) throws RecognitionException {
        IpaParser.statement_return retval = new IpaParser.statement_return();
        retval.start = input.LT(1);


        Token ID1=null;
        IpaParser.expr_return a =null;


        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:25:2: ( ID ':=' a= expr[defer] | funccall[defer] )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==16) ) {
                    alt2=1;
                }
                else if ( (LA2_1==11) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:25:4: ID ':=' a= expr[defer]
                    {
                    ID1=(Token)match(input,ID,FOLLOW_ID_in_statement73); 

                    match(input,16,FOLLOW_16_in_statement75); 

                    pushFollow(FOLLOW_expr_in_statement79);
                    a=expr(defer);

                    state._fsp--;


                     if(!defer) { interp.store((ID1!=null?ID1.getText():null), (a!=null?a.value:null)); retval.value = (ID1!=null?ID1.getText():null); } 

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:26:4: funccall[defer]
                    {
                    pushFollow(FOLLOW_funccall_in_statement87);
                    funccall(defer);

                    state._fsp--;


                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class expr_return extends ParserRuleReturnScope {
        public Object value;
    };


    // $ANTLR start "expr"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:30:1: expr[boolean defer] returns [Object value] : (a= literal[defer] | ID |a= funccall[defer] );
    public final IpaParser.expr_return expr(boolean defer) throws RecognitionException {
        IpaParser.expr_return retval = new IpaParser.expr_return();
        retval.start = input.LT(1);


        Token ID2=null;
        Object a =null;


        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:31:2: (a= literal[defer] | ID |a= funccall[defer] )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= NUMBER && LA3_0 <= STRING)||LA3_0==15||(LA3_0 >= 17 && LA3_0 <= 19)||LA3_0==24) ) {
                alt3=1;
            }
            else if ( (LA3_0==ID) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==11) ) {
                    alt3=3;
                }
                else if ( (LA3_2==EOF||LA3_2==ID||(LA3_2 >= 12 && LA3_2 <= 13)||LA3_2==15||(LA3_2 >= 21 && LA3_2 <= 22)||LA3_2==25) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:31:4: a= literal[defer]
                    {
                    pushFollow(FOLLOW_literal_in_expr110);
                    a=literal(defer);

                    state._fsp--;


                     if(!defer) retval.value = a; 

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:32:4: ID
                    {
                    ID2=(Token)match(input,ID,FOLLOW_ID_in_expr119); 

                     if(!defer) retval.value = interp.lookup((ID2!=null?ID2.getText():null)); 

                    }
                    break;
                case 3 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:33:4: a= funccall[defer]
                    {
                    pushFollow(FOLLOW_funccall_in_expr128);
                    a=funccall(defer);

                    state._fsp--;


                     if(!defer) retval.value = a; 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"



    // $ANTLR start "funccall"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:36:1: funccall[boolean defer] returns [Object value] : ID '(' (a= expr[defer] ( ',' a= expr[defer] )* )? ')' ;
    public final Object funccall(boolean defer) throws RecognitionException {
        Object value = null;


        Token ID3=null;
        IpaParser.expr_return a =null;


         List<Object> args = new ArrayList<Object>(); 
        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:38:2: ( ID '(' (a= expr[defer] ( ',' a= expr[defer] )* )? ')' )
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:38:4: ID '(' (a= expr[defer] ( ',' a= expr[defer] )* )? ')'
            {
            ID3=(Token)match(input,ID,FOLLOW_ID_in_funccall154); 

            match(input,11,FOLLOW_11_in_funccall156); 

            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:38:11: (a= expr[defer] ( ',' a= expr[defer] )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ID||(LA5_0 >= NUMBER && LA5_0 <= STRING)||LA5_0==15||(LA5_0 >= 17 && LA5_0 <= 19)||LA5_0==24) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:38:13: a= expr[defer] ( ',' a= expr[defer] )*
                    {
                    pushFollow(FOLLOW_expr_in_funccall162);
                    a=expr(defer);

                    state._fsp--;


                    args.add((a!=null?a.value:null));

                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:38:49: ( ',' a= expr[defer] )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==13) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:38:51: ',' a= expr[defer]
                    	    {
                    	    match(input,13,FOLLOW_13_in_funccall169); 

                    	    pushFollow(FOLLOW_expr_in_funccall173);
                    	    a=expr(defer);

                    	    state._fsp--;


                    	    args.add((a!=null?a.value:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,12,FOLLOW_12_in_funccall184); 

             if(!defer) value = interp.doFuncCall((ID3!=null?ID3.getText():null), args); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "funccall"



    // $ANTLR start "literal"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:41:1: literal[boolean defer] returns [Object value] : ( STRING | NUMBER | ':' ID |a= list[defer] |a= set[defer] |a= map[defer] |a= funcdef );
    public final Object literal(boolean defer) throws RecognitionException {
        Object value = null;


        Token STRING4=null;
        Token NUMBER5=null;
        Token ID6=null;
        Object a =null;


        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:42:2: ( STRING | NUMBER | ':' ID |a= list[defer] |a= set[defer] |a= map[defer] |a= funcdef )
            int alt6=7;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt6=1;
                }
                break;
            case NUMBER:
                {
                alt6=2;
                }
                break;
            case 15:
                {
                alt6=3;
                }
                break;
            case 17:
                {
                alt6=4;
                }
                break;
            case 19:
                {
                alt6=5;
                }
                break;
            case 18:
                {
                alt6=6;
                }
                break;
            case 24:
                {
                alt6=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:42:4: STRING
                    {
                    STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_literal205); 

                     if(!defer) value = interp.string((STRING4!=null?STRING4.getText():null)); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:43:4: NUMBER
                    {
                    NUMBER5=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_literal212); 

                     if(!defer) value = interp.number((NUMBER5!=null?Integer.valueOf(NUMBER5.getText()):0)); 

                    }
                    break;
                case 3 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:44:4: ':' ID
                    {
                    match(input,15,FOLLOW_15_in_literal219); 

                    ID6=(Token)match(input,ID,FOLLOW_ID_in_literal221); 

                     if(!defer) value = interp.symbol(":" + (ID6!=null?ID6.getText():null)); 

                    }
                    break;
                case 4 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:45:4: a= list[defer]
                    {
                    pushFollow(FOLLOW_list_in_literal230);
                    a=list(defer);

                    state._fsp--;


                     if(!defer) value = a; 

                    }
                    break;
                case 5 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:46:4: a= set[defer]
                    {
                    pushFollow(FOLLOW_set_in_literal240);
                    a=set(defer);

                    state._fsp--;


                     if(!defer) value = a; 

                    }
                    break;
                case 6 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:47:4: a= map[defer]
                    {
                    pushFollow(FOLLOW_map_in_literal250);
                    a=map(defer);

                    state._fsp--;


                     if(!defer) value = a; 

                    }
                    break;
                case 7 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:48:4: a= funcdef
                    {
                    pushFollow(FOLLOW_funcdef_in_literal260);
                    a=funcdef();

                    state._fsp--;


                     value = a; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "literal"



    // $ANTLR start "list"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:51:1: list[boolean defer] returns [Object value] : 'L' '[' (a= expr[defer] ( ',' a= expr[defer] )* )? ']' ;
    public final Object list(boolean defer) throws RecognitionException {
        Object value = null;


        IpaParser.expr_return a =null;


         List<Object> values = new ArrayList<Object>(); 
        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:53:2: ( 'L' '[' (a= expr[defer] ( ',' a= expr[defer] )* )? ']' )
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:53:4: 'L' '[' (a= expr[defer] ( ',' a= expr[defer] )* )? ']'
            {
            match(input,17,FOLLOW_17_in_list284); 

            match(input,20,FOLLOW_20_in_list286); 

            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:53:12: (a= expr[defer] ( ',' a= expr[defer] )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID||(LA8_0 >= NUMBER && LA8_0 <= STRING)||LA8_0==15||(LA8_0 >= 17 && LA8_0 <= 19)||LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:53:14: a= expr[defer] ( ',' a= expr[defer] )*
                    {
                    pushFollow(FOLLOW_expr_in_list292);
                    a=expr(defer);

                    state._fsp--;


                    values.add((a!=null?a.value:null));

                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:53:52: ( ',' a= expr[defer] )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==13) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:53:54: ',' a= expr[defer]
                    	    {
                    	    match(input,13,FOLLOW_13_in_list299); 

                    	    pushFollow(FOLLOW_expr_in_list303);
                    	    a=expr(defer);

                    	    state._fsp--;


                    	    values.add((a!=null?a.value:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,21,FOLLOW_21_in_list314); 

             value = interp.list(values); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "list"



    // $ANTLR start "set"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:56:1: set[boolean defer] returns [Object value] : 'S' '[' (a= expr[defer] ( ',' a= expr[defer] )* )? ']' ;
    public final Object set(boolean defer) throws RecognitionException {
        Object value = null;


        IpaParser.expr_return a =null;


         List<Object> values = new ArrayList<Object>(); 
        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:58:2: ( 'S' '[' (a= expr[defer] ( ',' a= expr[defer] )* )? ']' )
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:58:4: 'S' '[' (a= expr[defer] ( ',' a= expr[defer] )* )? ']'
            {
            match(input,19,FOLLOW_19_in_set339); 

            match(input,20,FOLLOW_20_in_set341); 

            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:58:12: (a= expr[defer] ( ',' a= expr[defer] )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID||(LA10_0 >= NUMBER && LA10_0 <= STRING)||LA10_0==15||(LA10_0 >= 17 && LA10_0 <= 19)||LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:58:14: a= expr[defer] ( ',' a= expr[defer] )*
                    {
                    pushFollow(FOLLOW_expr_in_set347);
                    a=expr(defer);

                    state._fsp--;


                    values.add((a!=null?a.value:null));

                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:58:52: ( ',' a= expr[defer] )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==13) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:58:54: ',' a= expr[defer]
                    	    {
                    	    match(input,13,FOLLOW_13_in_set354); 

                    	    pushFollow(FOLLOW_expr_in_set358);
                    	    a=expr(defer);

                    	    state._fsp--;


                    	    values.add((a!=null?a.value:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,21,FOLLOW_21_in_set369); 

             value = interp.set(values); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "set"



    // $ANTLR start "map"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:61:1: map[boolean defer] returns [Object value] : 'M' '[' (k= expr[defer] ':' v= expr[defer] ( ',' k= expr[defer] ':' v= expr[defer] )* )? ']' ;
    public final Object map(boolean defer) throws RecognitionException {
        Object value = null;


        IpaParser.expr_return k =null;

        IpaParser.expr_return v =null;


         List<Object> keys = new ArrayList<Object>(); List<Object> values = new ArrayList<Object>(); 
        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:63:2: ( 'M' '[' (k= expr[defer] ':' v= expr[defer] ( ',' k= expr[defer] ':' v= expr[defer] )* )? ']' )
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:63:4: 'M' '[' (k= expr[defer] ':' v= expr[defer] ( ',' k= expr[defer] ':' v= expr[defer] )* )? ']'
            {
            match(input,18,FOLLOW_18_in_map394); 

            match(input,20,FOLLOW_20_in_map396); 

            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:63:12: (k= expr[defer] ':' v= expr[defer] ( ',' k= expr[defer] ':' v= expr[defer] )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID||(LA12_0 >= NUMBER && LA12_0 <= STRING)||LA12_0==15||(LA12_0 >= 17 && LA12_0 <= 19)||LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:63:14: k= expr[defer] ':' v= expr[defer] ( ',' k= expr[defer] ':' v= expr[defer] )*
                    {
                    pushFollow(FOLLOW_expr_in_map402);
                    k=expr(defer);

                    state._fsp--;


                    keys.add((k!=null?k.value:null));

                    match(input,15,FOLLOW_15_in_map407); 

                    pushFollow(FOLLOW_expr_in_map411);
                    v=expr(defer);

                    state._fsp--;


                    values.add((v!=null?v.value:null));

                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:63:92: ( ',' k= expr[defer] ':' v= expr[defer] )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==13) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:63:94: ',' k= expr[defer] ':' v= expr[defer]
                    	    {
                    	    match(input,13,FOLLOW_13_in_map418); 

                    	    pushFollow(FOLLOW_expr_in_map422);
                    	    k=expr(defer);

                    	    state._fsp--;


                    	    keys.add((k!=null?k.value:null));

                    	    match(input,15,FOLLOW_15_in_map427); 

                    	    pushFollow(FOLLOW_expr_in_map431);
                    	    v=expr(defer);

                    	    state._fsp--;


                    	    values.add((v!=null?v.value:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,21,FOLLOW_21_in_map442); 

             value = interp.map(keys, values); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "map"



    // $ANTLR start "funcdef"
    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:66:1: funcdef returns [Object value] : '|' (t= TYPE p= ID ( ',' t= TYPE p= ID )* )? '->' rt= TYPE '|' '{' (s= statement[true] )* 'return' r= expr[true] '}' ;
    public final Object funcdef() throws RecognitionException {
        Object value = null;


        Token t=null;
        Token p=null;
        Token rt=null;
        IpaParser.statement_return s =null;

        IpaParser.expr_return r =null;


         List<String> types = new ArrayList<String>(); List<String> parameters = new ArrayList<String>(); List<String> statements = new ArrayList<String>(); String returnType = null; String returnExpr = null; 
        try {
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:2: ( '|' (t= TYPE p= ID ( ',' t= TYPE p= ID )* )? '->' rt= TYPE '|' '{' (s= statement[true] )* 'return' r= expr[true] '}' )
            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:4: '|' (t= TYPE p= ID ( ',' t= TYPE p= ID )* )? '->' rt= TYPE '|' '{' (s= statement[true] )* 'return' r= expr[true] '}'
            {
            match(input,24,FOLLOW_24_in_funcdef466); 

            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:8: (t= TYPE p= ID ( ',' t= TYPE p= ID )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==TYPE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:10: t= TYPE p= ID ( ',' t= TYPE p= ID )*
                    {
                    t=(Token)match(input,TYPE,FOLLOW_TYPE_in_funcdef472); 

                    types.add((t!=null?t.getText():null));

                    p=(Token)match(input,ID,FOLLOW_ID_in_funcdef478); 

                    parameters.add((p!=null?p.getText():null));

                    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:71: ( ',' t= TYPE p= ID )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==13) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:72: ',' t= TYPE p= ID
                    	    {
                    	    match(input,13,FOLLOW_13_in_funcdef483); 

                    	    t=(Token)match(input,TYPE,FOLLOW_TYPE_in_funcdef487); 

                    	    types.add((t!=null?t.getText():null));

                    	    p=(Token)match(input,ID,FOLLOW_ID_in_funcdef493); 

                    	    parameters.add((p!=null?p.getText():null));

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,14,FOLLOW_14_in_funcdef503); 

            rt=(Token)match(input,TYPE,FOLLOW_TYPE_in_funcdef507); 

             returnType = (rt!=null?rt.getText():null);

            match(input,24,FOLLOW_24_in_funcdef511); 

            match(input,23,FOLLOW_23_in_funcdef513); 

            // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:190: (s= statement[true] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\dev\\workspaces\\lang\\ipa\\src\\main\\com\\kevinchard\\ipa\\lang\\Ipa.g:68:192: s= statement[true]
            	    {
            	    pushFollow(FOLLOW_statement_in_funcdef519);
            	    s=statement(true);

            	    state._fsp--;


            	     statements.add((s!=null?input.toString(s.start,s.stop):null)); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            match(input,22,FOLLOW_22_in_funcdef527); 

            pushFollow(FOLLOW_expr_in_funcdef531);
            r=expr(true);

            state._fsp--;


            returnExpr = (r!=null?input.toString(r.start,r.stop):null);

            match(input,25,FOLLOW_25_in_funcdef536); 

             value = interp.funcDef(types, parameters, statements, returnType, returnExpr); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "funcdef"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program47 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EOF_in_program55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_statement73 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_statement75 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_statement79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funccall_in_statement87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_expr110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funccall_in_expr128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_funccall154 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_funccall156 = new BitSet(new long[]{0x00000000010E91A0L});
    public static final BitSet FOLLOW_expr_in_funccall162 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_13_in_funccall169 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_funccall173 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_funccall184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_literal205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_literal212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_literal219 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_literal221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_literal230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcdef_in_literal260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_list284 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_list286 = new BitSet(new long[]{0x00000000012E81A0L});
    public static final BitSet FOLLOW_expr_in_list292 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_13_in_list299 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_list303 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_21_in_list314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_set339 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_set341 = new BitSet(new long[]{0x00000000012E81A0L});
    public static final BitSet FOLLOW_expr_in_set347 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_13_in_set354 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_set358 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_21_in_set369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_map394 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_map396 = new BitSet(new long[]{0x00000000012E81A0L});
    public static final BitSet FOLLOW_expr_in_map402 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_map407 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_map411 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_13_in_map418 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_map422 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_map427 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_map431 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_21_in_map442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_funcdef466 = new BitSet(new long[]{0x0000000000004200L});
    public static final BitSet FOLLOW_TYPE_in_funcdef472 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_funcdef478 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_funcdef483 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TYPE_in_funcdef487 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_funcdef493 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_funcdef503 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TYPE_in_funcdef507 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_funcdef511 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_funcdef513 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_statement_in_funcdef519 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_22_in_funcdef527 = new BitSet(new long[]{0x00000000010E81A0L});
    public static final BitSet FOLLOW_expr_in_funcdef531 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_funcdef536 = new BitSet(new long[]{0x0000000000000002L});

}