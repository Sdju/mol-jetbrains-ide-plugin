// This is a generated file. Not intended for manual editing.
package com.zede.mol.tree.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.zede.mol.tree.psi.impl.*;

public interface TreeTypes {

  IElementType PROPERTY = new TreeElementType("PROPERTY");

  IElementType INDENT = new TreeTokenType("INDENT");
  IElementType LF = new TreeTokenType("LF");
  IElementType NAME = new TreeTokenType("NAME");
  IElementType SPACE = new TreeTokenType("SPACE");
  IElementType VALUE = new TreeTokenType("VALUE");
  IElementType VALUE_PREFIX = new TreeTokenType("VALUE_PREFIX");

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
