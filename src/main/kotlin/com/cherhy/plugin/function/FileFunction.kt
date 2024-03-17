package com.cherhy.plugin.function

import com.cherhy.plugin.note.constant.NoteConstant.IDEA
import com.cherhy.plugin.note.constant.NoteConstant.NOTEPAD_PACKAGE
import com.intellij.openapi.project.Project
import java.io.File
import java.nio.file.Paths

fun rootPackage(project: Project): File = Paths.get(project.basePath, IDEA, NOTEPAD_PACKAGE).toFile()