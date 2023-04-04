// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.viewTree;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.zede.mol.viewTree.psi.ViewTreeTypes;

%%

%class ViewTreeLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    private int prevDent = 0;
%}

LF= \n
INDENT= \t
NUMBER= (\+|\-)?\d+\.?\d*
VALUE_PREFIX= \\
OPERATOR_LEFT_BIND= <=
OPERATOR_RIGHT_BIND= >=
OPERATOR_TWO_WAY_BIND= <=>
OPERATOR_OBJECT= \*
OPERATOR_ARRAY= \/
OPERATOR_REASSIGN = \^
OPERATOR_ATOM = \?
OPERATOR_LOCALISATION = @
SPACE= [ ]
NAME= [A-Za-z_][A-Za-z0-9_]*
VALUE= [^\n]
COMMENT= -[ ][^\n]*
CONST_TRUE= true
CONST_FALSE= false
CONST_NAN= NaN
CONST_NULL= null
CONST_UNDEFINED= undefined
CONST_INFINITY= (\+|\-)?Infinity

%column
%state MAIN
%state WAITING_VALUE
%state DENT
%state DENT2

%%
<YYINITIAL> {
    \${NAME} { yybegin(MAIN); return ViewTreeTypes.FQN_NAME; }

    {NAME} { yybegin(MAIN); return ViewTreeTypes.NAME; }
}

<MAIN> {
    {COMMENT} { yybegin(MAIN); return ViewTreeTypes.COMMENT; }

    {NUMBER} { yybegin(MAIN); return ViewTreeTypes.NUMBER; }

    {CONST_TRUE} { yybegin(MAIN); return ViewTreeTypes.CONST_TRUE; }

    {CONST_FALSE} { yybegin(MAIN); return ViewTreeTypes.CONST_FALSE; }

    {CONST_NAN} { yybegin(MAIN); return ViewTreeTypes.CONST_NAN; }

    {CONST_NULL} { yybegin(MAIN); return ViewTreeTypes.CONST_NULL; }

    {CONST_UNDEFINED} { yybegin(MAIN); return ViewTreeTypes.CONST_UNDEFINED; }

    {CONST_INFINITY} { yybegin(MAIN); return ViewTreeTypes.CONST_INFINITY; }

    \${NAME} { yybegin(MAIN); return ViewTreeTypes.FQN_NAME; }

    {NAME} { yybegin(MAIN); return ViewTreeTypes.NAME; }

    {SPACE} { yybegin(MAIN); return ViewTreeTypes.SPACE; }

    {VALUE_PREFIX} { yybegin(WAITING_VALUE); return ViewTreeTypes.VALUE_PREFIX; }

    {OPERATOR_ARRAY} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_ARRAY; }

    {OPERATOR_OBJECT} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_OBJECT; }

    {OPERATOR_LEFT_BIND} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_LEFT_BIND; }

    {OPERATOR_RIGHT_BIND} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_RIGHT_BIND; }

    {OPERATOR_TWO_WAY_BIND} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_TWO_WAY_BIND; }

    {OPERATOR_ATOM} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_ATOM; }

    {OPERATOR_REASSIGN} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_REASSIGN; }

    {OPERATOR_LOCALISATION} { yybegin(MAIN); return ViewTreeTypes.OPERATOR_LOCALISATION; }
}

<WAITING_VALUE> {VALUE}* { yybegin(MAIN); return ViewTreeTypes.VALUE; }

<DENT, DENT2> {
    \t* {
        int dent = yylength();
        if (dent == prevDent) {
            yybegin(dent == 0 ? YYINITIAL : MAIN);
        } else if (dent > prevDent) {
            yybegin(MAIN);
            prevDent += 1;
            return ViewTreeTypes.INDENT;
        } else {
            yybegin(yystate() == DENT ? DENT2 : DENT);
            prevDent -= 1;
            yypushback(dent);
            return ViewTreeTypes.DEDENT;
        }
    }

    \n {
        if (prevDent == 0) {
            yybegin(YYINITIAL);
            return ViewTreeTypes.LF;
        } else {
            yybegin(yystate() == DENT ? DENT2 : DENT);
            prevDent -= 1;
            yypushback(1);
            return ViewTreeTypes.DEDENT;
        }
    }

    . {
        if (prevDent == 0)
            yybegin(YYINITIAL);
        else
            yybegin(MAIN);
    }
}

{LF} {
    if (zzMarkedPosL == zzEndReadL) {
        yypushback(1);
    }
    yybegin(DENT);
    return ViewTreeTypes.LF;
}

. { return TokenType.BAD_CHARACTER; }
