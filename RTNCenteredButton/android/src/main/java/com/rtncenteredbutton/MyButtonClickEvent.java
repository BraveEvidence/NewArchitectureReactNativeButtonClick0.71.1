package com.rtncenteredbutton;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;

public class MyButtonClickEvent extends Event<MyButtonClickEvent> {

    public MyButtonClickEvent(int viewId) {
        super(viewId);
    }

    @Override
    public String getEventName() {
        return "topOnClickHandler";
    }

    @Override
    public void dispatchModern(RCTModernEventEmitter rctEventEmitter) {
        super.dispatchModern(rctEventEmitter);
//        rctEventEmitter.receiveEvent(-1,
//                getViewTag(),getEventName(),
//                Arguments.createMap()
//        );
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(),
                Arguments.createMap());
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap event = Arguments.createMap();
        event.putString("message", "MyMessage");
        return event;
    }
}
