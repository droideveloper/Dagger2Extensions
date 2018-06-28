/*
 * Dagger2 Extensions Android Kotlin Copyright (C) 2018 Fatih.
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
package org.fs.dagger.extensions

import android.app.Application
import android.support.v7.preference.Preference
import android.support.v7.widget.RecyclerView
import android.view.View
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.Multibinds
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class Dagger2ExtensionsModule {

  @Multibinds abstract fun viewHolderInjectorFactories(): Map<KClass<RecyclerView.ViewHolder>, AndroidInjector.Factory<RecyclerView.ViewHolder>>
  @Multibinds abstract fun preferenceInjectorFactories(): Map<KClass<Preference>, AndroidInjector.Factory<Preference>>
  @Multibinds abstract fun viewInjectorFactories(): Map<KClass<View>, AndroidInjector.Factory<View>>

  @Binds @Singleton abstract fun application(playzApp: Dagger2ExtensionsApplication): Application
}