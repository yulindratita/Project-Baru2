package com.titacolls.app.ui.komunitas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.titacolls.app.R
import com.titacolls.app.databinding.FragmentKomunitasBinding
import com.titacolls.app.ui.home.MainActivity

class KomunitasFragment : Fragment() {

    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentKomunitasBinding
    private val viewModel: KomunitasViewModel by lazy { KomunitasViewModel() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentKomunitasBinding.inflate(inflater, container, false).apply {
            viewModel = this@KomunitasFragment.viewModel
            lifecycleOwner = this@KomunitasFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerView.adapter = KomunitasAdapter(parent)
        viewModel.listKomunitas()
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner) {

        }

        viewModel.actionState.observe(viewLifecycleOwner) {
            if (it.isConsumed) {
                Log.i("ActionState", "isConsumed")
            } else if (it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}