package org.dogadaev.interactor.resource

import kotlinx.coroutines.flow.Flow

// TODO: Also implement MutableResource

interface Resource<T> {
    val data: Flow<T>
}