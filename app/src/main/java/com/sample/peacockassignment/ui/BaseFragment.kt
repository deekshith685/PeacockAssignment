package com.sample.peacockassignment.ui

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sample.peacockassignment.NavigationManager
import com.sample.peacockassignment.R
import javax.inject.Inject

open class BaseFragment : Fragment() {

    var navigationManager: NavigationManager? = null
        @Inject set

    private var canNavigateBack: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback {
            if (canNavigateBack) {
                findNavController().navigateUp()
            }
        }
    }

    fun setToolbar(canNavigateBack: Boolean, title: String) {
        this.canNavigateBack = canNavigateBack
        setHasOptionsMenu(canNavigateBack)
        with(requireActivity().findViewById<Toolbar>(R.id.toolbar)) {
            this.title = title
            navigationIcon = if (canNavigateBack) {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_arrow_back)
            } else null
        }
    }
}