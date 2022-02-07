package org.dogadaev.repository.resource

import kotlinx.coroutines.flow.*
import org.dogadaev.interactor.resource.ParametrizedResource

class ParametrizedResourceImpl<T, P>(
    private val fetch: (P) -> Flow<T>,
) : ParametrizedResource<T, P> {

    override fun parametrizedFlow(parameter: P) = fetch(parameter)
}