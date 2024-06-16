package com.example.beneficiaries.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import com.example.beneficiaries.R

class BeneficiariesRecyclerview(context: Context): LinearLayout(context)  {

    private val textViewTitle: TextView = TextView(context)
    private val textViewFirstName: TextView = TextView(context)
    private val textViewLastName: TextView = TextView(context)
    private val textViewDesignationCode: TextView = TextView(context)
    private val textViewBeneType: TextView = TextView(context)
    private val divider: View = View(context)

    init {
        val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        orientation = VERTICAL
        textViewTitle.layoutParams = layoutParams
        textViewTitle.setPadding(5,5,5,5)
        textViewTitle.text = "Beneficiary:"
        textViewBeneType.tag = "Bene"
        textViewBeneType.layoutParams = layoutParams
        textViewBeneType.setPadding(5,5,5,10)
        textViewLastName.tag = "Last"
        textViewLastName.layoutParams = layoutParams
        textViewLastName.setPadding(5,5,5,5)
        textViewDesignationCode.tag = "Designation"
        textViewDesignationCode.layoutParams = layoutParams
        textViewDesignationCode.setPadding(5,5,5,5)
        textViewFirstName.tag = "First"
        textViewFirstName.layoutParams = layoutParams
        textViewFirstName.setPadding(5,5,5,5)
        divider.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 1)
        divider.setPadding(5,5,5,5)
        divider.background = R.color.black.toDrawable()

        addView(textViewTitle)
        addView(textViewFirstName)
        addView(textViewLastName)
        addView(textViewDesignationCode)
        addView(textViewBeneType)
        addView(divider)
    }
}