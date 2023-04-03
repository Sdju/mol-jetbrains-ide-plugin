// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.zede.mol.viewTree

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet
import com.zede.mol.viewTree.psi.ViewTreeTypes

interface ViewTreeTokenSets {
    companion object {
        val IDENTIFIERS = TokenSet.create(ViewTreeTypes.NAME)
        val COMMENTS = TokenSet.create(TokenType.DUMMY_HOLDER)
    }
}