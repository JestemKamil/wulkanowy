package io.github.wulkanowy

import io.github.wulkanowy.utils.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TestDispatchersProvider : DispatchersProvider() {

    override val backgroundThread: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}
