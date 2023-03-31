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
  // INDENT* ( property SPACE* )* ( VALUE_PREFIX VALUE? )?
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item__0(b, l + 1);
    r = r && item__1(b, l + 1);
    r = r && item__2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // INDENT*
  private static boolean item__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, INDENT)) break;
      if (!empty_element_parsed_guard_(b, "item__0", c)) break;
    }
    return true;
  }

  // ( property SPACE* )*
  private static boolean item__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item__1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "item__1", c)) break;
    }
    return true;
  }

  // property SPACE*
  private static boolean item__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property(b, l + 1);
    r = r && item__1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE*
  private static boolean item__1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "item__1_0_1", c)) break;
    }
    return true;
  }

  // ( VALUE_PREFIX VALUE? )?
  private static boolean item__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__2")) return false;
    item__2_0(b, l + 1);
    return true;
  }

  // VALUE_PREFIX VALUE?
  private static boolean item__2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALUE_PREFIX);
    r = r && item__2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE?
  private static boolean item__2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__2_0_1")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // NAME
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  /* ********************************************************** */
  // ( item_ LF )* item_?
  static boolean treeFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "treeFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = treeFile_0(b, l + 1);
    r = r && treeFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( item_ LF )*
  private static boolean treeFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "treeFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!treeFile_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "treeFile_0", c)) break;
    }
    return true;
  }

  // item_ LF
  private static boolean treeFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "treeFile_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_(b, l + 1);
    r = r && consumeToken(b, LF);
    exit_section_(b, m, null, r);
    return r;
  }

  // item_?
  private static boolean treeFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "treeFile_1")) return false;
    item_(b, l + 1);
    return true;
  }

}
