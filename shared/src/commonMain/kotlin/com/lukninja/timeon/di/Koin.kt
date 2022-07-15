package com.lukninja.timeon.di

import com.lukninja.timeon.db.DriverFactory
import com.lukninja.timeon.localize.LocaleResource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

//iOS
fun initKoin(countryCode: String? = null, regionCode: String? = null) = initKoin(countryCode, regionCode) {}

fun initKoin(countryCode: String? = null, regionCode: String? = null, appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        commonModule,
        module {
            //locale
            single {
                LocaleResource(
                    countryCode = countryCode,
                    regionCode = regionCode
                )
            }
        }
    )
}

val commonModule = module {
    //db
    single { DriverFactory().createDatabase() }
}

inline fun <reified T> getKoinInstance(): T {
    return object : KoinComponent {
        val value: T by inject()
    }.value
}