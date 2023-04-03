package com.zede.mol.viewTree

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.*


class ViewTreeCodeStyleSettingsProvider : CodeStyleSettingsProvider () {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings {
        val treeSettings = ViewTreeCodeStyleSettings(settings)
        val indentOptions = treeSettings.container.indentOptions
        indentOptions.USE_TAB_CHARACTER = true
        indentOptions.TAB_SIZE = 6
        indentOptions.KEEP_INDENTS_ON_EMPTY_LINES = true
        return treeSettings
    }

    override fun getConfigurableDisplayName(): String {
        return "ViewTree (\$mol)"
    }

    override fun createConfigurable(
        settings: CodeStyleSettings,
        modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object : CodeStyleAbstractConfigurable(settings, modelSettings, this.configurableDisplayName) {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
                return SimpleCodeStyleMainPanel(currentSettings, settings)
            }
        }
    }


    private class SimpleCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings?) :
        TabbedLanguageCodeStylePanel(ViewTreeLanguage.INSTANCE, currentSettings, settings!!)

}
