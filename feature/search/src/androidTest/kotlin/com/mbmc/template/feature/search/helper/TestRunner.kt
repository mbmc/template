package com.mbmc.template.feature.search.helper

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.mbmc.template.feature.search.TestApplication

class TestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application =
        super.newApplication(cl, TestApplication::class.qualifiedName, context)
}