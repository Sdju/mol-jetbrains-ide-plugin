// This is a generated file. Not intended for manual editing.
package com.zede.mol.viewTree.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.zede.mol.viewTree.psi.ViewTreeTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ViewTreeParser implements PsiParser, LightPsiParser {

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
    return viewTreeFile(b, l + 1);
  }

  /* ********************************************************** */
  // INDENT (componentValue)* DEDENT
  public static boolean arrayItemsValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayItemsValue")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && arrayItemsValue_1(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, ARRAY_ITEMS_VALUE, r);
    return r;
  }

  // (componentValue)*
  private static boolean arrayItemsValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayItemsValue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arrayItemsValue_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayItemsValue_1", c)) break;
    }
    return true;
  }

  // (componentValue)
  private static boolean arrayItemsValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayItemsValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OPERATOR_ARRAY gap arrayItemsValue
  static boolean arrayValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayValue")) return false;
    if (!nextTokenIs(b, OPERATOR_ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_ARRAY);
    r = r && gap(b, l + 1);
    r = r && arrayItemsValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // instance SPACE+ instance gap componentAttributes?
  public static boolean component(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "component")) return false;
    if (!nextTokenIs(b, "<component>", FQN_NAME, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPONENT, "<component>");
    r = instance(b, l + 1);
    r = r && component_1(b, l + 1);
    r = r && instance(b, l + 1);
    r = r && gap(b, l + 1);
    r = r && component_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SPACE+
  private static boolean component_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "component_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "component_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // componentAttributes?
  private static boolean component_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "component_4")) return false;
    componentAttributes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NAME modifier? SPACE+ componentValue
  static boolean componentAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentAttribute")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    r = r && componentAttribute_1(b, l + 1);
    r = r && componentAttribute_2(b, l + 1);
    r = r && componentValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // modifier?
  private static boolean componentAttribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentAttribute_1")) return false;
    modifier(b, l + 1);
    return true;
  }

  // SPACE+
  private static boolean componentAttribute_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentAttribute_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "componentAttribute_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INDENT (componentAttribute)+ DEDENT
  public static boolean componentAttributes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentAttributes")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && componentAttributes_1(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, COMPONENT_ATTRIBUTES, r);
    return r;
  }

  // (componentAttribute)+
  private static boolean componentAttributes_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentAttributes_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentAttributes_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!componentAttributes_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "componentAttributes_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (componentAttribute)
  private static boolean componentAttributes_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentAttributes_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // simpleValue | leftBindValue | rightBindValue | twoWayBindValue
  static boolean componentValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentValue")) return false;
    boolean r;
    r = simpleValue(b, l + 1);
    if (!r) r = leftBindValue(b, l + 1);
    if (!r) r = rightBindValue(b, l + 1);
    if (!r) r = twoWayBindValue(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (SPACE COMMENT)? (COMMENT|LF)+
  static boolean gap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gap")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gap_0(b, l + 1);
    r = r && gap_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SPACE COMMENT)?
  private static boolean gap_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gap_0")) return false;
    gap_0_0(b, l + 1);
    return true;
  }

  // SPACE COMMENT
  private static boolean gap_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gap_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SPACE, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMENT|LF)+
  private static boolean gap_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gap_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gap_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!gap_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gap_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT|LF
  private static boolean gap_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gap_1_0")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, LF);
    return r;
  }

  /* ********************************************************** */
  // NAME|FQN_NAME
  static boolean instance(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance")) return false;
    if (!nextTokenIs(b, "", FQN_NAME, NAME)) return false;
    boolean r;
    r = consumeToken(b, NAME);
    if (!r) r = consumeToken(b, FQN_NAME);
    return r;
  }

  /* ********************************************************** */
  // OPERATOR_LEFT_BIND SPACE+ NAME modifier? SPACE* ((FQN_NAME gap componentAttributes?)|simpleValue|gap)?
  static boolean leftBindValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue")) return false;
    if (!nextTokenIs(b, OPERATOR_LEFT_BIND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_LEFT_BIND);
    r = r && leftBindValue_1(b, l + 1);
    r = r && consumeToken(b, NAME);
    r = r && leftBindValue_3(b, l + 1);
    r = r && leftBindValue_4(b, l + 1);
    r = r && leftBindValue_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE+
  private static boolean leftBindValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "leftBindValue_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // modifier?
  private static boolean leftBindValue_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue_3")) return false;
    modifier(b, l + 1);
    return true;
  }

  // SPACE*
  private static boolean leftBindValue_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "leftBindValue_4", c)) break;
    }
    return true;
  }

  // ((FQN_NAME gap componentAttributes?)|simpleValue|gap)?
  private static boolean leftBindValue_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue_5")) return false;
    leftBindValue_5_0(b, l + 1);
    return true;
  }

  // (FQN_NAME gap componentAttributes?)|simpleValue|gap
  private static boolean leftBindValue_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = leftBindValue_5_0_0(b, l + 1);
    if (!r) r = simpleValue(b, l + 1);
    if (!r) r = gap(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FQN_NAME gap componentAttributes?
  private static boolean leftBindValue_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FQN_NAME);
    r = r && gap(b, l + 1);
    r = r && leftBindValue_5_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentAttributes?
  private static boolean leftBindValue_5_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftBindValue_5_0_0_2")) return false;
    componentAttributes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SPACE* (OPERATOR_ATOM (SPACE* NAME)?)|(OPERATOR_OBJECT SPACE* NAME)
  static boolean modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier_0(b, l + 1);
    if (!r) r = modifier_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE* (OPERATOR_ATOM (SPACE* NAME)?)
  private static boolean modifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier_0_0(b, l + 1);
    r = r && modifier_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE*
  private static boolean modifier_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "modifier_0_0", c)) break;
    }
    return true;
  }

  // OPERATOR_ATOM (SPACE* NAME)?
  private static boolean modifier_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_ATOM);
    r = r && modifier_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SPACE* NAME)?
  private static boolean modifier_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_0_1_1")) return false;
    modifier_0_1_1_0(b, l + 1);
    return true;
  }

  // SPACE* NAME
  private static boolean modifier_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_0_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier_0_1_1_0_0(b, l + 1);
    r = r && consumeToken(b, NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE*
  private static boolean modifier_0_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_0_1_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "modifier_0_1_1_0_0", c)) break;
    }
    return true;
  }

  // OPERATOR_OBJECT SPACE* NAME
  private static boolean modifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_OBJECT);
    r = r && modifier_1_1(b, l + 1);
    r = r && consumeToken(b, NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE*
  private static boolean modifier_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "modifier_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NUMBER gap
  static boolean numberValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numberValue")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && gap(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INDENT (OPERATOR_REASSIGN gap)? componentAttribute* DEDENT
  public static boolean objectKeysValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectKeysValue")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && objectKeysValue_1(b, l + 1);
    r = r && objectKeysValue_2(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, OBJECT_KEYS_VALUE, r);
    return r;
  }

  // (OPERATOR_REASSIGN gap)?
  private static boolean objectKeysValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectKeysValue_1")) return false;
    objectKeysValue_1_0(b, l + 1);
    return true;
  }

  // OPERATOR_REASSIGN gap
  private static boolean objectKeysValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectKeysValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_REASSIGN);
    r = r && gap(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentAttribute*
  private static boolean objectKeysValue_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectKeysValue_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!componentAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "objectKeysValue_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPERATOR_OBJECT gap objectKeysValue
  static boolean objectValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectValue")) return false;
    if (!nextTokenIs(b, OPERATOR_OBJECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_OBJECT);
    r = r && gap(b, l + 1);
    r = r && objectKeysValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OPERATOR_RIGHT_BIND SPACE+ NAME modifier? SPACE* ((FQN_NAME gap componentAttributes?)|simpleValue|gap)?
  static boolean rightBindValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue")) return false;
    if (!nextTokenIs(b, OPERATOR_RIGHT_BIND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_RIGHT_BIND);
    r = r && rightBindValue_1(b, l + 1);
    r = r && consumeToken(b, NAME);
    r = r && rightBindValue_3(b, l + 1);
    r = r && rightBindValue_4(b, l + 1);
    r = r && rightBindValue_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE+
  private static boolean rightBindValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "rightBindValue_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // modifier?
  private static boolean rightBindValue_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue_3")) return false;
    modifier(b, l + 1);
    return true;
  }

  // SPACE*
  private static boolean rightBindValue_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "rightBindValue_4", c)) break;
    }
    return true;
  }

  // ((FQN_NAME gap componentAttributes?)|simpleValue|gap)?
  private static boolean rightBindValue_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue_5")) return false;
    rightBindValue_5_0(b, l + 1);
    return true;
  }

  // (FQN_NAME gap componentAttributes?)|simpleValue|gap
  private static boolean rightBindValue_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rightBindValue_5_0_0(b, l + 1);
    if (!r) r = simpleValue(b, l + 1);
    if (!r) r = gap(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FQN_NAME gap componentAttributes?
  private static boolean rightBindValue_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FQN_NAME);
    r = r && gap(b, l + 1);
    r = r && rightBindValue_5_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentAttributes?
  private static boolean rightBindValue_5_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rightBindValue_5_0_0_2")) return false;
    componentAttributes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // stringValue | numberValue | arrayValue | objectValue
  static boolean simpleValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleValue")) return false;
    boolean r;
    r = stringValue(b, l + 1);
    if (!r) r = numberValue(b, l + 1);
    if (!r) r = arrayValue(b, l + 1);
    if (!r) r = objectValue(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (OPERATOR_LOCALISATION SPACE+)? VALUE_PREFIX VALUE? gap
  static boolean stringValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringValue")) return false;
    if (!nextTokenIs(b, "", OPERATOR_LOCALISATION, VALUE_PREFIX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringValue_0(b, l + 1);
    r = r && consumeToken(b, VALUE_PREFIX);
    r = r && stringValue_2(b, l + 1);
    r = r && gap(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (OPERATOR_LOCALISATION SPACE+)?
  private static boolean stringValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringValue_0")) return false;
    stringValue_0_0(b, l + 1);
    return true;
  }

  // OPERATOR_LOCALISATION SPACE+
  private static boolean stringValue_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringValue_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_LOCALISATION);
    r = r && stringValue_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE+
  private static boolean stringValue_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringValue_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "stringValue_0_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE?
  private static boolean stringValue_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringValue_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // OPERATOR_TWO_WAY_BIND SPACE+ NAME modifier? SPACE* (gap | simpleValue)
  static boolean twoWayBindValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "twoWayBindValue")) return false;
    if (!nextTokenIs(b, OPERATOR_TWO_WAY_BIND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_TWO_WAY_BIND);
    r = r && twoWayBindValue_1(b, l + 1);
    r = r && consumeToken(b, NAME);
    r = r && twoWayBindValue_3(b, l + 1);
    r = r && twoWayBindValue_4(b, l + 1);
    r = r && twoWayBindValue_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPACE+
  private static boolean twoWayBindValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "twoWayBindValue_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "twoWayBindValue_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // modifier?
  private static boolean twoWayBindValue_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "twoWayBindValue_3")) return false;
    modifier(b, l + 1);
    return true;
  }

  // SPACE*
  private static boolean twoWayBindValue_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "twoWayBindValue_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SPACE)) break;
      if (!empty_element_parsed_guard_(b, "twoWayBindValue_4", c)) break;
    }
    return true;
  }

  // gap | simpleValue
  private static boolean twoWayBindValue_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "twoWayBindValue_5")) return false;
    boolean r;
    r = gap(b, l + 1);
    if (!r) r = simpleValue(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // instance|NUMBER
  static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    r = instance(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // (component|LF)*
  static boolean viewTreeFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewTreeFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!viewTreeFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "viewTreeFile", c)) break;
    }
    return true;
  }

  // component|LF
  private static boolean viewTreeFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewTreeFile_0")) return false;
    boolean r;
    r = component(b, l + 1);
    if (!r) r = consumeToken(b, LF);
    return r;
  }

}
