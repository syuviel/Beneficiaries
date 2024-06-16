package com.example.beneficiaries.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeneficiariesItem(
   val lastName: String = "",
   val firstName: String = "",
   val designationCode: String = "",
   val beneType: String = "",
   val socialSecurityNumber: String = "",
   val dateOfBirth: String = "",
   val middleName: String = "",
   val phoneNumber: String = "",
   val beneficiaryAddress: BeneficiaryAddress? = null
): Parcelable

