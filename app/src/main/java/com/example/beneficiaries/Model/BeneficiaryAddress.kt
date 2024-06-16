package com.example.beneficiaries.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeneficiaryAddress(
    val firstLineMailing: String = "",
    val scndLineMailing: String? = null,
    val city: String = "",
    val zipCode: String = "",
    val stateCode: String = "",
    val country: String = ""
): Parcelable
