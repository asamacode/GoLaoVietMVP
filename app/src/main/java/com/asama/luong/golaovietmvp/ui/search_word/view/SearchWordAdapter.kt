package com.asama.luong.golaovietmvp.ui.search_word.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asama.luong.golaovietmvp.R
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.detail_word.view.DetailWordActivity
import kotlinx.android.synthetic.main.item_search.view.*

class SearchWordAdapter(
    private val listWord: MutableList<WordFull>
) : RecyclerView.Adapter<SearchWordAdapter.SearchWordViewHolder>() {

    inner class SearchWordViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.txtWordSearch.text = ""
            itemView.txtMeanSearch.text = ""
        }

        fun onBind(position: Int) {
            val (word, mean) = listWord[position]
            inflateData(word!!, mean!!)

            setItemClickListener(listWord[position])
        }

        private fun setItemClickListener(wordFull: WordFull) {

            itemView.setOnClickListener {
                wordFull.let {
                    val intent = DetailWordActivity.newIntent(itemView.context, wordFull)
                    itemView.context.startActivity(intent)
                }
            }
        }

        private fun inflateData(word: String, mean: String) {
            word.let { itemView.txtWordSearch.text = it }
            mean.let { itemView.txtMeanSearch.text = it }
        }
    }

    internal fun addWordToList(wordFulls: List<WordFull>) {
        this.listWord.clear()
        this.listWord.addAll(wordFulls)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchWordViewHolder = SearchWordViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false))

    override fun getItemCount(): Int = listWord.size

    override fun onBindViewHolder(holder: SearchWordViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }
}