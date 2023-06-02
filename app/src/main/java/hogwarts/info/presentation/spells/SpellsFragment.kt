package hogwarts.info.presentation.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import hogwarts.info.R
import hogwarts.info.data.utils.Resource
import hogwarts.info.databinding.FragmentSpellsBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SpellsFragment : Fragment(R.layout.fragment_spells) {
    private var _binding: FragmentSpellsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<SpellsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpellsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.getSpells()
        }

        viewModel.spellsLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                }

                is Resource.Success -> {
                    val adapter = SpellAdapter(it.data ?: listOf())
                    binding.rvSpells.adapter = adapter
                    binding.progress.visibility = View.GONE
                }

                is Resource.Loading -> {
                    binding.progress.visibility = View.VISIBLE
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}