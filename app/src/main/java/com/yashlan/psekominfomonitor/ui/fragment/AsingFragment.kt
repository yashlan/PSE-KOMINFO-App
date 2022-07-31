package com.yashlan.psekominfomonitor.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yashlan.psekominfomonitor.BuildConfig
import com.yashlan.psekominfomonitor.adapter.ListPSEAdapter
import com.yashlan.psekominfomonitor.data.model.PSE
import com.yashlan.psekominfomonitor.databinding.FragmentAsingBinding
import com.yashlan.psekominfomonitor.ui.view.model.PSEViewModel
import com.yashlan.psekominfomonitor.ui.view.modelfactory.PSEViewModelFactory
import com.yashlan.psekominfomonitor.utils.showToast

class AsingFragment : Fragment() {

    private var page = 0
    private var _binding: FragmentAsingBinding? = null
    private val binding get() = _binding!!
    private val pseViewModel: PSEViewModel by viewModels {
        PSEViewModelFactory("${BuildConfig.BASE_URL}/ASING_TERDAFTAR/0.json")
    }
    private val listPSEAsing = ArrayList<PSE>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAsingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            binding.rvAsing.layoutManager = LinearLayoutManager(context)
            pseViewModel.getPSE(
                onSuccess = {
                    if(it != null) {
                        Log.d("data_here", it.data.toString())
                        it.data.forEach { d ->
                            listPSEAsing.add(PSE(
                                nama = d.attributes.nama,
                                website = d.attributes.website,
                                sektor = d.attributes.sektor,
                                namaPerusahaan = d.attributes.namaPerusahaan,
                                tanggalDaftar = d.attributes.tanggalDaftar,
                                statusId = d.attributes.statusId
                            ))
                        }
                        binding.rvAsing.adapter = ListPSEAdapter(listPSEAsing)
                    } else {
                        showToast("data kosong")
                    }
                },
                onFailed = {
                    if(it != null) {
                        showToast(it)
                    }
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val DEFAULT_PAGE = "0.json"
    }
}