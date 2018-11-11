package keijumt.presentation.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class CoroutinePresenter(
        private val context: CoroutineContext
) : CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = context + job

    open fun onDestory() {
        job.cancel()
    }
}