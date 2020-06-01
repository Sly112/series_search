package pl.slyberry.series.ui.stream

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import org.koin.android.ext.android.inject
import pl.slyberry.series.R
import pl.slyberry.series.common.viewBinding
import pl.slyberry.series.databinding.MovieFragmentBinding
import pl.slyberry.series.ui.Navigation

/**
 * This class should normally contain view model as it is presented in MoviesListFragment.
 */
class StreamFragment : Fragment(R.layout.movie_fragment) {

    private val binding by viewBinding(MovieFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val player = SimpleExoPlayer.Builder(requireContext()).build()
        binding.playerView.player = player

        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(requireContext(), getString(R.string.app_name))
        )
        val uri =
            Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        val videoSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(uri)
        player.prepare(videoSource)
        player.playWhenReady = true
    }

    override fun onPause() {
        super.onPause()
        binding.playerView.player?.release()
    }
}