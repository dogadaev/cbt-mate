package org.dogadaev.repository.resource

import kotlinx.coroutines.flow.Flow
import org.dogadaev.interactor.resource.ParametrizedResource

class ParametrizedResourceImpl<T, P>(
    private val produceFlow: (P) -> Flow<T>
): ParametrizedResource<T, P> {

    override fun parametrizedFlow(parameter: P) = produceFlow(parameter)
}