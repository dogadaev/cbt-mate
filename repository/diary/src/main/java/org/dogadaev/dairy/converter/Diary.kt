package org.dogadaev.dairy.converter

import org.dogadaev.database.entity.DiaryDB
import org.dogadaev.entity.Diary

fun DiaryDB.toCommon() = Diary(
    id,
    title,
    description,
    creationDate,
//    entries.map { entry ->
//        Dairy.Entry(
//            entry.timestamp,
//            entry.content
//        )
//    }
)

fun Diary.toDB() = DiaryDB(
    id,
    title,
    description,
    creationDate,
//    entries.map { entry ->
//        DairyDB.Entry(
//            entry.timestamp,
//            entry.content
//        )
//    }
)