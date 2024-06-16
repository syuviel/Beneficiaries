package com.example.beneficiaries

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
)
