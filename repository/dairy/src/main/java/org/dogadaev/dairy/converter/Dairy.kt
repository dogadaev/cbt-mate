package org.dogadaev.dairy.converter

import org.dogadaev.database.entity.DairyDB
import org.dogadaev.entity.Dairy

fun DairyDB.toCommon() = Dairy(
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

fun Dairy.toDB() = DairyDB(
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