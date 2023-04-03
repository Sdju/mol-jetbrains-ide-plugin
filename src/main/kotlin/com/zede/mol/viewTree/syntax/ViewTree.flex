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
    {NAME}+ { yybegin(MAIN); return ViewTreeTypes.NAME; }
}

<MAIN> {
    {NAME}+ { yybegin(MAIN); return ViewTreeTypes.NAME; }

    {SPACE} { yybegin(MAIN); return ViewTreeTypes.SPACE; }

    {VALUE_PREFIX} { yybegin(WAITING_VALUE); return ViewTreeTypes.VALUE_PREFIX; }
}

<WAITING_VALUE> {VALUE}* { yybegin(MAIN); return ViewTreeTypes.VALUE; }

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
