package org.dogadaev.dairy.converter

import org.dogadaev.database.entity.DairyDB
import org.dogadaev.entity.Diary

fun DairyDB.toCommon() = Diary(
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

fun Diary.toDB() = DairyDB(
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