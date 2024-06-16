package com.example.beneficiaries

data class BeneficiaryAddress(
    val firstLineMailing: String = "",
    val scndLineMailing: String? = null,
    val city: String = "",
    val zipCode: String = "",
    val stateCode: String = "",
    val country: String = ""
)
