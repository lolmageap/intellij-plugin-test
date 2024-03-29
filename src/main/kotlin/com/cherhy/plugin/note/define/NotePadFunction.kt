package com.cherhy.plugin.note.define

import com.cherhy.plugin.function.rootPackage
import com.cherhy.plugin.note.ui.Notepad
import java.io.File
import javax.swing.JFileChooser

fun Notepad.new() {
    textArea.isVisible = true
    this.isVisible = true
    createDefaultFile()
}

fun Notepad.open() {
    val defaultDirectory = rootPackage(project)

    JFileChooser().apply {
        currentDirectory = defaultDirectory

        val dialog = showOpenDialog(contentPane)
        if (dialog == JFileChooser.APPROVE_OPTION) {
            currentFile = selectedFile
            textArea.isVisible = true
            this.isVisible = true
            textArea.text = currentFile?.readText()
        }
    }
}

fun Notepad.createDefaultFile() {
    val defaultDirectory = rootPackage(project)
    val fileToSave = File(defaultDirectory, currentFileName)
    fileToSave.writeText(textArea.text)
}

fun Notepad.saveTextToFile() {
    currentFile?.writeText(textArea.text)
}

fun Notepad.saveAndClose() {
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