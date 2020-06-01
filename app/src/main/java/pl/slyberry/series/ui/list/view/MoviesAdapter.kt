package pl.slyberry.series.ui.list.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow

internal class MoviesAdapter : RecyclerView.Adapter<SimpleRecyclerViewHolder>() {

    private var items = emptyList<MovieViewEntity>()

    private val channel = Channel<MovieViewEntity>()

    fun setNewItems(newItems: List<MovieViewEntity>) {
        val result = DiffUtil.calculateDiff(
            MoviesDiffUtils(
                items,
                newItems
            )
        )
        items = newItems
        result.dispatchUpdatesTo(this)
    }

    fun changes() = channel.consumeAsFlow()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRecyclerViewHolder {
        return MovieViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SimpleRecyclerViewHolder, position: Int) {
        (holder as MovieViewHolder).applyViewEntity(items[position % items.size]) {
            channel.offer(it)
        }
    }
}
