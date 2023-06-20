package com.lukninja.moneyman.localize

data class LocalizeStringCountry(
    val countryIsoCode: String,
    val localizeStrings: HashMap<String, String>
)