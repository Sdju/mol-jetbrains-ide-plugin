package com.zede.mol.tree

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.zede.mol.tree.parser.TreeParser
import com.zede.mol.tree.psi.TreeTypes

class TreeParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return TreeLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return TreeTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return TreeParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return TreeFile(viewProvider)
    }

    override fun createElement(node: ASTNode): PsiElement {
        return TreeTypes.Factory.createElement(node)
    }

    companion object {
        val FILE = IFileElementType(TreeLanguage.INSTANCE)
    }
}