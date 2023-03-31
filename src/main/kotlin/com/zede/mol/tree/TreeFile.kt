// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.tree

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.zede.mol.ViewTreeFileType
import com.zede.mol.tree.TreeLanguage

class TreeFile(viewProvider: FileViewProvider) :
    PsiFileBase(viewProvider, TreeLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return ViewTreeFileType.INSTANCE
    }

    override fun toString(): String {
        return "\$mol tree file type"
    }
}