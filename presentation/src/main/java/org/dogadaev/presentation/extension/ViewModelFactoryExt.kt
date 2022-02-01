package org.dogadaev.presentation.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import org.dogadaev.entity.ViewModelPayload
import org.dogadaev.presentation.viewmodel.factory.AssistedViewModelFactory
import org.dogadaev.presentation.viewmodel.factory.ViewModelFactory

inline fun <reified VM : ViewModel> Fragment.assistedViewModels(
    factory: AssistedViewModelFactory,
    crossinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = {
        ViewModelFactory(
            factory,
            payloadProducer()
        )
    },
    crossinline payloadProducer: () -> ViewModelPayload,
) = ViewModelLazy(
    VM::class,
    { ownerProducer().viewModelStore },
    factoryProducer ?: { defaultViewModelProviderFactory }
)