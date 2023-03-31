// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.tree.psi

import com.intellij.psi.tree.IElementType
import com.zede.mol.tree.TreeLanguage
import org.jetbrains.annotations.NonNls

class TreeTokenType(debugName: @NonNls String) :
    IElementType(debugName, TreeLanguage.INSTANCE) {
    override fun toString(): String {
        return "TreeTokenType." + super.toString()
    }
}