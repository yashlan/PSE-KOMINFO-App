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
import com.yashlan.psekominfomonitor.databinding.FragmentDomestikBinding
import com.yashlan.psekominfomonitor.ui.view.model.PSEViewModel
import com.yashlan.psekominfomonitor.ui.view.modelfactory.PSEViewModelFactory
import com.yashlan.psekominfomonitor.utils.showToast

class DomestikFragment : Fragment() {

    private var page = 0
    private var _binding: FragmentDomestikBinding? = null
    private val binding get() = _binding!!
    private val pseViewModel: PSEViewModel by viewModels {
        PSEViewModelFactory("${BuildConfig.BASE_URL}/LOKAL_TERDAFTAR/0.json")
    }
    private val listPSEDomestik = ArrayList<PSE>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDomestikBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            binding.rvDomestik.layoutManager = LinearLayoutManager(context)
            pseViewModel.getPSE(
                onSuccess = {
                    if (it != null) {
                        Log.d("data_here", it.data.toString())
                        it.data.forEach { d ->
                            listPSEDomestik.add(
                                PSE(
                                    nama = d.attributes.nama,
                                    website = d.attributes.website,
                                    sektor = d.attributes.sektor,
                                    namaPerusahaan = d.attributes.namaPerusahaan,
                                    tanggalDaftar = d.attributes.tanggalDaftar,
                                    statusId = d.attributes.statusId
                                )
                            )
                        }
                        binding.rvDomestik.adapter = ListPSEAdapter(listPSEDomestik)
                    } else {
                        showToast("data kosong")
                    }
                },
                onFailed = {
                    if (it != null) {
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
}