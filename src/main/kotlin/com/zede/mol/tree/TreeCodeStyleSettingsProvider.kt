package com.zede.mol.tree

import com.intellij.psi.codeStyle.*
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.IndentOptions


class TreeCodeStyleSettingsProvider : CodeStyleSettingsProvider () {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings? {
        return TreeCodeStyleSettings(settings)
    }

    override fun getConfigurableDisplayName(): String? {
        return "\$mol Tree"
    }

    override fun getLanguage(): TreeLanguage {
        return TreeLanguage.INSTANCE
    }
}
