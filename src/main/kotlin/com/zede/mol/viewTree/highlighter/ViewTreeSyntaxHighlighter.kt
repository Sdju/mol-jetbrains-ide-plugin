package com.zede.mol.viewTree.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.zede.mol.viewTree.ViewTreeLexerAdapter
import com.zede.mol.viewTree.psi.ViewTreeTypes


class ViewTreeSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ViewTreeLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
       if (tokenType == ViewTreeTypes.VALUE) {
            return VALUE_KEYS
        }
        if (tokenType == ViewTreeTypes.NAME) {
            return NAME_KEYS
        }
        if (tokenType == ViewTreeTypes.FQN_NAME) {
            return FQN_NAME_KEYS
        }
        if (tokenType == ViewTreeTypes.VALUE_PREFIX) {
            return VALUE_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_ATOM) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_OBJECT) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_PROPERTY_OBSOLET) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_ARRAY) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_LEFT_BIND) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_RIGHT_BIND) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_REASSIGN) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_LOCALISATION) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.OPERATOR_TWO_WAY_BIND) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.VALUE_PREFIX) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.VALUE_PREFIX) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.VALUE_PREFIX) {
            return OPERATOR_KEYS
        }
        if (tokenType == ViewTreeTypes.NUMBER) {
            return NUMBER_KEYS
        }
        if (tokenType == ViewTreeTypes.COMMENT) {
            return COMMENT_KEYS
        }
        if (tokenType == ViewTreeTypes.CONST_TRUE) {
            return CONST_KEYS
        }
        if (tokenType == ViewTreeTypes.CONST_FALSE) {
            return CONST_KEYS
        }
        if (tokenType == ViewTreeTypes.CONST_NAN) {
            return CONST_KEYS
        }
        if (tokenType == ViewTreeTypes.CONST_INFINITY) {
            return CONST_KEYS
        }
        if (tokenType == ViewTreeTypes.CONST_UNDEFINED) {
            return CONST_KEYS
        }
        if (tokenType == ViewTreeTypes.CONST_NULL) {
            return CONST_KEYS
        }
        return if (tokenType == TokenType.BAD_CHARACTER) {
            BAD_CHAR_KEYS
        } else EMPTY_KEYS
    }

    companion object {
        val VALUE = TextAttributesKey.createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
        val NAME = TextAttributesKey.createTextAttributesKey("NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
        val FQN_NAME = TextAttributesKey.createTextAttributesKey("FQN_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
        val OPERATOR = TextAttributesKey.createTextAttributesKey("OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val NUMBER = TextAttributesKey.createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val COMMENT = TextAttributesKey.createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val CONST = TextAttributesKey.createTextAttributesKey("CONST", DefaultLanguageHighlighterColors.KEYWORD)
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("BAD_CHARACTER", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)

        private val VALUE_KEYS = arrayOf(VALUE)
        private val NAME_KEYS = arrayOf(NAME)
        private val FQN_NAME_KEYS = arrayOf(FQN_NAME)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val CONST_KEYS = arrayOf(CONST)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}