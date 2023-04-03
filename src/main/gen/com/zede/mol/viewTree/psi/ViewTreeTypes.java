// This is a generated file. Not intended for manual editing.
package com.zede.mol.viewTree.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.zede.mol.viewTree.psi.impl.*;

public interface ViewTreeTypes {

  IElementType ARRAY_ITEMS_VALUE = new ViewTreeElementType("ARRAY_ITEMS_VALUE");
  IElementType COMPONENT = new ViewTreeElementType("COMPONENT");
  IElementType COMPONENT_ATTRIBUTES = new ViewTreeElementType("COMPONENT_ATTRIBUTES");
  IElementType OBJECT_KEYS_VALUE = new ViewTreeElementType("OBJECT_KEYS_VALUE");

  IElementType COMMENT = new ViewTreeTokenType("COMMENT");
  IElementType DEDENT = new ViewTreeTokenType("DEDENT");
  IElementType FQN_NAME = new ViewTreeTokenType("FQN_NAME");
  IElementType INDENT = new ViewTreeTokenType("INDENT");
  IElementType LF = new ViewTreeTokenType("LF");
  IElementType NAME = new ViewTreeTokenType("NAME");
  IElementType NUMBER = new ViewTreeTokenType("NUMBER");
  IElementType OPERATOR_ARRAY = new ViewTreeTokenType("OPERATOR_ARRAY");
  IElementType OPERATOR_ATOM = new ViewTreeTokenType("OPERATOR_ATOM");
  IElementType OPERATOR_LEFT_BIND = new ViewTreeTokenType("OPERATOR_LEFT_BIND");
  IElementType OPERATOR_LOCALISATION = new ViewTreeTokenType("OPERATOR_LOCALISATION");
  IElementType OPERATOR_OBJECT = new ViewTreeTokenType("OPERATOR_OBJECT");
  IElementType OPERATOR_REASSIGN = new ViewTreeTokenType("OPERATOR_REASSIGN");
  IElementType OPERATOR_RIGHT_BIND = new ViewTreeTokenType("OPERATOR_RIGHT_BIND");
  IElementType OPERATOR_TWO_WAY_BIND = new ViewTreeTokenType("OPERATOR_TWO_WAY_BIND");
  IElementType SPACE = new ViewTreeTokenType("SPACE");
  IElementType VALUE = new ViewTreeTokenType("VALUE");
  IElementType VALUE_PREFIX = new ViewTreeTokenType("VALUE_PREFIX");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_ITEMS_VALUE) {
        return new ViewTreeArrayItemsValueImpl(node);
      }
      else if (type == COMPONENT) {
        return new ViewTreeComponentImpl(node);
      }
      else if (type == COMPONENT_ATTRIBUTES) {
        return new ViewTreeComponentAttributesImpl(node);
      }
      else if (type == OBJECT_KEYS_VALUE) {
        return new ViewTreeObjectKeysValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
