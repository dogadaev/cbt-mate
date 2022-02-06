package org.dogadaev.interactor.resource

import kotlinx.coroutines.flow.Flow

interface ParametrizedResource<T, P> {
    fun parametrizedFlow(parameter: P) : Flow<T>
}