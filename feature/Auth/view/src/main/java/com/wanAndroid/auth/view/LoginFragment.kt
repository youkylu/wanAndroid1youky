package com.wanAndroid.auth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.wanAndroid.auth.view.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener {
            viewModel.login(
                binding.textInputEditTextUserName.text.toString(),
                binding.textInputEditTextPassword.text.toString()
            )
        }
        addOberserver()
    }

    fun addOberserver() {
        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            user?.let {
                if (user.username.isNotEmpty()) {
                    viewModel.changeLoginState(true)
                    Toast.makeText(context, "${user.username} is login", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}