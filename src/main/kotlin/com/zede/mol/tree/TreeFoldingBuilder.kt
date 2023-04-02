package com.zede.mol.tree

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import com.zede.mol.tree.psi.impl.TreeItemContentImpl
import com.zede.mol.tree.psi.impl.TreeItemImpl
import java.util.Stack

class TreeFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val descriptors: MutableList<FoldingDescriptor> = ArrayList()

        val stack = Stack<TreeItemContentImpl>()
        root.children.forEach { child ->
            if (child is TreeItemImpl && child.lastChild is TreeItemContentImpl) {
                stack.push(child.lastChild as TreeItemContentImpl)
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
                if (child is TreeItemImpl && child.lastChild is TreeItemContentImpl) {
                    stack.push(child.lastChild as TreeItemContentImpl)
                }
            }
        }

        return descriptors.toTypedArray<FoldingDescriptor>()
    }

    override fun getPlaceholderText(node: ASTNode): String? {
        return "..."
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}