package com.solinftec.baseproject.localize

data class LocalizeStringCountry(
    val countryIsoCode: String,
    val localizeStrings: HashMap<String, String>
)