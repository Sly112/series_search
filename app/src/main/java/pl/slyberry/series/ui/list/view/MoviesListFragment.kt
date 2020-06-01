package pl.slyberry.series.ui.list.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.map
import org.koin.android.viewmodel.ext.android.viewModel
import pl.slyberry.series.R
import pl.slyberry.series.common.*
import pl.slyberry.series.databinding.MoviesListFragmentBinding
import pl.slyberry.series.ui.Navigation
import pl.slyberry.series.ui.Status
import pl.slyberry.series.ui.list.presentation.MoviesListViewModel

class MoviesListFragment : ViewEventFragment<MoviesListViewEvent>(R.layout.movies_list_fragment) {

    override val viewModel by viewModel<MoviesListViewModel>()
    private val binding by viewBinding(MoviesListFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val adapter = MoviesAdapter()
            moviesList.adapter = adapter

            viewModel.state.observeKt(viewLifecycleOwner) {
                adapter.setNewItems(it.movies.map { it.toViewEntity() })
                when (it.status) {
                    Status.IDLE -> showIdle()
                    Status.SYNCING -> showSyncing()
                    Status.ERROR -> showError()
                }
                if (it.navigation == Navigation.MOVIE) navigateToStream()
            }

            requireNotNull(searchInput.editText).afterTextChange { SearchViewEvent(it).emitToChannel() }
            adapter.changes().map { SelectMovieViewEvent }.emitToChannel()
        }
    }

    private fun navigateToStream() {
        findNavController().navigate(R.id.navigate_to_stream_fragment)
        NavigatedToMovieViewEvent.emitToChannel()
    }

    private fun showIdle() {
        binding.progressBar.makeGone()
        binding.searchInput.error = null
    }

    private fun showSyncing() {
        binding.progressBar.makeVisible()
        binding.searchInput.error = null
    }

    private fun showError() {
        binding.progressBar.makeGone()
        binding.searchInput.error = getString(R.string.request_error)
    }
}
