package org.dogadaev.creationform

import org.dogadaev.creationform.fragment.DiaryCreationFormFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val diaryCreationFormModule = module {
    fragment { DiaryCreationFormFragment(get()) }
}