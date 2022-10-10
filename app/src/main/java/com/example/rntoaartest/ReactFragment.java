package com.example.rntoaartest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

public abstract class ReactFragment extends Fragment {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;
    private Bundle mBundle;

    public abstract String getMainComponentName();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mReactRootView = new ReactRootView(context);
    }

    public void setmReactInstanceManager(ReactInstanceManager mReactInstanceManager, Bundle bundle) {
        this.mReactInstanceManager = mReactInstanceManager;
        mBundle = bundle;
    }

    @Nullable
    @Override
    public ReactRootView onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return mReactRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mReactRootView.startReactApplication(
                mReactInstanceManager,
                getMainComponentName(),
                mBundle
        );
    }
}

