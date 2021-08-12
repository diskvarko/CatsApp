package com.numbers.catsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.retrofittest.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragment() : Fragment() {

    private val catListViewModel: CatViewModel by viewModels()
    {
        MainViewModelFactory(Repository())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSave = view.findViewById<Button>(R.id.save_button)
        val fragment = ListFragment()

        catListViewModel.getCats()
        val list: RecyclerView = view.findViewById(R.id.recycler_list)
        val adapter = CatAdapter(requireContext())

        list.adapter = adapter
        list.layoutManager =
            GridLayoutManager(requireContext(),2)

        catListViewModel.catLiveData.observe(viewLifecycleOwner) {
            (adapter as CatAdapter).setCatsList(it)
        }

        buttonSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                catListViewModel.saveImage(
                    Glide.with(fragment)
                        .asBitmap()
                        .load("https://i.imgur.com/4HFRb2z.jpg") // sample image
                        .placeholder(android.R.drawable.progress_indeterminate_horizontal) // need placeholder to avoid issue like glide annotations
                        .error(android.R.drawable.stat_notify_error) // need error to avoid issue like glide annotations
                        .submit()
                        .get()
                )
            }
        }
    }


}