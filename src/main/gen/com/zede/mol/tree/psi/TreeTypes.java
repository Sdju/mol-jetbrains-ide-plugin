// This is a generated file. Not intended for manual editing.
package com.zede.mol.tree.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.zede.mol.tree.psi.impl.*;

public interface TreeTypes {

  IElementType PROPERTY = new TreeElementType("PROPERTY");
  IElementType WHITE_SPACE = new TreeElementType("WHITE_SPACE");
  IElementType BAD_CHARACTER = new TreeElementType("BAD_CHARACTER");

  IElementType COMMENT = new TreeTokenType("COMMENT");
  IElementType CRLF = new TreeTokenType("CRLF");
  IElementType KEY = new TreeTokenType("KEY");
  IElementType SEPARATOR = new TreeTokenType("SEPARATOR");
  IElementType VALUE = new TreeTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new TreePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
