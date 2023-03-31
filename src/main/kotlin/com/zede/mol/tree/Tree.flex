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

LF= [\n]
INDENT= [\t]
VALUE_PREFIX= [\\]
SPACE= [ ]
NAME= [^\\ \n\r\t]
VALUE= [^\n]

%state WAITING_VALUE

%%

<YYINITIAL> {NAME}+ { yybegin(YYINITIAL); return TreeTypes.NAME; }

<YYINITIAL> {VALUE_PREFIX} { yybegin(WAITING_VALUE); return TreeTypes.VALUE_PREFIX; }

<WAITING_VALUE> {LF} { yybegin(YYINITIAL); return TreeTypes.LF; }

<WAITING_VALUE> {VALUE}* { yybegin(YYINITIAL); return TreeTypes.VALUE; }

{LF} { yybegin(YYINITIAL); return TreeTypes.LF; }

{SPACE}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

. { return TokenType.BAD_CHARACTER; }