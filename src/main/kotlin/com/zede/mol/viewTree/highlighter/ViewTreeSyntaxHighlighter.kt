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
        if (tokenType == ViewTreeTypes.VALUE_PREFIX) {
            return VALUE_PREFIX_KEYS
        }
        return if (tokenType == TokenType.BAD_CHARACTER) {
            BAD_CHAR_KEYS
        } else EMPTY_KEYS
    }

    companion object {
        val VALUE = TextAttributesKey.createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
        val NAME = TextAttributesKey.createTextAttributesKey("NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
        val VALUE_PREFIX = TextAttributesKey.createTextAttributesKey("VALUE_PREFIX", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("BAD_CHARACTER", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val NAME_KEYS = arrayOf(NAME)
        private val VALUE_PREFIX_KEYS = arrayOf(VALUE_PREFIX)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}