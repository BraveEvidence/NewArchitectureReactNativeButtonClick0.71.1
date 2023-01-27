package com.rtncenteredbutton;

import androidx.annotation.Nullable;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Color;

import android.widget.TextView;
import android.view.Gravity;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;

public class CenteredButton extends androidx.appcompat.widget.AppCompatButton {

    public CenteredButton(Context context) {
        super(context);
        this.configureComponent();
    }

    public CenteredButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.configureComponent();
    }

    public CenteredButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.configureComponent();
    }

    private void configureComponent() {
        this.setBackgroundColor(Color.RED);
        this.setGravity(Gravity.CENTER_HORIZONTAL);
        setOnClickListener(view -> {
            ReactContext reactContext = (ReactContext)getContext();
            EventDispatcher eventDispatcher = UIManagerHelper.getEventDispatcherForReactTag(
                    reactContext ,getId()
            );
            eventDispatcher.dispatchEvent(new MyButtonClickEvent(getId()));
        });
    }
}