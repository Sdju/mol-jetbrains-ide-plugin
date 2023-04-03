// This is a generated file. Not intended for manual editing.
package com.zede.mol.viewTree.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.zede.mol.viewTree.psi.impl.*;

public interface ViewTreeTypes {

  IElementType ITEM = new ViewTreeElementType("ITEM");
  IElementType ITEM_CONTENT = new ViewTreeElementType("ITEM_CONTENT");

  IElementType DEDENT = new ViewTreeTokenType("DEDENT");
  IElementType INDENT = new ViewTreeTokenType("INDENT");
  IElementType LF = new ViewTreeTokenType("LF");
  IElementType NAME = new ViewTreeTokenType("NAME");
  IElementType SPACE = new ViewTreeTokenType("SPACE");
  IElementType VALUE = new ViewTreeTokenType("VALUE");
  IElementType VALUE_PREFIX = new ViewTreeTokenType("VALUE_PREFIX");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ITEM) {
        return new ViewTreeItemImpl(node);
      }
      else if (type == ITEM_CONTENT) {
        return new ViewTreeItemContentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
