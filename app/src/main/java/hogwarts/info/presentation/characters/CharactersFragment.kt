package hogwarts.info.presentation.characters

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
import hogwarts.info.databinding.FragmentCharactersBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_characters) {
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<CharactersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.getCharacters()
        }

        viewModel.charactersLiveData.observe(viewLifecycleOwner) {
//            when (it) {
//                is Resource.Error -> {
//                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
//                }
//                is Resource.Success -> {
//                    val adapter = CharacterAdapter(it.data ?: listOf())
//                    binding.rvCharacters.adapter = adapter
//                    binding.progress.visibility = View.GONE
//                }
//
//                is Resource.Loading -> {
//                    binding.progress.visibility = View.VISIBLE
//                }
//            }
            if (it is Resource.Error) {
                Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
            } else if (it is Resource.Success) {
                val adapter = CharacterAdapter(it.data ?: listOf())
                binding.rvCharacters.adapter = adapter
                binding.progress.visibility = View.GONE
            } else if (it is Resource.Loading)
                binding.progress.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}