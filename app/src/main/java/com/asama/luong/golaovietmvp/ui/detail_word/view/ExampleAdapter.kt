package com.asama.luong.golaovietmvp.ui.detail_word.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asama.luong.golaovietmvp.R
import com.asama.luong.golaovietmvp.data.model.Example
import kotlinx.android.synthetic.main.item_meanword.view.*

class ExampleAdapter(
    private val examList: MutableList<Example>
) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder =
        ExampleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_meanword, parent, false))

    override fun getItemCount(): Int = examList.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    internal fun addToExampleList(exams: List<Example>) {
        this.examList.addAll(exams)
        notifyDataSetChanged()
    }

    inner class ExampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.txtmean.text = ""
            itemView.txtex.text = ""
            itemView.txtextran.text = ""
        }

        fun onBind(position: Int) {
            val (mean, ex, extran) = examList[position]

            inflateData(mean!!, ex!!, extran!!)
        }

        private fun inflateData(mean: String, ex: String, extran: String) {
            itemView.txtmean.text = mean
            itemView.txtex.text = ex
            itemView.txtextran.text = extran
        }
    }

}