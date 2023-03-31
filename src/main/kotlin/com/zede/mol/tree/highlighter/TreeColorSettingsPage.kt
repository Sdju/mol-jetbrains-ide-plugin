// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.tree.highlighter

import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class TreeColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return AllIcons.Actions.ShowAsTree
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return TreeSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """html
@ xml:lang \ru
head
    title \Рога & Копыта
body
    h1 \Привет!
    p  \Хочешь, я расскажу тебе сказку?
"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "\$mol tree"
    }

    companion object {
        private val DESCRIPTORS = arrayOf<AttributesDescriptor>(
            AttributesDescriptor("Name", TreeSyntaxHighlighter.NAME),
            AttributesDescriptor("Value", TreeSyntaxHighlighter.VALUE),
            AttributesDescriptor("Value prefix", TreeSyntaxHighlighter.VALUE_PREFIX),
            AttributesDescriptor("Bad value", TreeSyntaxHighlighter.BAD_CHARACTER)
        )
    }
}