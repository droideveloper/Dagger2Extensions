/*
 * Dagger2 Extensions Copyright (C) 2018 Fatih.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fs.dagger.extensions.util

import android.app.Application
import android.support.v7.preference.Preference
import android.support.v7.widget.RecyclerView
import android.view.View
import org.fs.dagger.extensions.common.HasPreferenceInjector
import org.fs.dagger.extensions.common.HasRecyclerViewHolderInjector
import org.fs.dagger.extensions.common.HasViewInjector

// we call this method in View#init
fun View?.inject() {
  this?.apply {
    val app = context.applicationContext
    if (app is Application) {
      if (app is HasViewInjector) {
        val injector = app.viewInjector()
        injector.inject(this)
      }
    }
  }
}

// we call this method in RecyclerView.ViewHolder#init
fun RecyclerView.ViewHolder?.inject() {
  this?.apply {
    checkNotNull(itemView, "ViewHolder instance should bound by view, please check for it")
    val app = itemView.context.applicationContext
    if (app is Application) {
      if (app is HasRecyclerViewHolderInjector) {
        val injector = app.recyclerViewHolderInjector()
        injector.inject(this)
      }
    }
  }
}

// we call this method in Preference#init
fun Preference?.inject() {
  this?.apply {
    val app = context.applicationContext
    if (app is Application) {
      if (app is HasPreferenceInjector) {
        val injector = app.preferenceInjector()
        injector.inject(this)
      }
    }
  }
}

private fun <T> checkNotNull(value: T, errorString: String = "Error on checking object nullity") {
  if (value == null) {
    throw IllegalArgumentException(errorString)
  }
}
