// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.viewTree

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import com.zede.mol.viewTree.ViewTreeLanguage
import javax.swing.Icon

class ViewTreeFileType private constructor() : LanguageFileType(ViewTreeLanguage.INSTANCE) {
    override fun getName(): String {
        return "ViewTree \$mol"
    }

    override fun getDescription(): String {
        return "\$mol tree syntax for views"
    }

    override fun getDefaultExtension(): String {
        return "view.tree"
    }

    override fun getIcon(): Icon {
        return AllIcons.Actions.ShowAsTree
    }

    companion object {
        val INSTANCE = ViewTreeFileType()
    }
}
