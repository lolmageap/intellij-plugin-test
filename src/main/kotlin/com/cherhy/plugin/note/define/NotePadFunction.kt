package com.cherhy.plugin.note.define

import com.cherhy.plugin.function.rootPackage
import com.cherhy.plugin.note.ui.Notepad
import javax.swing.JFileChooser

fun Notepad.new() {
    textArea.isVisible = true
}

fun Notepad.open() {
    val defaultDirectory = rootPackage(project)

    JFileChooser().apply {
        currentDirectory = defaultDirectory

        val dialog = showOpenDialog(contentPane)
        if (dialog == JFileChooser.APPROVE_OPTION) {
            textArea.isVisible = true
            textArea.text = selectedFile.readText()
        }
    }
}

fun Notepad.saveTextToFile() {
    val defaultDirectory = rootPackage(project)

    JFileChooser().apply {
        currentDirectory = defaultDirectory

        val dialog = showOpenDialog(contentPane)
        if (dialog == JFileChooser.APPROVE_OPTION) {
            selectedFile.writeText(textArea.text)
        }
    }

    dispose()
}