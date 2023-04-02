package com.zede.mol.tree

import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.FileIndentOptionsProvider
import com.zede.mol.ViewTreeFileType

class TreeFileTypeIndentOptionsProvider : FileIndentOptionsProvider() {
    override fun getIndentOptions(settings: CodeStyleSettings, file: PsiFile): CommonCodeStyleSettings.IndentOptions {
        if (file is TreeFile) {
            val ident = settings.getIndentOptions()
            ident.TAB_SIZE = 4
            ident.USE_TAB_CHARACTER = true
            ident.KEEP_INDENTS_ON_EMPTY_LINES = true
            return ident
        }
        return settings.getIndentOptionsByFile(file)
    }
}