# ShiftModifier

![Build](https://github.com/mitohato14/ShiftModifier/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/24350-shiftmodifier.svg)](https://plugins.jetbrains.com/plugin/24350-shiftmodifier)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/24350-shiftmodifier.svg)](https://plugins.jetbrains.com/plugin/24350-shiftmodifier)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [X] Get familiar with the [template documentation][template].
- [x] Adjust the [pluginGroup](./gradle.properties), [plugin ID](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [x] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [x] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [x] Set the `PLUGIN_ID` in the above README badges.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This plugin is useful when developing using Compose and the implemented Modifiers do not behave as expected and you want to change the order of Modifiers.
Select multiple Modifier rows and press the keyboard shortcut (Alt + K) or execute the Action from the pop-up menu to shift them up one by one.
Even if the selected Modifiers have a comma at the end, the comma will be kept at the end.
<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "ShiftModifier"</kbd> >
  <kbd>Install</kbd>
  
- Manually:

  Download the [latest release](https://github.com/mitohato14/ShiftModifier/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
