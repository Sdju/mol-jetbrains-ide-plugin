// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import com.zede.mol.tree.TreeLanguage
import javax.swing.Icon

class ViewTreeFileType private constructor() : LanguageFileType(TreeLanguage.INSTANCE) {
    override fun getName(): String {
        return "\$mol View Tree"
    }

    override fun getDescription(): String {
        return "\$mol tree syntax for views"
    }

    override fun getDefaultExtension(): String {
        return "tree"
    }

    override fun getIcon(): Icon {
        return AllIcons.Actions.ShowAsTree
    }

    companion object {
        val INSTANCE = ViewTreeFileType()
    }
}
