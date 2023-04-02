package org.intellij.sdk.language

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldRegion
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
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
            descriptors.add(FoldingDescriptor(content.getNode(),
                TextRange(content.startOffset - 1, content.endOffset - 1)))
            content.children.forEach { child ->
                if (child is TreeItemImpl && child.lastChild is TreeItemContentImpl) {
                    stack.push(child.lastChild as TreeItemContentImpl)
                }
            }
        }

        return descriptors.toTypedArray<FoldingDescriptor>()
    }

//    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
//        val descriptors: MutableList<FoldingDescriptor> = ArrayList()
//
//        for (child in root.children) {
//            if ((child is TreeItemImpl) && (child.lastChild is TreeItemContentImpl)) {
//                val content = child.lastChild
//                descriptors.add(
//                    FoldingDescriptor(
//                        content.getNode(),
//                        TextRange(
//                            content.startOffset,
//                            content.endOffset
//                        )
//                    )
//                )
//            }
//        }
//        return descriptors.toTypedArray<FoldingDescriptor>()
//    }

    /**
     * Gets the Simple Language 'value' string corresponding to the 'key'
     *
     * @param node Node corresponding to PsiLiteralExpression containing a string in the format
     * SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR + Key, where Key is
     * defined by the Simple language file.
     */
    override fun getPlaceholderText(node: ASTNode): String? {
        return "..."
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}