package com.rtncenteredbutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RTNCenteredButtonManagerInterface;
import com.facebook.react.viewmanagers.RTNCenteredButtonManagerDelegate;

import java.util.Map;

@ReactModule(name = CenteredButtonManager.NAME)
public class CenteredButtonManager extends SimpleViewManager<CenteredButton>
        implements RTNCenteredButtonManagerInterface<CenteredButton> {

    private final ViewManagerDelegate<CenteredButton> mDelegate;

    static final String NAME = "RTNCenteredButton";

    public CenteredButtonManager(ReactApplicationContext context) {
        mDelegate = new RTNCenteredButtonManagerDelegate<>(this);
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<CenteredButton> getDelegate() {
        return mDelegate;
    }

    @NonNull
    @Override
    public String getName() {
        return CenteredButtonManager.NAME;
    }

    @NonNull
    @Override
    protected CenteredButton createViewInstance(@NonNull ThemedReactContext context) {
        return new CenteredButton(context);
    }

    @Override
    @ReactProp(name = "text")
    public void setText(CenteredButton view, @Nullable String text) {
        view.setText(text);
    }

    @Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("topOnClickHandler",
                MapBuilder.of("registrationName", "onClickHandler")
        );
    }
}