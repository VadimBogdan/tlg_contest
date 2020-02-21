package com.example.tlg_contest.widget;

import android.os.SystemClock;

public class AnimationState {

    private static final float DURATION = 300f;

    private final long startedAt;

    AnimationState() {
        this(0f);
    }

    AnimationState(float state) {
        startedAt = SystemClock.elapsedRealtime() - (long) (DURATION * state);
    }

    float getState() {
        float state = (SystemClock.elapsedRealtime() - startedAt) / DURATION;
        return state < 0f ? 0f : (state > 1f ? 1f : state);
    }
}
