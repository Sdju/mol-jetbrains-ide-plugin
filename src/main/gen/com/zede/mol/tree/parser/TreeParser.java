// This is a generated file. Not intended for manual editing.
package com.zede.mol.tree.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.zede.mol.tree.psi.TreeTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TreeParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return treeFile(b, l + 1);
  }

  /* ********************************************************** */
  // NAME (SPACE NAME)* (SPACE VALUE_PREFIX VALUE?)? LF+ itemContent?
  public static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    r = r && item_1(b, l + 1);
    r = r && item_2(b, l + 1);
    r = r && item_3(b, l + 1);
    r = r && item_4(b, l + 1);
    exit_section_(b, m, ITEM, r);
    return r;
  }

  // (SPACE NAME)*
  private static boolean item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "item_1", c)) break;
    }
    return true;
  }

  // SPACE NAME
  private static boolean item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SPACE, NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SPACE VALUE_PREFIX VALUE?)?
  private static boolean item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_2")) return false;
    item_2_0(b, l + 1);
    return true;
  }

  // SPACE VALUE_PREFIX VALUE?
  private static boolean item_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SPACE, VALUE_PREFIX);
    r = r && item_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE?
  private static boolean item_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_2_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  // LF+
  private static boolean item_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LF);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LF)) break;
      if (!empty_element_parsed_guard_(b, "item_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // itemContent?
  private static boolean item_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_4")) return false;
    itemContent(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // INDENT (item | (VALUE_PREFIX VALUE? LF))+ DEDENT
  public static boolean itemContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemContent")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && itemContent_1(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, ITEM_CONTENT, r);
    return r;
  }

  // (item | (VALUE_PREFIX VALUE? LF))+
  private static boolean itemContent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemContent_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = itemContent_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!itemContent_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "itemContent_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // item | (VALUE_PREFIX VALUE? LF)
  private static boolean itemContent_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemContent_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item(b, l + 1);
    if (!r) r = itemContent_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE_PREFIX VALUE? LF
  private static boolean itemContent_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemContent_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALUE_PREFIX);
    r = r && itemContent_1_0_1_1(b, l + 1);
    r = r && consumeToken(b, LF);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE?
  private static boolean itemContent_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemContent_1_0_1_1")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // (item|LF)*
  static boolean treeFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "treeFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!treeFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "treeFile", c)) break;
    }
    return true;
  }

  // item|LF
  private static boolean treeFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "treeFile_0")) return false;
    boolean r;
    r = item(b, l + 1);
    if (!r) r = consumeToken(b, LF);
    return r;
  }

}
