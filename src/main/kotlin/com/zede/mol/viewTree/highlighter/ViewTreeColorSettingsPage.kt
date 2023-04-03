// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zede.mol.viewTree.highlighter

import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class ViewTreeColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return AllIcons.Actions.ShowAsTree
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return ViewTreeSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        val WTF = '$'
        return """html
${WTF}mol_3d_pane ${WTF}mol_view
	dom_name \canvas
	context ${WTF}mol_3d_context / <= context_native WebGL2RenderingContext
	field *
		^
		width <= width 0
		height <= height 0
	paint null
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
        return "ViewTree (\$mol)"
    }

    companion object {
        private val DESCRIPTORS = arrayOf<AttributesDescriptor>(
            AttributesDescriptor("Name", ViewTreeSyntaxHighlighter.NAME),
            AttributesDescriptor("Value", ViewTreeSyntaxHighlighter.VALUE),
            AttributesDescriptor("Operator", ViewTreeSyntaxHighlighter.VALUE_PREFIX),
            AttributesDescriptor("Bad value", ViewTreeSyntaxHighlighter.BAD_CHARACTER)
        )
    }
}