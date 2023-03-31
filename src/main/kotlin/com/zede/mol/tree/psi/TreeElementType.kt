package com.zede.mol.tree.psi

import com.intellij.psi.tree.IElementType
import com.zede.mol.tree.TreeLanguage
import org.jetbrains.annotations.NonNls

class TreeElementType(debugName: @NonNls String): IElementType(debugName, TreeLanguage.INSTANCE) {
}
