package com.benli.common.base

import com.benli.cmm.ex.LOG_D
import com.benli.cmm.viewmodel.ViewModel

/**
 * Created by shibenli on 2017/8/2.
 */

open class BaseViewModel() : ViewModel {
    override fun destroy() {
        LOG_D(this)
    }
}
