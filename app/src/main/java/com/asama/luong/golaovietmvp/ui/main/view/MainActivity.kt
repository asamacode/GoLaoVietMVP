package com.asama.luong.golaovietmvp.ui.main.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.asama.luong.golaovietmvp.R
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.about.view.AboutFragment
import com.asama.luong.golaovietmvp.ui.base.view.BaseActivity
import com.asama.luong.golaovietmvp.ui.detail_word.view.DetailWordActivity
import com.asama.luong.golaovietmvp.ui.main.interactor.MainMVPInteractor
import com.asama.luong.golaovietmvp.ui.main.presenter.MainMVPPresenter
import com.asama.luong.golaovietmvp.util.ToastUtil
import com.asama.luong.golaovietmvp.util.extension.addFragment
import com.asama.luong.golaovietmvp.util.extension.removeFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView,
    NavigationView.OnNavigationItemSelectedListener {

    @Inject
    internal lateinit var mPresenter : MainMVPPresenter<MainMVPView, MainMVPInteractor>

//    @Inject
//    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

// de sau them HasSupportFragmentInjection
//    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector


    override fun openTranslateFragment() {

    }

    override fun openAboutFragment() {
        lockDrawer()
        supportFragmentManager.addFragment(R.id.about_fragment, AboutFragment.newInstance(), AboutFragment.TAG)
    }

    override fun openRateUsFragment() {

    }

    override fun setRandomWordUI(wordFull: WordFull) {
        txtWordSG.text = wordFull.word
        txtWordSpell.text = "/${wordFull.spell}/"
        txtMeanSG.text = wordFull.commonmean

        card_top_main.setOnClickListener {
            val intent = DetailWordActivity.newIntent(this, wordFull)
            startActivity(intent)
        }
    }

    override fun handleError(throwable: Throwable) {
        ToastUtil.showToast(this, throwable.message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpDrawerMenu()

        mPresenter.onAttach(this)

        mPresenter.receiveRandomWordData()
    }

    private fun setUpDrawerMenu() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun lockDrawer(): Unit? = drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    override fun unlockDrawer(): Unit? = drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        val fragment = supportFragmentManager.findFragmentByTag(AboutFragment.TAG)
        fragment?.let {
            onFragmentDetached(AboutFragment.TAG)
        } ?: super.onBackPressed()
    }

    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager.removeFragment(tag = tag)
        unlockDrawer()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_trans -> {
                mPresenter.onDrawerTranslateClick()
            }
            R.id.nav_about -> {
                mPresenter.onDrawerOptionAboutClick()
            }
            R.id.nav_share -> {
                mPresenter.onDrawerOptionRateUsClick()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}
