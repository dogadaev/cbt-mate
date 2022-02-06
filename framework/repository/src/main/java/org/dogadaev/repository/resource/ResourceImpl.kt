package org.dogadaev.repository.resource

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import org.dogadaev.interactor.resource.Resource

class ResourceImpl<T>(
    produceFlow: () -> Flow<T>
): Resource<T> {

    override val data = produceFlow()
        .onCompletion { scope.cancel() }

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())
}
