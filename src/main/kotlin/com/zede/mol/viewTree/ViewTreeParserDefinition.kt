package com.zede.mol.viewTree

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
import com.zede.mol.viewTree.parser.ViewTreeParser
import com.zede.mol.viewTree.psi.ViewTreeTypes

class ViewTreeParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return ViewTreeLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return ViewTreeTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return ViewTreeParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ViewTreeFile(viewProvider)
    }

    override fun createElement(node: ASTNode): PsiElement {
        return ViewTreeTypes.Factory.createElement(node)
    }

    companion object {
        val FILE = IFileElementType(ViewTreeLanguage.INSTANCE)
    }
}