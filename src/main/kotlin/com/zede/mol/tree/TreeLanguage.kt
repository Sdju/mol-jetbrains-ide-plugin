package com.zede.mol.tree

import com.intellij.lang.Language

class TreeLanguage: Language("Tree") {
    companion object {
        val INSTANCE: TreeLanguage = TreeLanguage()
    }
}
