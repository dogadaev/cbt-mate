package org.dogadaev.repository.converter

import org.dogadaev.database.entity.DiaryDB
import org.dogadaev.database.entity.DiaryWithEntries
import org.dogadaev.entity.Diary

fun DiaryWithEntries.toUIModel() = Diary(
    diary.id,
    diary.title,
    diary.description,
    diary.creationDate,
    diaryEntries.map { it.toCommon() }
)

fun DiaryDB.Entry.toCommon() = Diary.Entry(
    diaryId,
    timestamp,
    situationDescription,
    automaticThought.toCommon(),
    emotions.map { it.toCommon() },
    behaviourDescription
)

fun DiaryDB.AutomaticThought.toCommon() = Diary.AutomaticThought(
    thought,
    analysis,
)

fun Diary.AutomaticThought.toDB() = DiaryDB.AutomaticThought(
    thought,
    analysis,
)

fun DiaryDB.Emotion.toCommon() = Diary.Emotion(
    Diary.Emotion.StandardEmotion.values()[emotion.ordinal],
    intensity
)

fun Diary.Emotion.toDB() = DiaryDB.Emotion(
    DiaryDB.Emotion.StandardEmotion.values()[emotion.ordinal],
    intensity
)

fun Diary.toDB() = DiaryDB(
    id,
    title,
    description,
    creationDate,
)

fun Diary.Entry.toDB() = DiaryDB.Entry(
    0,
    diaryId,
    timestamp,
    situationDescription,
    automaticThought.toDB(),
    emotions.map { it.toDB() },
    behaviourDescription
)