package com.lukninja.timeon.localize

data class LocalizeStringCountry(
    val countryIsoCode: String,
    val localizeStrings: HashMap<String, String>
)