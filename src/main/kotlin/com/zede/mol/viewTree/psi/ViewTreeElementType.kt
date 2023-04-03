package com.zede.mol.viewTree.psi

import com.intellij.psi.tree.IElementType
import com.zede.mol.viewTree.ViewTreeLanguage
import org.jetbrains.annotations.NonNls

class ViewTreeElementType(debugName: @NonNls String): IElementType(debugName, ViewTreeLanguage.INSTANCE) {
}
