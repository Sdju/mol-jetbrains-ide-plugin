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
import com.zede.mol.viewTree.psi.impl.ViewTreeItemContentImpl
import com.zede.mol.viewTree.psi.impl.ViewTreeItemImpl
import java.util.Stack

class ViewTreeFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val descriptors: MutableList<FoldingDescriptor> = ArrayList()

        val stack = Stack<ViewTreeItemContentImpl>()
        root.children.forEach { child ->
            if (child is ViewTreeItemImpl && child.lastChild is ViewTreeItemContentImpl) {
                stack.push(child.lastChild as ViewTreeItemContentImpl)
            }
        }

        while (!stack.empty()) {
            val content = stack.pop()
            descriptors.add(
                FoldingDescriptor(
                    content.node,
                    TextRange(content.startOffset - 1, content.endOffset - 1)
                )
            )
            content.children.forEach { child ->
                if (child is ViewTreeItemImpl && child.lastChild is ViewTreeItemContentImpl) {
                    stack.push(child.lastChild as ViewTreeItemContentImpl)
                }
            }
        }

        return descriptors.toTypedArray<FoldingDescriptor>()
    }

    override fun getPlaceholderText(node: ASTNode): String? {
        return " ... "
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}