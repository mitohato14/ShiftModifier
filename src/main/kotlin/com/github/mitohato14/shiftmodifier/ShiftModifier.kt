package com.github.mitohato14.shiftmodifier

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class ShiftModifier : AnAction() {
  override fun getActionUpdateThread(): ActionUpdateThread {
    return ActionUpdateThread.BGT
  }

  override fun actionPerformed(actionEvent: AnActionEvent) {
    val editor = actionEvent.getRequiredData(CommonDataKeys.EDITOR)
    val caretModel = editor.caretModel

    val document = editor.document

    val primaryCaret = caretModel.primaryCaret
    val startOffset = primaryCaret.selectionStart
    val endOffset = primaryCaret.selectionEnd
    val selectedText = primaryCaret.selectedText ?: throw IllegalArgumentException()

    val shiftedText: String = shiftModifier(selectedText)

    WriteCommandAction.runWriteCommandAction(actionEvent.project) {
      document.replaceString(startOffset, endOffset, shiftedText)
    }
  }

  override fun update(actionEvent: AnActionEvent) {
    val editor = actionEvent.getRequiredData(CommonDataKeys.EDITOR)
    val caretModel = editor.caretModel
    actionEvent.presentation.isEnabledAndVisible = caretModel.currentCaret.hasSelection()
  }

  private fun shiftModifier(selectedText: String) : String {
    val indent =  selectedText.substring(0, selectedText.indexOfFirst { !it.isWhitespace() })
    val textList = selectedText
      .trimIndent()
      .split(Regex("""(?m)^[\s\n]*\."""))
      .filter { it.isNotBlank() }
      .map{ "$indent.${it.replace("\n", "")}"}

    if (textList.size == 1) return selectedText
    val hasComma = textList.last().last() == ','

    val shiftedTextList = textList.let { list ->
      list.subList(1, list.size - 1) + if (list.last().endsWith(",")) {
        list.last().substring(0, list.last().length - 1)
      } else {
        list.last()
      } + list.first()
    }

    return shiftedTextList.joinToString("\n") + if (hasComma) {
      ","
    } else {
      ""
    } + "\n"
  }
}