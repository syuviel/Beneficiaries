package com.example.beneficiaries.view

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.example.beneficiaries.Adapter.BeneficiariesAdapter
import com.example.beneficiaries.Model.BeneficiariesItem
import com.example.beneficiaries.Utils.ReadJSONFromBeneficiaries
import com.google.gson.Gson

private const val ID = 101010

class MainActivity :
    AppCompatActivity(),
    BeneficiariesAdapter.OnItemClick
{

    lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linearLayout = LinearLayout(this)
        val beneficiariesRecycler = RecyclerView(this)
        val linearLayoutManager = LinearLayoutManager(this)
        val beneficiaryList = mutableListOf<BeneficiariesItem>()
        val jsonString = (ReadJSONFromBeneficiaries(this, "Beneficiaries.json"))
        val beneficiaryData = Gson().fromJson(jsonString, Array<BeneficiariesItem>::class.java)

        beneficiaryList.addAll(beneficiaryData)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = ViewGroup.LayoutParams(
            LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
        )
        this.linearLayout = linearLayout
        setContentView(linearLayout)
        beneficiariesRecycler.layoutParams = ViewGroup.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT
        )
        beneficiariesRecycler.layoutManager = linearLayoutManager
        val adapter = BeneficiariesAdapter(beneficiaryList)
        adapter.setClickListener(this)
        beneficiariesRecycler.adapter = adapter
        linearLayout.addView(beneficiariesRecycler)
    }

    override fun onItemClick(position: Int, beneficiary: BeneficiariesItem) {
        val linearLayout = LinearLayout(this.baseContext)
        val beneficiariesItem: BeneficiariesItem =
            beneficiary
        linearLayout.orientation = VERTICAL
        linearLayout.layoutParams = ViewGroup.LayoutParams(
            LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
        )

        val backButton = Button(this.baseContext)
        val titleTextView = TextView(this.baseContext)
        val socialTextview = TextView(this.baseContext)
        val dateOfBirthTextView = TextView(this.baseContext)
        val phoneNumberTextView = TextView(this.baseContext)
        val addressTextView = TextView(this.baseContext)
        val addressFirstLine = TextView(this.baseContext)
        val addressSecondLine = TextView(this.baseContext)
        val addressCity = TextView(this.baseContext)
        val addressState = TextView(this.baseContext)
        val addressZip = TextView(this.baseContext)
        val addressCountry = TextView(this.baseContext)
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
        phoneNumberTextView.text = beneficiariesItem.phoneNumber
        addressTextView.layoutParams = layoutParams
        addressTextView.setPadding(5,5,5,5)
        addressTextView.text = "Address: "
        beneficiariesItem.beneficiaryAddress?.let { address ->
            addressFirstLine.layoutParams = layoutParams
            addressFirstLine.setPadding(5,5,5,5)
            addressFirstLine.text = address.firstLineMailing
            addressSecondLine.layoutParams = layoutParams
            addressSecondLine.setPadding(5,5,5,5)
            addressSecondLine.text = address.scndLineMailing ?: ""
            addressCity.layoutParams = layoutParams
            addressCity.setPadding(5,5,5,5)
            addressCity.text = address.city
            addressState.layoutParams = layoutParams
            addressState.setPadding(5,5,5,5)
            addressState.text = address.stateCode
            addressZip.layoutParams = layoutParams
            addressZip.setPadding(5,5,5,5)
            addressZip.text = address.zipCode
            addressCountry.layoutParams = layoutParams
            addressCountry.setPadding(5,5,5,5)
            addressCountry.text = address.country
        }

        backButton.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        backButton.text = "Press Back to Return to Previous Screen"
        backButton.setPadding(5,5,5,5)
        backButton.setOnClickListener {
            setContentView(this.linearLayout)
        }

        linearLayout.addView(titleTextView)
        linearLayout.addView(socialTextview)
        linearLayout.addView(dateOfBirthTextView)
        linearLayout.addView(phoneNumberTextView)
        linearLayout.addView(addressTextView)
        linearLayout.addView(addressFirstLine)
        linearLayout.addView(addressSecondLine)
        linearLayout.addView(addressCity)
        linearLayout.addView(addressState)
        linearLayout.addView(addressZip)
        linearLayout.addView(addressCountry)
        linearLayout.addView(backButton)
        linearLayout.id = ID

        setContentView(linearLayout)
    }
}