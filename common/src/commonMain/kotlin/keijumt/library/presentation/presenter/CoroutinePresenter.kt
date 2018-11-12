package keijumt.library.presentation.presenter

import keijumt.library.applicationDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class CoroutinePresenter : CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = applicationDispatcher + job

    open fun onDestory() {
        job.cancel()
    }
}