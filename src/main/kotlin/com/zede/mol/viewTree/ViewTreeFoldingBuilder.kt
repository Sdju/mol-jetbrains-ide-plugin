package com.zede.mol.viewTree

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import com.zede.mol.viewTree.psi.ViewTreeTypes
import com.zede.mol.viewTree.psi.impl.ViewTreeArrayItemsValueImpl
import com.zede.mol.viewTree.psi.impl.ViewTreeComponentAttributesImpl
import com.zede.mol.viewTree.psi.impl.ViewTreeMultilineStringValueImpl
import com.zede.mol.viewTree.psi.impl.ViewTreeObjectKeysValueImpl

class ViewTreeFoldingBuilder : FoldingBuilderEx(), DumbAware {
    fun isFoldable(element: PsiElement): Boolean {
        return (element is ViewTreeArrayItemsValueImpl) ||
                (element is ViewTreeComponentAttributesImpl) ||
                (element is ViewTreeObjectKeysValueImpl) ||
                (element is ViewTreeMultilineStringValueImpl)
    }

    fun applyDescriptors(element: PsiElement, descriptors: MutableList<FoldingDescriptor>) {
        for (child in element.children) {
            if (isFoldable(child)) {
                descriptors.add(
                    FoldingDescriptor(
                        child.node,
                        TextRange(child.startOffset - 1, child.endOffset - 1)
                    )
                )
            }
            if (!child.children.isEmpty()) {
                applyDescriptors(child, descriptors)
            }
        }
    }

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean) =
        mutableListOf<FoldingDescriptor>().apply {
            applyDescriptors(root, this)
        }.toTypedArray()

    override fun getPlaceholderText(node: ASTNode): String {
        if (node.elementType == ViewTreeTypes.MULTILINE_STRING_VALUE) {
            val text = node.text
            return text
        }
        return "..."
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}