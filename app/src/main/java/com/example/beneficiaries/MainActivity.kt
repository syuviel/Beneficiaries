package com.example.beneficiaries

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiaries.Utils.ReadJSONFromBeneficiaries
import com.google.gson.Gson

class MainActivity :
    AppCompatActivity(),
        BeneficiariesAdapter.OnItemClick
{



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
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        )
        setContentView(linearLayout)
        beneficiariesRecycler.layoutParams = ViewGroup.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT
        )
        beneficiariesRecycler.layoutManager = linearLayoutManager
        beneficiariesRecycler.adapter = BeneficiariesAdapter(beneficiaryList)
        linearLayout.addView(beneficiariesRecycler)
    }

    override fun onItemClick(position: Int, beneficiary: BeneficiariesItem) {

    }
}