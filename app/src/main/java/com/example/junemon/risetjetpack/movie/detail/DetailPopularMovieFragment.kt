package com.example.junemon.risetjetpack.movie.detail

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.Toast
import com.example.junemon.risetjetpack.R
import com.example.junemon.risetjetpack.database.model.DetailMovieModelClass
import com.example.junemon.risetjetpack.database.model.SimilarMovieModelClass
import com.example.junemon.risetjetpack.databinding.ItemSharedMovieDetailBinding
import com.example.junemon.risetjetpack.movie.detail.similarmovie.SimilarMovieAdapter
import com.example.junemon.risetjetpack.movie.detail.similarmovie.SimilarMovieClickListener

class DetailPopularMovieFragment : Fragment(), DetailPopularMovieView {

    private lateinit var similiarAdapter: SimilarMovieAdapter
    private var ctx: Context? = null
    private lateinit var actualView: View
    private lateinit var presenter: DetailPopularMoviePresenter
    private lateinit var binding: ItemSharedMovieDetailBinding
    private lateinit var detailData: DetailMovieModelClass

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.ctx = context
        presenter = DetailPopularMoviePresenter(this, this)
        presenter.onAttach(ctx)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args = DetailPopularMovieFragmentArgs.fromBundle(arguments)
        presenter.getDataDetail(args.movieId)
        presenter.getSimilarMovie(args.movieId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.item_shared_movie_detail, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_save_data, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menuSaveData -> {
                Toast.makeText(ctx, "Comming Soon", Toast.LENGTH_SHORT).show()
                true
            }
            else -> return super.onOptionsItemSelected(item)

        }
    }

    override fun getSimilarMovie(data: List<SimilarMovieModelClass.Result>?) {
        binding.rvSimilarMovie.layoutManager = LinearLayoutManager(ctx)
        similiarAdapter = SimilarMovieAdapter(ctx, data!!)
        binding.rvSimilarMovie.adapter = similiarAdapter

        similiarAdapter.setOnItemClickListener(object : SimilarMovieClickListener {
            override fun onClick(view: View, data: SimilarMovieModelClass.Result) {
                Toast.makeText(ctx, "Comming Soon", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun getDetailPopularMovie(data: DetailMovieModelClass?) {
        binding.detailPopularMovie = data
    }

    override fun initView(view: View) {
        actualView = view
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }


}