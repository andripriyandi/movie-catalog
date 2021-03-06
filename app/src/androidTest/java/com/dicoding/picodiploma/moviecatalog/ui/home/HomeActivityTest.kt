package com.dicoding.picodiploma.moviecatalog.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.dicoding.picodiploma.moviecatalog.R
import com.dicoding.picodiploma.moviecatalog.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTv = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetail() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.bgPoster)).check(matches(isDisplayed()))

        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.tvRelease)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRelease)).check(matches(withText(dummyMovie[0].release)))

        onView(withId(R.id.tvDuration)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDuration)).check(matches(withText(dummyMovie[0].duration)))

        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView((withId(R.id.tvGenre))).check(matches(withText(dummyMovie[0].genre)))

        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }
}