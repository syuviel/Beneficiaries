package com.example.beneficiaries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class BeneficiariesDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val linearLayout = LinearLayout(context)
        val beneficiariesItem: BeneficiariesItem = BeneficiariesItem()
        linearLayout.orientation = VERTICAL
        linearLayout.layoutParams = ViewGroup.LayoutParams(
            LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
        )

        val titleTextView = TextView(context)
        val socialTextview = TextView(context)
        val dateOfBirthTextView = TextView(context)
        val phoneNumberTextView = TextView(context)
        val addressTextView = TextView(context)

        val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        titleTextView.layoutParams = layoutParams
        titleTextView.setPadding(5,5,5,5)
        titleTextView.text = beneficiariesItem.firstName.plus(" ${beneficiariesItem.lastName}:")
        socialTextview.layoutParams = layoutParams
        socialTextview.setPadding(5,5,5,5)
        socialTextview.text = beneficiariesItem.socialSecurityNumber
        dateOfBirthTextView.layoutParams = layoutParams
        dateOfBirthTextView.setPadding(5,5,5,5)
        dateOfBirthTextView.text = String.format(
            "%s/%s/%s",
            beneficiariesItem.dateOfBirth.substring(0,2),
            beneficiariesItem.dateOfBirth.substring(2,4),
            beneficiariesItem.dateOfBirth.substring(4,8,)
        )
        phoneNumberTextView.layoutParams = layoutParams
        phoneNumberTextView.setPadding(5,5,5,5)

        linearLayout.addView()

        return linearLayout
    }
}