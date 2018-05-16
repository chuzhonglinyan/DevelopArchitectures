package com.yuntian.newsframe.ui.video.inject;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.basedragger2.scope.ActivityScope;
import com.yuntian.baselibs.adapter.BaseFPageAdapter;
import com.yuntian.baselibs.adapter.BaseFPageStateAdapter;
import com.yuntian.newsframe.ui.video.mvp.VideoContract;
import com.yuntian.newsframe.ui.video.mvp.VideoModel;
import com.yuntian.newsframe.ui.video.mvp.VideoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * description .
 * Created by ChuYingYan on 2018/5/1.
 */
@Module
public class VideoModule {


    private VideoContract.View view;

    public VideoModule(VideoContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    VideoContract.Model provideModel(VideoModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    VideoContract.View provideView() {
        return this.view;
    }


    @ActivityScope
    @Provides
    VideoContract.Presenter providePresenter(VideoPresenter presenter) {
        return presenter;
    }

    @ActivityScope
    @Provides
    BaseRvAdapter provideBaseAdapter() {
        return new BaseRvAdapter() {};
    }


    @ActivityScope
    @Provides
    BaseFPageStateAdapter provideBaseFPageStateAdapter() {
        return new BaseFPageStateAdapter(getFragmentActivty());
    }

    @ActivityScope
    @Provides
    BaseFPageAdapter provideBaseFPageAdapter() {
        return new BaseFPageAdapter(getFragmentActivty());
    }


    public FragmentActivity getFragmentActivty() {
        if (view instanceof FragmentActivity) {
            return (FragmentActivity) view;
        } else if (view instanceof Fragment) {
            return ((Fragment) view).getActivity();
        }
        return null;
    }


}
