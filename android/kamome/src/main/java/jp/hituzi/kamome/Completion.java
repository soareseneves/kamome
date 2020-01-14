package jp.hituzi.kamome;

import android.support.annotation.Nullable;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONObject;

import jp.hituzi.kamome.internal.Messenger;

public final class Completion implements ICompletion {

    private final WebView webView;
    private final String requestId;
    private boolean completed;

    Completion(WebView webView, String requestId) {
        this.webView = webView;
        this.requestId = requestId;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void resolve() {
        resolve((JSONObject) null);
    }

    @Override
    public void resolve(@Nullable JSONObject data) {
        if (completed) {
            return;
        }

        completed = true;

        Messenger.completeMessage(webView, data, requestId);
    }

    @Override
    public void resolve(@Nullable JSONArray data) {
        if (completed) {
            return;
        }

        completed = true;

        Messenger.completeMessage(webView, data, requestId);
    }

    @Override
    public void reject() {
        reject(null);
    }

    @Override
    public void reject(@Nullable String errorMessage) {
        if (completed) {
            return;
        }

        completed = true;

        Messenger.failMessage(webView, errorMessage, requestId);
    }
}
