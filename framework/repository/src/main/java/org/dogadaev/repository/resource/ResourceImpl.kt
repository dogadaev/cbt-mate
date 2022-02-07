package org.dogadaev.repository.resource

import kotlinx.coroutines.flow.Flow
import org.dogadaev.interactor.resource.Resource

class ResourceImpl<T>(
    fetch: () -> Flow<T>
) : Resource<T> {

    override val data by lazy { fetch() }
}
