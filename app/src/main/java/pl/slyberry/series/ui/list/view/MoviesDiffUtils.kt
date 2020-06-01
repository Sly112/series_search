package pl.slyberry.series.ui.list.view

import androidx.recyclerview.widget.DiffUtil

internal class MoviesDiffUtils(
    private val oldList: List<MovieViewEntity>,
    private val newList: List<MovieViewEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
