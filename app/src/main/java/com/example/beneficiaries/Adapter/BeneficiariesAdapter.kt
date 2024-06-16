package com.example.beneficiaries.Adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiaries.Model.BeneficiariesItem
import com.example.beneficiaries.view.BeneficiariesRecyclerview

private const val CONTINGENT = "Contingent"
private const val PRIMARY = "Primary"
class BeneficiariesAdapter(
    private val beneficiaryList: List<BeneficiariesItem>
) : RecyclerView.Adapter<BeneficiariesAdapter.ViewHolder>() {

    private var onClick: OnItemClick? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewLastName: TextView = itemView.findViewWithTag("Last")
        var textViewFirstName: TextView = itemView.findViewWithTag("First")
        var textViewDesignationCode: TextView =
            itemView.findViewWithTag("Designation")
        var textViewBeneType: TextView = itemView.findViewWithTag("Bene")
    }

    interface OnItemClick {
        fun onItemClick(position: Int, beneficiary: BeneficiariesItem)
    }




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = BeneficiariesRecyclerview(parent.context)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beneficiaryModel = beneficiaryList[position]
        with(beneficiaryModel) {
            holder.textViewFirstName.text = "First Name: $firstName"
            holder.textViewLastName.text = "Last Name: $lastName"
            holder.textViewDesignationCode.text = "Designation: ".plus(
                if (designationCode.contains("C", true))
                    CONTINGENT
                else PRIMARY
            )
            holder.textViewBeneType.text = "Benefit Type: $beneType"
            holder.itemView.setOnClickListener {
                onClick?.onItemClick(position, beneficiaryList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return beneficiaryList.size
    }

    fun setClickListener(onClickListener: OnItemClick) {
        onClick = onClickListener
    }
}