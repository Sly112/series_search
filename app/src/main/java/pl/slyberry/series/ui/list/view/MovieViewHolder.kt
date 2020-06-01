package pl.slyberry.series.ui.list.view

import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import pl.slyberry.series.R
import pl.slyberry.series.databinding.MovieViewHolderBinding

internal class MovieViewHolder(parent: ViewGroup) :
    SimpleRecyclerViewHolder(R.layout.movie_view_holder, parent) {

    fun applyViewEntity(viewEntity: MovieViewEntity, onClick: (MovieViewEntity) -> Unit) {
        val context = itemView.context
        itemView.setOnClickListener { onClick(viewEntity) }
        with(MovieViewHolderBinding.bind(itemView)) {
            title.text = viewEntity.name
            category.text = viewEntity.category
            Glide.with(itemView.context)
                .load(viewEntity.image)
                .centerCrop()
                .placeholder(ColorDrawable(ContextCompat.getColor(context, R.color.gray)))
                .into(image)
        }
    }
}
