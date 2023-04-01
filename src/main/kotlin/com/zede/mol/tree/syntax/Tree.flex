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
private int myIdentCount = 0;
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

%%
<YYINITIAL> {
    {INDENT}+ {
        yybegin(MAIN);
        myIdentCount += 1;
        yypushback();
        return TreeTypes.INDENT;
   }

    {NAME}+ {
        yybegin(MAIN);
        return TreeTypes.NAME;
    }
}
<MAIN> {
    {NAME}+ { yybegin(MAIN); return TreeTypes.NAME; }

    {SPACE}+ { yybegin(MAIN); return TreeTypes.SPACE; }

    {VALUE_PREFIX} { yybegin(WAITING_VALUE); return TreeTypes.VALUE_PREFIX; }
}

<WAITING_VALUE> {VALUE}* { yybegin(YYINITIAL); return TreeTypes.VALUE; }

{LF} {
    if (myIdentCount == 0) {
        yybegin(YYINITIAL);
        return TreeTypes.LF;
    }
}

. { return TokenType.BAD_CHARACTER; }