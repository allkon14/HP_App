package hogwarts.info.presentation.chooser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import hogwarts.info.R
import hogwarts.info.databinding.FragmentChooserBinding
import hogwarts.info.presentation.characters.CharactersFragment
import hogwarts.info.presentation.spells.SpellsFragment


class ChooserFragment : Fragment(R.layout.fragment_chooser) {
    private var _binding: FragmentChooserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnCharacters.setOnClickListener {
                navigateTo(CharactersFragment())
            }
            btnSpells.setOnClickListener {
                navigateTo(SpellsFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateTo(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = parentFragmentManager
            .beginTransaction()
        fragmentTransaction.replace(
            R.id.fragment_container_view, fragment
        )
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}