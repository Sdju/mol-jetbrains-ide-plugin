// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.zede.mol.tree

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet
import com.zede.mol.tree.psi.TreeTypes

interface TreeTokenSets {
    companion object {
        val IDENTIFIERS = TokenSet.create(TreeTypes.NAME)
        val COMMENTS = TokenSet.create(TokenType.DUMMY_HOLDER)
    }
}