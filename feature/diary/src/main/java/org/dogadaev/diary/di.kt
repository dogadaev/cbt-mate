package org.dogadaev.diary

import org.dogadaev.diary.fragment.DiaryFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val diaryModule = module {
    fragment { DiaryFragment(get()) }
}