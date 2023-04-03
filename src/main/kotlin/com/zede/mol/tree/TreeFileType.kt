// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.tree

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import com.zede.mol.tree.TreeLanguage
import javax.swing.Icon

class TreeFileType private constructor() : LanguageFileType(TreeLanguage.INSTANCE) {
    override fun getName(): String {
        return "Tree (\$mol)"
    }

    override fun getDescription(): String {
        return "\$mol tree syntax"
    }

    override fun getDefaultExtension(): String {
        return "tree"
    }

    override fun getIcon(): Icon {
        return AllIcons.Actions.ShowAsTree
    }

    companion object {
        val INSTANCE = TreeFileType()
    }
}
