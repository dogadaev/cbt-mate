package org.dogadaev.presentation.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import org.dogadaev.entity.ViewModelPayload
import org.dogadaev.presentation.viewmodel.factory.AssistedViewModelFactory
import org.dogadaev.presentation.viewmodel.factory.ViewModelFactory

inline fun <reified VM : ViewModel> Fragment.viewModel(
    factory: AssistedViewModelFactory,
    crossinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = { ViewModelFactory(factory) },
    noinline extrasProducer: () -> CreationExtras = { CreationExtras.Empty }
) = ViewModelLazy(
    viewModelClass = VM::class,
    storeProducer = { ownerProducer().viewModelStore },
    factoryProducer = factoryProducer ?: { defaultViewModelProviderFactory },
    extrasProducer = extrasProducer
)