// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.tree;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.zede.mol.tree.psi.TreeTypes;
import com.intellij.psi.TokenType;

%%

%class TreeLexer
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
VALUE_PREFIX= \\
SPACE= [ ]
NAME= [^\\ \n\r\t]
VALUE= [^\n]

%column
%state WAITING_VALUE
%state MAIN
%state DENT
%state DENT2

%%
<YYINITIAL> {
    {NAME}+ { yybegin(MAIN); System.out.println("NAME(" + yytext() + ")"); return TreeTypes.NAME; }
}

<MAIN> {
    {NAME}+ { yybegin(MAIN); System.out.println("NAME(" + yytext() + ")"); return TreeTypes.NAME; }

    {SPACE} { yybegin(MAIN); System.out.println("SPACE"); return TreeTypes.SPACE; }

    {VALUE_PREFIX} { yybegin(WAITING_VALUE); System.out.println("VALUE_PREFIX"); return TreeTypes.VALUE_PREFIX; }
}

<WAITING_VALUE> {VALUE}* { yybegin(MAIN); System.out.println("VALUE(" + yytext() + ")"); return TreeTypes.VALUE; }

<DENT, DENT2> {
    \t* {
        int dent = yylength();
        if (dent == prevDent) {
            if (dent == 0)
                yybegin(YYINITIAL);
            else
                yybegin(MAIN);
        } else if (dent > prevDent) {
            yybegin(MAIN);
            prevDent += 1;
            System.out.println("INDENT");
            return TreeTypes.INDENT;
        } else {
            yybegin(yystate() == DENT ? DENT2 : DENT);
            prevDent -= 1;
            yypushback(dent);
            System.out.println("DEDENT");
            return TreeTypes.DEDENT;
        }
    }

    \n {
        if (prevDent == 0) {
            yybegin(YYINITIAL);
            return TreeTypes.LF;
        } else {
            yybegin(yystate() == DENT ? DENT2 : DENT);
            prevDent -= 1;
            yypushback(1);
            System.out.println("DEDENT LF");
            return TreeTypes.DEDENT;
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
    System.out.println("LF");
    if (zzMarkedPosL == zzEndReadL) {
        yypushback(1);
    }
    yybegin(DENT);
    return TreeTypes.LF;
}

. { System.out.println("BAD_CHARACTER(" + yystate() + ":" + yytext() + ")"); return TokenType.BAD_CHARACTER; }
