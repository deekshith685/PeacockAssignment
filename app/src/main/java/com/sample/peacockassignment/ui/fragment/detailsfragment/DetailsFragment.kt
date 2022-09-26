package com.sample.peacockassignment.ui.fragment.detailsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.sample.peacockassignment.R
import com.sample.peacockassignment.adapter.recyclerviewadapter.DetailsRecyclerViewAdapter
import com.sample.peacockassignment.data.extension.orDefaultPlaceHolder
import com.sample.peacockassignment.data.model.DetailItem
import com.sample.peacockassignment.databinding.FragmentDetailsBinding
import com.sample.peacockassignment.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment() {

    private var binding: FragmentDetailsBinding? = null

    private val detailsList = mutableListOf<DetailItem>()
    private val adapter = DetailsRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = getArgValues()
        requireActivity().findViewById<Toolbar>(R.id.toolbar)?.title = args?.data?.missionName
        setToolbar(true, args?.data?.missionName.orDefaultPlaceHolder())
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getArgValues(): DetailsFragmentArgs? {
        val args: DetailsFragmentArgs? by navArgs()
        return args
    }

    private fun initViews() {
        detailsList.clear()
        detailsList.addAll(getArgValues()?.data?.getDetails().orEmpty())

        binding?.rvDetails?.apply {
            adapter = this@DetailsFragment.adapter.apply {
                setData(detailsList)
            }
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}
