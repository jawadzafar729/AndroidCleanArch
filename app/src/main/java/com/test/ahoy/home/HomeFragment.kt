package com.test.ahoy.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.test.ahoy.R
import com.test.ahoy.core.data.Resource
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.core.ui.ChargingStationAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val chargingStationAdapter = ChargingStationAdapter { item -> showDetail(item) }

            homeViewModel.station.observe(viewLifecycleOwner, { station ->
                if (station != null) {
                    when (station) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            chargingStationAdapter.setData(station.data)
                        }
                        is Resource.Error -> {
                            progress_bar.visibility = View.GONE
                            view_error.visibility = View.VISIBLE
                            tv_error.text = station.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(rv_chargin_station) {
                layoutManager = GridLayoutManager(requireContext(), 2)
                setHasFixedSize(true)
                adapter = chargingStationAdapter
            }
        }
    }

    private fun showDetail(chargingStation: ChargingStation) {
        Timber.d("OnClick : ${chargingStation.canonicalTitle}")
        this.findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToDetailAnimeActivity(chargingStation))
    }
}