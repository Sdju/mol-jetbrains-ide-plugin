package com.zede.mol.tree

import com.intellij.psi.codeStyle.*
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.IndentOptions


class TreeLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider () {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings? {
        return TreeCodeStyleSettings(settings)
    }

    override fun getConfigurableDisplayName(): String? {
        return "\$mol Tree"
    }

    override fun getLanguage(): TreeLanguage {
        return TreeLanguage.INSTANCE
    }

    override fun getCodeSample(settingsType: SettingsType): String? {
        return """
zede_playground mol_page
	title \ Zede tests
	tools /
		<= Lighter mol_lights_toggle
	plugins /
		<= Theme mol_theme_auto
	body /
		<= Themes mol_view
			sub /
				<= Color1 zede_playground_color
					color \ var(--mol_theme_back)
				<= Color2 zede_playground_color
					color \ var(--mol_theme_text)
				<= Color3 zede_playground_color
					color \ var(--mol_theme_field)
				<= Color4 zede_playground_color
					color \ var(--mol_theme_card)
				<= Color5 zede_playground_color
					color \ var(--mol_theme_hover)
				<= Color6 zede_playground_color
					color \ var(--mol_theme_line)
				<= Color7 zede_playground_color
					color \ var(--mol_theme_shade)
				<= Color8 zede_playground_color
					color \ var(--mol_theme_control)
				<= Color9 zede_playground_color
					color \ var(--mol_theme_current)
				<= Color10 zede_playground_color
					color \ var(--mol_theme_special)
				<= Color11 zede_playground_color
					color \ var(--mol_theme_focus)
					
		<= Panel2 zede_playground_panel
"""
    }
}
