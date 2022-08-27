package com.wanAndroid.profile.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.wanAndroid.imageservice.usecase.GetImageService
import com.wanAndroid.imageservice.usecase.model.ImageRequest
import com.wanAndroid.profile.view.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment: Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var getImageService:GetImageService

    private val viewModel:ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOberser()
        viewModel.getPhoto()
    }

    fun initOberser(){
        viewModel.banner.observe(viewLifecycleOwner, Observer { path->
            context?.let {
//                Log.d( "youkypath",path)
                getImageService(it, ImageRequest(url = path), binding.banner)
            }
        })

    }
}