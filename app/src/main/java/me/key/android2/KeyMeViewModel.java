package me.key.android2;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

/**
 * Created by andrew.madden on 8/27/16.
 *
 * http://tech.vg.no/2015/07/17/android-databinding-goodbye-presenter-hello-viewmodel/
 */
public abstract class KeyMeViewModel {
    protected FocusChangeListener focusChangeListener;
    protected EditTextActionListener actionListener;

    public interface FocusChangeListener {
        void setFocus(int layoutId);
    }

    public interface EditTextActionListener {
        void lastFieldAction(int layoutId);
    }

    public EditTextActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(EditTextActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public FocusChangeListener getFocusChangeListener() {
        return focusChangeListener;
    }

    public void setFocusChangeListener(FocusChangeListener focusChangeListener) {
        this.focusChangeListener = focusChangeListener;
    }

    public boolean editTextAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_GO) {
            if (getActionListener() != null) {
                getActionListener().lastFieldAction(textView.getId());
                return true;
            }
        }
        return false;
    }
}
