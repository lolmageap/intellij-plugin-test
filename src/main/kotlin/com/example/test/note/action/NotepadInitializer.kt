package com.example.test.note.action

import com.example.test.note.constant.NoteConstant.IDEA
import com.example.test.note.constant.NoteConstant.NOTEPAD_PACKAGE
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import java.nio.file.Paths
import java.nio.file.Files

class NotepadInitializer : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        createNotepadPackage(project)
    }

    private fun createNotepadPackage(project: Project) {
        val ideaDir = Paths.get(project.basePath, IDEA, NOTEPAD_PACKAGE)
        if (!Files.exists(ideaDir)) {
            Files.createDirectories(ideaDir)
        }
    }
}
