package pl.slyberry.series.ui.list.view

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import pl.slyberry.series.common.inflateNoAttach
import pl.slyberry.series.common.layoutInflater

abstract class SimpleRecyclerViewHolder(
    @LayoutRes resId: Int, parent: ViewGroup
) : RecyclerView.ViewHolder(parent.layoutInflater().inflateNoAttach(resId, parent))
